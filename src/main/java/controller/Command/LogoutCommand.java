package controller.Command;

import model.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        CommandUtil.setUserRole(request, User.ROLE.GUEST, "Guest");
        return "/index.jsp";
    }
}
