package Command;

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

public class GetItemExcluirCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("authUser");
        Integer id = (Integer) session.getAttribute("idUser");
        if (username != null || !username.isEmpty()) {
            try {
                Integer id2 = Integer.parseInt(request.getParameter("item"));
                ItemDAO iDAO = new ItemDAOJDBC();
                iDAO.excluirItem(id2);
                List<Item> itens = iDAO.listarItensUsuario(id);
                Boolean logado = true;
                request.setAttribute("itens", itens);
                request.setAttribute("logado", logado);
                RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/meus-itens.jsp");
                dispacher.forward(request, response);
                return;
            } catch (Exception ex) {

            }

        }

    }
}
