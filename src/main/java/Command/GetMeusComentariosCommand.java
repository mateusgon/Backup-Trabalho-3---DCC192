package Command;

import ControlBD.AvaliarComentarioDAO;
import ControlBD.AvaliarComentarioDAOJDBC;
import ControlBD.ComentarioDAO;
import ControlBD.ComentarioDAOJDBC;
import ControlBD.ItemDAO;
import ControlBD.ItemDAOJDBC;
import Funcionamento.AvaliarComentario;
import Funcionamento.Comentario;
import Funcionamento.Item;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetMeusComentariosCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("authUser");
        Integer id = (Integer) session.getAttribute("idUser");
        if (username != null || !username.isEmpty()) {
            try {
                ComentarioDAO cDAO = new ComentarioDAOJDBC();
                List<Integer> idItens = cDAO.localizaItemUsuario(id);
                ArrayList<Item> itens = new ArrayList<>();
                ItemDAO iDAO = new ItemDAOJDBC();
                for (Integer idIten : idItens) {
                    Item item = new Item();
                    item = iDAO.exibirItem(id, idIten);
                    itens.add(item);
                }
                Boolean logado = true;
                request.setAttribute("itens", itens);
                request.setAttribute("logado", logado);
                RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/meus-comentarios.jsp");
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
