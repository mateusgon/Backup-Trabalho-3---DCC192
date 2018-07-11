package Command;

import ControlBD.UsuarioDAO;
import ControlBD.UsuarioDAOJDBC;
import Funcionamento.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PostLoginCommand implements Comando{
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try
        {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            UsuarioDAO uDAO = new UsuarioDAOJDBC();
            Usuario usuario = uDAO.achar(email, password);
            HttpSession session = request.getSession();
            session.setAttribute("authUser", usuario.getNome());
            session.setAttribute("idUser", usuario.getId());
            response.sendRedirect("index.html");
        }
        catch (Exception ex)
        {
            Boolean login = false;
            request.setAttribute("login", login);
            RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/login.jsp");
            dispacher.forward(request, response);
        }
    }
}
