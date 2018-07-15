package Command;

import ControlBD.ComentarioDAO;
import ControlBD.ComentarioDAOJDBC;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostComentarioEditarCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try
       {
           ComentarioDAO cDAO = new ComentarioDAOJDBC();
           
           String comentario = request.getParameter("descricao");
           Integer idComentario = Integer.parseInt(request.getParameter("idComentario"));
           Integer idItem = Integer.parseInt(request.getParameter("idItem"));
           cDAO.alterar(idComentario, comentario);
           response.sendRedirect("item-listar.html?item="+idItem);
       }
       catch(Exception ex)
       {
       
       }
    }
    
}
