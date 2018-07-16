package Command;

import ControlBD.AvaliarComentarioDAO;
import ControlBD.AvaliarComentarioDAOJDBC;
import ControlBD.AvaliarItemDAO;
import ControlBD.AvaliarItemDAOJDBC;
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

public class GetItemExcluirCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("authUser");
        Integer id = (Integer) session.getAttribute("idUser");
        if (username != null || !username.isEmpty()) {
            try {
                Integer id2 = Integer.parseInt(request.getParameter("item"));
                AvaliarComentarioDAO aDAO = new AvaliarComentarioDAOJDBC();
                AvaliarItemDAO aIDAO = new AvaliarItemDAOJDBC();
                ComentarioDAO cDAO = new ComentarioDAOJDBC();
                ItemDAO iDAO = new ItemDAOJDBC();
                List<Comentario> comentarios = cDAO.listarComentariosItem(id2);
                for (Comentario comentario : comentarios) {
                    aDAO.excluir(comentario.getId());
                }
                cDAO.excluir(id2);
                aIDAO.excluir(id2);
                iDAO.excluirItem(id2);
                List<Item> itens = iDAO.listarItensUsuario(id);
                Boolean logado = true;
                request.setAttribute("itens", itens);
                request.setAttribute("logado", logado);
                response.sendRedirect("item-listar.html");
                return;
            } catch (Exception ex) {
               response.sendRedirect("erro.html");
            }

        }

    }
}
