package Command;

import ControlBD.ComentarioDAO;
import ControlBD.ComentarioDAOJDBC;
import ControlBD.ItemDAO;
import ControlBD.ItemDAOJDBC;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PostComentarCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            Integer idUsuario = (Integer) session.getAttribute("idUser");
            String comentario = request.getParameter("comentario");
            Integer idItem = Integer.parseInt(request.getParameter("item"));
            
            ComentarioDAO cDAO = new ComentarioDAOJDBC();
            cDAO.criar(comentario, idUsuario, idItem);
            response.sendRedirect("item-listar.html?item=" + idItem);
        } catch (Exception ex) {
            response.sendRedirect("index.html");
        }
        

    }
    
}
