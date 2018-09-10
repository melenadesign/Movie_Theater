package controller.Command;

import model.service.ServiceException;
import model.service.ShowtimeService;
import model.service.impl.ShowtimeServiceImp;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetShowtimeInfoCommand implements Command {
    private static Logger log = Logger.getLogger(GetShowtimeInfoCommand.class);

    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int showtimeId = Integer.valueOf(req.getParameter("showtimeId"));

        PrintWriter printWriter = resp.getWriter();

        ShowtimeService service = new ShowtimeServiceImp();

        resp.setContentType("application/json");

        try {
            printWriter.print(service.getShowtimeInfoJson(showtimeId));
        } catch (ServiceException e) {
            log.error("Cant print text response", e);
        }
    }
}
