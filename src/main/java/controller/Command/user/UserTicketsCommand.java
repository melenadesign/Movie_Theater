package controller.Command.user;

import controller.Command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserTicketsCommand implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("resPage", "/WEB-INF/user/tickets.jsp");
        req.getRequestDispatcher("/WEB-INF/user/tickets.jsp").forward(req, resp);
        return ("/WEB-INF/user/tickets.jsp");
    }
}
