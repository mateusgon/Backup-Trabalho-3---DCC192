package Command;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetIndexCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("authUser");
        Integer id = (Integer) session.getAttribute("idUser");
        if (username == null || username.isEmpty()) {
            Boolean logado = false;
            request.setAttribute("logado", logado);
            RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/index.jsp");
            dispacher.forward(request, response);
            return;
        }
        request.setAttribute("authUser", username);
        request.setAttribute("idUser", id);
        Boolean logado = true;
        request.setAttribute("logado", logado);
        RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/index.jsp");
        dispacher.forward(request, response);
    }
    
}
