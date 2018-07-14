package Command;

import ControlBD.ItemDAO;
import ControlBD.ItemDAOJDBC;
import ControlBD.UsuarioDAO;
import ControlBD.UsuarioDAOJDBC;
import Funcionamento.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PostItemAlterarCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try
        {
            ItemDAO iDAO = new ItemDAOJDBC();
            
            String titulo = request.getParameter("titulo");
            String descricao = request.getParameter("descricao");
            String url = request.getParameter("url");
            Integer id = Integer.parseInt(request.getParameter("idItem"));
            iDAO.alterar(id, titulo, descricao, url);
            
            response.sendRedirect("meus-itens.html");
        }
        catch(Exception ex)
        {
            response.sendRedirect("meus-itens.html");
        }
    }
    
}
