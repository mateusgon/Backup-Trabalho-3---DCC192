package Command;

import ControlBD.ComentarioDAO;
import ControlBD.ComentarioDAOJDBC;
import ControlBD.ItemDAO;
import ControlBD.ItemDAOJDBC;
import Funcionamento.Comentario;
import Funcionamento.Item;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetItemListarCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("authUser");
        Integer id = (Integer) session.getAttribute("idUser");
        if (username != null || !username.isEmpty()) {
            try {
                Boolean comentarioJaFeito = false;
                Boolean comentarioJaFeito2 = false;
                ComentarioDAO cDAO = new ComentarioDAOJDBC();
                ItemDAO iDAO = new ItemDAOJDBC();
                Integer id2 = Integer.parseInt(request.getParameter("item"));
                Boolean logado = true;
                Item item = new Item();
                item = iDAO.exibirItem(id, id2);
                List<Comentario> comentarios = cDAO.listarComentariosItem(id2);
                for (Comentario comentario : comentarios) {
                    if(comentario.getIdUsuario() == id)
                    {
                        comentarioJaFeito2 = true;
                        break;
                    }
                }
                if (item.getIdCriador() == id)
                {
                    comentarioJaFeito = true;
                }
                request.setAttribute("feito", comentarioJaFeito);
                request.setAttribute("feito2", comentarioJaFeito2);
                request.setAttribute("comentarios", comentarios);
                request.setAttribute("item", item);
                request.setAttribute("logado", logado);
                RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/item-listar.jsp");
                dispacher.forward(request, response);
                return;
            } catch (Exception ex) {

            }
        }
        else
        {
            response.sendRedirect("index.html");
            return;
        }
    }

}
    
