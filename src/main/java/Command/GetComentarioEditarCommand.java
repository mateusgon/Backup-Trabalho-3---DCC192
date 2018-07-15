package Command;

import ControlBD.ComentarioDAO;
import ControlBD.ComentarioDAOJDBC;
import ControlBD.ItemDAO;
import ControlBD.ItemDAOJDBC;
import Funcionamento.Comentario;
import Funcionamento.Item;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetComentarioEditarCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("authUser");
        Integer id = (Integer) session.getAttribute("idUser");
        if (username != null || !username.isEmpty()) {
            try {
                Integer idItem = Integer.parseInt(request.getParameter("item"));
                Integer idComentario = Integer.parseInt(request.getParameter("comentario"));        
                Boolean logado = true;
                ComentarioDAO cDAO = new ComentarioDAOJDBC();
                Comentario comentario = cDAO.listarEspecifico(idComentario);
                request.setAttribute("comentario", comentario);
                request.setAttribute("logado", logado);
                RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/comentario-alterar.jsp");
                dispacher.forward(request, response);
                return;
            } catch (Exception ex) {

            }
        }

    }
    
}
