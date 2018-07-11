package Command;

import java.io.IOException;
import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Comando {
    void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
