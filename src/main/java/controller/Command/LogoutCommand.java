package controller.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutCommand implements Command {
//    private static Logger log = Logger.getLogger(LoginCommand.class);
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
//        CommandUtil.setUserRole(request, User.ROLE.GUEST, "Guest");
        request.getSession().removeAttribute("user");
        try {
            new RolePathCommand().execute(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        return "/index.jsp";

    }
}
