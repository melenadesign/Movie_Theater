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
<<<<<<< HEAD

            return "/login.jsp";
        }
        System.out.println(name + " " + pass);

=======
            //System.out.println("Not logged in");
            return "/login.jsp";
        }
        System.out.println(name + " " + pass);
        //System.out.println("login success!");
//todo: check login with DB
>>>>>>> e917ae97c38a952990409d57a27eb88f8c567a44

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
