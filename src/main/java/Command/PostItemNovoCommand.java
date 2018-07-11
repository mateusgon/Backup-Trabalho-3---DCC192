package Command;

import ControlBD.ItemDAO;
import ControlBD.ItemDAOJDBC;
import ControlBD.UsuarioDAO;
import ControlBD.UsuarioDAOJDBC;
import Funcionamento.Usuario;
import java.io.IOException;
import java.text.ParseException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PostItemNovoCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try
        {
            HttpSession session = request.getSession();
            Integer idUsuario = (Integer) session.getAttribute("idUser");
            System.out.println(idUsuario);
            ItemDAO iDAO = new ItemDAOJDBC();
            String titulo = request.getParameter("titulo");
            String descricao = request.getParameter("descricao");
            String url = request.getParameter("url");
            iDAO.criar(titulo, descricao, url, idUsuario);
            response.sendRedirect("index.html");
        }
        catch(Exception ex)
        {
            request.setAttribute("cadastro", false);
            RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/usuario-novo.jsp");
            dispacher.forward(request, response);
        }

    }
    
}
