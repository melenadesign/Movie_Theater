package controller.Command.admin;

<<<<<<< HEAD
import controller.Command.Command;
import model.service.ServiceException;
import model.service.ShowtimeService;
import model.service.impl.ShowtimeServiceImp;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminCancelShowtime implements Command {
    Logger log = Logger.getLogger(AdminCancelShowtime.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int showtimeId = Integer.valueOf(req.getParameter("showtimeId"));

        ShowtimeService service = new ShowtimeServiceImp();

        try {
            service.cancelShowtime(showtimeId);
        } catch (ServiceException e) {
            req.setAttribute("errorMessage", true);
            log.error("Could not cancel session by showtimeId" + showtimeId, e);
            req.getSession().setAttribute("resPage", "/WEB-INF/admin/index.jsp");
            req.getRequestDispatcher("/WEB-INF/admin/index.jsp").forward(req, resp);
            return;
        }

        req.getSession().setAttribute("resPage", "/WEB-INF/admin/index.jsp");
        req.getRequestDispatcher("/WEB-INF/admin/index.jsp").forward(req, resp);
    }


}
