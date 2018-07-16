package Command;

import ControlBD.ItemDAO;
import ControlBD.ItemDAOJDBC;
import Funcionamento.Item;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetItemEditarCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("authUser");
        Integer id = (Integer) session.getAttribute("idUser");
        if (username != null || !username.isEmpty()) {
            try {
                Integer id2 = Integer.parseInt(request.getParameter("item"));
                ItemDAO iDAO = new ItemDAOJDBC();
                Item item = new Item();
                item = iDAO.exibirItem(id, id2);
                Boolean logado = true;
                request.setAttribute("item", item);
                request.setAttribute("logado", logado);
                RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/item-alterar.jsp");
                dispacher.forward(request, response);
                return;
            } catch (Exception ex) {
                
               response.sendRedirect("erro.html");
            }
        }

    }
}
