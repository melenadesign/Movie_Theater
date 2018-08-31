package controller.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExceptionCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        throw new RuntimeException("Command exception");
    }
}
