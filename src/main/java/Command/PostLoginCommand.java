package Command;

import ControlBD.UsuarioDAO;
import ControlBD.UsuarioDAOJDBC;
import Funcionamento.Usuario;
import java.io.IOException;
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
            System.out.println("q");
            Usuario usuario = uDAO.achar(email, password);
            System.out.println("q2");
            HttpSession session = request.getSession();
            session.setAttribute("authUser", usuario.getNome());
            session.setAttribute("idUser", usuario.getId());
            response.sendRedirect("index.html");
            return;
        }
        catch (Exception ex)
        {
            response.sendRedirect("login.html");
        }
    }
}
