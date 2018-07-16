package Command;

import ControlBD.AvaliarComentarioDAO;
import ControlBD.AvaliarComentarioDAOJDBC;
import ControlBD.AvaliarItemDAO;
import ControlBD.AvaliarItemDAOJDBC;
import ControlBD.ComentarioDAO;
import ControlBD.ComentarioDAOJDBC;
import ControlBD.ItemDAO;
import ControlBD.ItemDAOJDBC;
import Funcionamento.Item;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetAAvaliarCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("authUser");
        Integer id = (Integer) session.getAttribute("idUser");
        if (username != null || !username.isEmpty()) {
            try {
                AvaliarComentarioDAO aDAO = new AvaliarComentarioDAOJDBC();
                List<Integer> idComentarios = aDAO.listarComentarioUsuario(id);
                ComentarioDAO cDAO = new ComentarioDAOJDBC();
                List<Integer> idItens = cDAO.localizaItemLista(idComentarios);
                ArrayList<Item> itens = new ArrayList<>();
                ItemDAO iDAO = new ItemDAOJDBC();
                AvaliarItemDAO aCDAO = new AvaliarItemDAOJDBC();
                List<Integer> idItensComentarios = aCDAO.listarItemUsuario(id);
                for (Integer idIten : idItens) {
                    Item item = new Item();
                    item = iDAO.exibirItem(id, idIten);
                    itens.add(item);
                }
                List<Item> itens3 = new ArrayList<>();
                List<Item> itens2 = iDAO.listarAllItens();
                for (Item item : itens2) {
                    Boolean aComentar = true;
                    for (Item iten : itens) {
                        if (item.getIdItem() == iten.getIdItem())
                        {
                            aComentar = false;
                        }
                    }
                    for (Integer integer : idItensComentarios)
                    {
                        if(item.getIdItem() == integer)
                        {
                            aComentar = false;
                        }
                    }
                    if(aComentar)
                    {
                        itens3.add(item);
                    }
                }
                Boolean logado = true;
                request.setAttribute("itens", itens3);
                request.setAttribute("logado", logado);
                RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/a-avaliar.jsp");
                dispacher.forward(request, response);
                return;
            } catch (Exception ex) {
                response.sendRedirect("erro.html");
            }
        }
        else
        {
            response.sendRedirect("index.html");
            return;
        }
    }
    
}
