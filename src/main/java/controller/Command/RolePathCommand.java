package controller.Command;

import model.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RolePathCommand implements Command{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
//||  user.isAdmin()== null deleted

        if(user == null ){
            request.getSession().setAttribute("resPage", "/WEB-INF/index.jsp");
            request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
//            return null;
        }


        if(user.getIsAdmin()){
            request.getSession().setAttribute("resPage", "/WEB-INF/admin/index.jsp");
            request.getRequestDispatcher("/WEB-INF/admin/index.jsp").forward(request, response);

        } else {
            request.getSession().setAttribute("resPage", "/WEB-INF/user/index.jsp");
            request.getRequestDispatcher("/WEB-INF/user/index.jsp").forward(request, response);
        }
//        return null;

    }
}
