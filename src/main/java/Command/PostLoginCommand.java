package Command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PostLoginCommand implements Comando{
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ("usuario".equals(username) && "senha".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("authUser", username);
            response.sendRedirect("index.html");
            return;
        } 
    }
}
