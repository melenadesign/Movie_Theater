package controller.Command;

import model.entity.User;
import model.service.ServiceException;
import model.service.UserService;
import model.service.impl.UserServiceImp;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginCommand implements Command {
    private static Logger log = Logger.getLogger(LoginCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String pass = request.getParameter("password");

        UserService userService = new UserServiceImp();

        User user = null;
        if (request.getMethod().equals("GET")){
            request.getSession().setAttribute("resPage", "/WEB-INF/login.jsp");
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        if(!CommandUtil.checkUserIsLogged(request, name)){

            request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);

        }

        try {
            user = userService.login(name, pass);
        } catch (ServiceException e) {
            log.error("Could not login user ", e);
        }


        if (user != null){
            request.getSession().setAttribute("user", user);
            new RolePathCommand().execute(request, response);
        }else {
            request.setAttribute("errorMessage", true);
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }


//        return "/login.jsp";


    }
}
