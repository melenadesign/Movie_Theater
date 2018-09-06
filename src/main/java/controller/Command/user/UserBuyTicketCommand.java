package controller.Command.user;

import controller.Command.Command;
import model.entity.Showtime;
import model.entity.User;
import model.service.ServiceException;
import model.service.ShowtimeService;
import model.service.TicketService;
import model.service.impl.ShowtimeServiceImp;
import model.service.impl.TicketServiceImp;
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
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer showtimeId = Integer.valueOf(req.getParameter("showtimeId"));

        if (req.getMethod().equals("GET")){
            req.getSession().setAttribute("id", showtimeId);
            req.getSession().setAttribute("resPage", "/WEB-INF/user/buy_ticket.jsp");
            req.getRequestDispatcher("/WEB-INF/user/buy_ticket.jsp").forward(req, resp);
//            return ("/WEB-INF/user/buy_ticket.jsp");
        }

        if(isShowtimeBegin(showtimeId)){
            req.setAttribute("ShowtimeBeginMessage", true);
            req.getSession().setAttribute("showtimeId", showtimeId);
            req.getSession().setAttribute("resPage", "/WEB-INF/user/buy_ticket.jsp");
            req.getRequestDispatcher("/WEB-INF/user/buy_ticket.jsp").forward(req, resp);
//            return ("/WEB-INF/user/buy_ticket.jsp");
        }

        User user = (User) req.getSession().getAttribute("user");
        String[] ticketIdString = req.getParameterValues("seatId");

        if (ticketIdString == null){
            req.getSession().setAttribute("showtimeId", showtimeId);
            req.getSession().setAttribute("resPage", "/WEB-INF/user/buy_ticket.jsp");
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
            return ;
        }

        req.getSession().setAttribute("resPage", "/WEB-INF/user/user_tickets.jsp");
        req.getRequestDispatcher("/WEB-INF/user/user_tickets.jsp").forward(req, resp);
    }

    private boolean isShowtimeBegin(int showtimeId) throws ServletException {
        ShowtimeService ShowtimeService = new ShowtimeServiceImp();
        Showtime Showtime;
        try {
            Showtime = ShowtimeService.getShowtimeById(showtimeId);
        } catch (ServiceException e) {
            log.error("Could not get Showtime by id" + showtimeId, e);
            throw new ServletException("Could not get Showtime by id" + showtimeId, e);
        }

        Timestamp beginShowtime = new Timestamp(Showtime.getStartTime().getTime()+Showtime.getDate().getTime());
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());

        return beginShowtime.before(currentTime);
    }

}
