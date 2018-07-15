package Command;

import ControlBD.ItemDAO;
import ControlBD.ItemDAOJDBC;
import Funcionamento.Item;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetRankingCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("authUser");
        Integer id = (Integer) session.getAttribute("idUser");
        String ordem = request.getParameter("ordem");
        if (username != null || !username.isEmpty()) {
        {
            try {
                ItemDAO iDAO = new ItemDAOJDBC();

                if (ordem.equals("default")) 
                {
                    List<Item> itens = iDAO.listarAllItens();
                    Boolean logado = true;
                    request.setAttribute("itens", itens);
                    request.setAttribute("logado", logado);
                    RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/ranking.jsp");
                    dispacher.forward(request, response);
                    return;
                } 
                else if (ordem.equals("navaliacao")) 
                {
                    List<Item> auxItens = new ArrayList<>();
                    List<Item> itens = iDAO.listarAllItens();
                    for (Item iten : itens) {
                        iten = iDAO.exibirItem(id, iten.getIdItem());
                        auxItens.add(iten);
                    }
                    Collections.sort(auxItens, new Comparator() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        Item p1 = (Item) o1;
                        Item p2 = (Item) o2;
                        return p1.getPositivo()+p1.getNegativo() > p2.getPositivo()+p2.getNegativo() ? -1 : (p1.getNegativo()+p1.getPositivo() < p2.getNegativo()+p2.getPositivo() ? +1 : 0);
                                }
                            });
                    Boolean logado = true;
                    request.setAttribute("itens", auxItens);
                    request.setAttribute("logado", logado);
                    RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/ranking.jsp");
                    dispacher.forward(request, response);
                    return;        
                }
                else if (ordem.equals("melhoravaliacao")) 
                {
                    List<Item> auxItens = new ArrayList<>();
                    List<Item> itens = iDAO.listarAllItens();
                    for (Item iten : itens) {
                        iten = iDAO.exibirItem(id, iten.getIdItem());
                        auxItens.add(iten);
                    }
                    Collections.sort (auxItens, new Comparator() {
                    public int compare(Object o1, Object o2) {
                    Item p1 = (Item) o1;
                    Item p2 = (Item) o2;
                    return p1.getPositivo() > p2.getPositivo() ? -1 : (p1.getPositivo() < p2.getPositivo() ? +1 : 0);
                        }
                    });
                    Boolean logado = true;
                    request.setAttribute("itens", auxItens);
                    request.setAttribute("logado", logado);
                    RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/ranking.jsp");
                    dispacher.forward(request, response);
                    return;
                } 
                else if (ordem.equals("datacriacao")) 
                {
                    List<Item> itens = iDAO.listarAllItensOrdemDataInicial();
                    for (Item iten : itens) {
                        iten = iDAO.exibirItem(id, iten.getIdItem());
                    }
                    Boolean logado = true;
                    request.setAttribute("itens", itens);
                    request.setAttribute("logado", logado);
                    RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/ranking.jsp");
                    dispacher.forward(request, response);
                    return; 
                }
                else 
                { 
                    List<Item> itens = iDAO.listarAllItensOrdemDataFinal();
                    for (Item iten : itens) {
                        iten = iDAO.exibirItem(id, iten.getIdItem());
                    }
                    Boolean logado = true;
                    request.setAttribute("itens", itens);
                    request.setAttribute("logado", logado);
                    RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/ranking.jsp");
                    dispacher.forward(request, response);
                    return; 
                }
            } catch (Exception ex) {
                
            }
        }
        } else {
            response.sendRedirect("index.html");
            return;
        }
    }
}
