package controller;

import controller.Command.*;
import controller.Command.admin.AdminCancelShowtime;
import controller.Command.admin.AdminMoviesCommand;
import controller.Command.admin.AdminNewMovie;
import controller.Command.admin.AdminNewShowtime;
import controller.Command.user.UserBuyTicketCommand;
import controller.Command.user.UserTicketsCommand;
import model.entity.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Servlet extends HttpServlet {
//    private Map<String, Command> commands = new HashMap<>();
    private static Map<String, Command> defaultScope = new HashMap<>();
    private static Map<String, Command> userScope = new HashMap<>();
    private static Map<String, Command> adminScope = new HashMap<>();

    public void init(ServletConfig servletConfig){
        servletConfig.getServletContext().setAttribute("loggedUsers", new HashSet<String>());
        defaultScope.put("register", new RegisterCommand());
        defaultScope.put("login", new LoginCommand());

        defaultScope.put("logout", new LogoutCommand());
        defaultScope.put("exception" , new ExceptionCommand());


        defaultScope.put("getShowtimes", new GetShowtimesCommand());


        defaultScope.put("getShowtimesInfo", new GetShowtimesInfoCommand());

        userScope.putAll(defaultScope);
        userScope.put("myTickets", new UserTicketsCommand());
        userScope.put("buyTicket", new UserBuyTicketCommand());

        adminScope.putAll(userScope);
        adminScope.put("getMovies", new AdminMoviesCommand());
        adminScope.put("newMovie", new AdminNewMovie());
        adminScope.put("cancelShowtime", new AdminCancelShowtime());
        adminScope.put("newShowtime", new AdminNewShowtime());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        handleRequest(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
         handleRequest(request, response);

    }

    Command handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Command command;
        String rolePath = request.getParameter("command");
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
//        path = path.replaceAll(".*/cinema/" , "");
//        Command command = commands.getOrDefault(path, (req, resp) ->"/index.jsp");
//        System.out.println(command.getClass().getName());
//        String page = command.execute(request, response);
//        request.getRequestDispatcher(page).forward(request,response);
        if (user == null){
            command = defaultScope.get(rolePath);
        } else {
            if (user.getIsAdmin()){
                command = adminScope.get(rolePath);
            } else {
                command = userScope.get(rolePath);
            }
        }

        if (command == null){
            command = new RolePathCommand();
        }

        return command;
    }
    }



