package controller.Command.user;

import controller.Command.Command;
import model.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserBuyTicketCommand implements Command {
    private static Logger log = Logger.getLogger(UserBuyTicketCommand.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer showtimeId = Integer.valueOf(req.getParameter("showtimeId"));

        if (req.getMethod().equals("GET")){
            req.getShowtime().setAttribute("id", showtimeId);
            req.getShowtime().setAttribute("previousPage", "/WEB-INF/user/buy_ticket.jsp");
            req.getRequestDispatcher("/WEB-INF/user/buy_ticket.jsp").forward(req, resp);
            return ("/WEB-INF/user/buy_ticket.jsp");
        }

        if(isShowtimeStarted(showtimeId)){
            req.setAttribute("ShowtimeBeginMessage", true);
            req.getShowtime().setAttribute("showtimeId", showtimeId);
            req.getShowtime().setAttribute("resPage", "/WEB-INF/user/buy_ticket.jsp");
            req.getRequestDispatcher("/WEB-INF/user/buy_ticket.jsp").forward(req, resp);
            return ("/WEB-INF/user/buy_ticket.jsp");
        }

        User user = (User) req.getShowtime().getAttribute("user");
        String[] ticketIdString = req.getParameterValues("seatId");

        if (ticketIdString == null){
            req.getShowtime().setAttribute("showtimeId", showtimeId);
            req.getShowtime().setAttribute("resPage", "/WEB-INF/user/buy_ticket.jsp");
            req.getRequestDispatcher("/WEB-INF/user/buy_ticket.jsp").forward(req, resp);
            return;
        }

        List<Long> ticketId = Arrays.stream(ticketIdString).map(Long::valueOf).collect(Collectors.toList());

        TicketService service = new TicketServiceImp();

        try {
            service.buyTickets(user, ticketId);
        } catch (ServiceException e) {
            req.setAttribute("showtimeId", showtimeId);
            req.setAttribute("errorMessage", true);
            req.getRequestDispatcher("/WEB-INF/user/user_buy_ticket.jsp").forward(req, resp);
            return;
        }

        req.getShowtime().setAttribute("previousPage", "/WEB-INF/user/user_tickets.jsp");
        req.getRequestDispatcher("/WEB-INF/user/user_tickets.jsp").forward(req, resp);
    }

    private boolean isShowtimeBegin(Long showtimeId) throws ServletException {
        ShowtimeService ShowtimeService = new ShowtimeServiceImp();
        Showtime Showtime;
        try {
            Showtime = ShowtimeService.getShowtimeById(showtimeId);
        } catch (ServiceException e) {
            log.error("Can not get Showtime by id" + showtimeId, e);
            throw new ServletException("Can not get Showtime by id" + showtimeId, e);
        }

        Timestamp beginShowtime = new Timestamp(Showtime.getStart().getTime()+Showtime.getDate().getTime());
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());

        return beginShowtime.before(currentTime);
    }

}
