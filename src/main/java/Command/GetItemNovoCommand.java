package Command;

import java.io.IOException;
import java.text.ParseException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetItemNovoCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("authUser");
        Integer id = (Integer) session.getAttribute("id");
        if (username != null || !username.isEmpty()) {
            Boolean logado = true;
            request.setAttribute("logado", logado);
            RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/item-novo.jsp");
            dispacher.forward(request, response);
            return;
        }
        else
        {
            response.sendRedirect("index.html");
            return;
        }
    }
    
}
