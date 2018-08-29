package controller;

import controller.Command.Command;
import controller.Command.ExceptionCommand;
import controller.Command.LoginCommand;
import controller.Command.LogoutCommand;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Servlet extends HttpServlet {
    private Map<String, Command> commands = new HashMap<>();

    public void init(ServletConfig servletConfig){
        servletConfig.getServletContext().setAttribute("loggedUsers", new HashSet<String>());

        commands.put("login", new LoginCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("exception" , new ExceptionCommand());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        handleRequest(request, response);
        //response.getWriter().print("Hello from doGet");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        handleRequest(request, response);
        //response.getWriter().print("Hello from doPost");
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String path = request.getRequestURI();
        path = path.replaceAll(".*/cinema/" , "");
        Command command = commands.getOrDefault(path, req ->"/index.jsp");
        System.out.println(command.getClass().getName());
        String page = command.execute(request);
        request.getRequestDispatcher(page).forward(request,response);
    }


}
