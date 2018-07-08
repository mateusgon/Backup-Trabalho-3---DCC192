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

public class PostCadastroCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try
        {
            Boolean logado = true;
            UsuarioDAO uDAO = new UsuarioDAOJDBC();
            String nomeCompleto = request.getParameter("nome");
            String nomeUsuario = request.getParameter("nomeUsuario");
            String email = request.getParameter("emailUsuario");
            String senha = request.getParameter("senhaUsuario");
            int id = uDAO.criar(nomeCompleto, nomeUsuario, email, senha);
            Usuario usuario = new Usuario(id, nomeCompleto, nomeUsuario, email, senha);
            HttpSession session = request.getSession();
            session.setAttribute("authUser", nomeCompleto);
            session.setAttribute("idUser", id);
            RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/index.jsp");
            request.setAttribute("logado", logado);
            dispacher.forward(request, response);
        }
        catch(Exception ex)
        {
            request.setAttribute("cadastro", false);
            RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/usuario-novo.jsp");
            dispacher.forward(request, response);
        }
    }
    
}
