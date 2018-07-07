package Command;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetLoginCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/login.jsp");
        dispacher.forward(request, response);
    }
    
}
