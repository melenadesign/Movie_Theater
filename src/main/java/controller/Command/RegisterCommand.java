package controller.Command;

import model.dao.EmailExistsException;
import model.entity.User;
import model.service.ServiceException;
import model.service.UserService;
import model.service.impl.UserServiceImp;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterCommand implements Command {
    private static Logger log = Logger.getLogger(RegisterCommand.class);
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name").trim();
        String email = request.getParameter("email").trim();
        String password = request.getParameter("password").trim();

        UserService userService = new UserServiceImp();

        User user;

        try {
            user = userService.addNewUser(name, email, password);
        } catch (ServiceException e) {
            if(e.getCause() instanceof EmailExistsException){
                request.setAttribute("errorMessage", true);
                request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                return;
            }else {
                request.setAttribute("failedRegex", true);
                request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                log.error(e);
                return;
            }
        }

        if (user!=null){
            request.getSession().setAttribute("previousPage", "/WEB-INF/login.jsp");
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }
}
