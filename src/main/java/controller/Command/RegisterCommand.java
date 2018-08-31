package controller.Command;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class RegisterCommand implements Command {
    private static Logger log = Logger.getLogger(LoginCommand.class);
    @Override
    public String execute(HttpServletRequest req) throws ServletException, IOException {
        return null;
    }
}
