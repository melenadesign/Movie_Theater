package controller.Command;

import model.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutCommand implements Command {
    private static Logger log = Logger.getLogger(LoginCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        CommandUtil.setUserRole(request, User.ROLE.GUEST, "Guest");
        return "/index.jsp";
    }
}
