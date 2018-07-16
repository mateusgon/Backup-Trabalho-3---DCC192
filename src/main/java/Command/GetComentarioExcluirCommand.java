package Command;

import ControlBD.ComentarioDAO;
import ControlBD.ComentarioDAOJDBC;
import ControlBD.ItemDAO;
import ControlBD.ItemDAOJDBC;
import Funcionamento.Item;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetComentarioExcluirCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("authUser");
        Integer id = (Integer) session.getAttribute("idUser");
        if (username != null || !username.isEmpty()) {
            try {
                Integer idItem = Integer.parseInt(request.getParameter("item"));
                Integer idComentario = Integer.parseInt(request.getParameter("comentario"));
                ComentarioDAO cDAO = new ComentarioDAOJDBC();
                cDAO.excluir2(idComentario);
                response.sendRedirect("item.html?item="+idItem);
                return;
            } catch (Exception ex) {

            }

        }
    }
    
}
