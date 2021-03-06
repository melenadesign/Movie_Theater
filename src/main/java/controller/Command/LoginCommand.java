package controller.Command;

import model.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand implements Command {
    private static Logger log = Logger.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter("name");
        String pass = request.getParameter("password");




        if( name == null || name.equals("") || pass == null || pass.equals("")  ){

            return "/login.jsp";
        }
        System.out.println(name + " " + pass);

//todo: check login with DB

        if(CommandUtil.checkUserIsLogged(request, name)){
            return "/WEB-INF/error.jsp";
        }

        if (name.equals("Admin")){
            CommandUtil.setUserRole(request, User.ROLE.ADMIN, name);
            return "/WEB-INF/admin/admin-index.jsp";
        } else if(name.equals("User")) {
            CommandUtil.setUserRole(request, User.ROLE.USER, name);
            return "/WEB-INF/user/user-index.jsp";
        } else {
            CommandUtil.setUserRole(request, User.ROLE.GUEST, name);
            return "/login.jsp";
        }


    }

}
