package Command;

import ControlBD.ItemDAO;
import ControlBD.ItemDAOJDBC;
import Funcionamento.Item;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetRankingCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("authUser");
        String ordenacao ;
        ItemDAO iDAO = null;
        try {
            iDAO = new ItemDAOJDBC();
        } catch (Exception ex) {
            Logger.getLogger(GetRankingCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Item> itens ;
        Integer id = (Integer) session.getAttribute("idUser");
        if(request.getParameter("ordem") == null){
             ordenacao = "Default";
        }
        else{ 
            ordenacao = request.getParameter("codigoItem");
        }
        if (username != null || !username.isEmpty()) {
            try {
                if(ordenacao=="Default"){
                    itens = iDAO.listarAllItensOrdem("codigoItem");
                
                }else{
                    itens = iDAO.listarAllItensOrdem(ordenacao);
                    }
                Boolean logado = true;
                request.setAttribute("itens", itens);
                request.setAttribute("logado", logado);
                RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/ranking.jsp");
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
    

