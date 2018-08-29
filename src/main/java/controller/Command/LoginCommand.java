package controller.Command;

import model.entity.User;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter("name");
        String pass = request.getParameter("password");




        if( name == null || name.equals("") || pass == null || pass.equals("")  ){
            //System.out.println("Not");
            return "/login.jsp";
        }
        System.out.println(name + " " + pass);
        //System.out.println("Yes!");
//todo: check login with DB

        if(CommandUtil.checkUserIsLogged(request, name)){
            return "/WEB-INF/error.jsp";
        }

        if (name.equals("Admin")){
            CommandUtil.setUserRole(request, User.ROLE.ADMIN, name);
            return "/WEB-INF/admin/admin_index.jsp";
        } else if(name.equals("User")) {
            CommandUtil.setUserRole(request, User.ROLE.USER, name);
            return "/WEB-INF/user/user_index.jsp";
        } else {
            CommandUtil.setUserRole(request, User.ROLE.GUEST, name);
            return "/login.jsp";
        }


    }

}
