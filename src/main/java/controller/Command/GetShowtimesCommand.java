package controller.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class GetShowtimesCommand implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dateOfShowtime = req.getParameter("dateOfShowtime");

        Date date;

        try {
            date = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(dateOfShowtime).getTime());
        } catch (NullPointerException | ParseException e) {
            date = new Date(System.currentTimeMillis());
        }

        req.getSession().setAttribute("dateOfShowtime", date);

        new RolePathCommand().execute(req, resp);
    }
}
