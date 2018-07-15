package Command;

import ControlBD.AvaliarComentarioDAO;
import ControlBD.AvaliarComentarioDAOJDBC;
import ControlBD.AvaliarItemDAO;
import ControlBD.AvaliarItemDAOJDBC;
import ControlBD.ItemDAO;
import ControlBD.ItemDAOJDBC;
import Funcionamento.AvaliarComentario;
import Funcionamento.AvaliarItem;
import Funcionamento.Item;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetAvaliarCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("authUser");
        Integer id = (Integer) session.getAttribute("idUser");
        if (username != null || !username.isEmpty()) {
            try {
                Integer item = Integer.parseInt(request.getParameter("i"));
                Integer comentar = Integer.parseInt(request.getParameter("c"));
                Integer positivo = Integer.parseInt(request.getParameter("p"));
                Integer negativo = Integer.parseInt(request.getParameter("n"));
                if (comentar == 0)
                {
                    AvaliarItemDAO aDAO = new AvaliarItemDAOJDBC();
                    if(positivo == 1)
                    {
                        try
                        {
                            AvaliarItem valor = aDAO.listar(id, item);
                            if (valor.getPositivo() == 1)
                            {
                                aDAO.alterar(id, item, 0, 0);
                                response.sendRedirect("item-listar.html?item="+item);
                            }
                            else if (valor.getNegativo() == 1)
                            {
                                aDAO.alterar(id, item, 1, 0);
                                response.sendRedirect("item-listar.html?item="+item);
                            }
                            else
                            {
                                aDAO.alterar(id, item, 1, 0);
                                response.sendRedirect("item-listar.html?item="+item);
                            }
                        }
                        catch(Exception ex)
                        {
                            aDAO.criar(id, item, 1, 0);
                            response.sendRedirect("item-listar.html?item="+item);
                        }
                    }
                    else
                    {
                        try
                        {
                            AvaliarItem valor = aDAO.listar(id, item);
                            if(valor.getNegativo() == 1)
                            {
                                aDAO.alterar(id, item, 0, 0);
                                response.sendRedirect("item-listar.html?item="+item);
                            }
                            else if(valor.getPositivo() == 1)
                            {
                                aDAO.alterar(id, item, 0, 1);                                
                                response.sendRedirect("item-listar.html?item="+item);
                            }
                            else
                            {
                                aDAO.alterar(id, item, 0, 1);
                                response.sendRedirect("item-listar.html?item="+item);
                            }
                        }
                        catch(Exception ex)
                        {
                            aDAO.criar(id, item, 0, 1);
                            response.sendRedirect("item-listar.html?item="+item);
                        }
                    }
                }
                else
                {
                    AvaliarComentarioDAO aDAO = new AvaliarComentarioDAOJDBC();
                    if(positivo == 1)
                    {
                        try
                        {
                            AvaliarComentario valor = aDAO.listar(id, comentar);
                            if (valor.getPositivo() == 1)
                            {
                                aDAO.alterar(id, comentar, 0, 0);
                                response.sendRedirect("item-listar.html?item="+item);
                            }
                            else if (valor.getNegativo() == 1)
                            {
                                aDAO.alterar(id, comentar, 1, 0);
                                response.sendRedirect("item-listar.html?item="+item);
                            }
                            else
                            {
                                aDAO.alterar(id, comentar, 1, 0);
                                response.sendRedirect("item-listar.html?item="+item);
                            }
                        }
                        catch(Exception ex)
                        {
                            aDAO.criar(id, comentar, 1, 0);
                            response.sendRedirect("item-listar.html?item="+item);
                        }
                    }
                    else
                    {
                        try
                        {
                            AvaliarComentario valor = aDAO.listar(id, comentar);
                            if(valor.getNegativo() == 1)
                            {
                                aDAO.alterar(id, comentar, 0, 0);
                                response.sendRedirect("item-listar.html?item="+item);
                            }
                            else if(valor.getPositivo() == 1)
                            {
                                aDAO.alterar(id, comentar, 0, 1);
                                response.sendRedirect("item-listar.html?item="+item);
                            }
                            else
                            {
                                aDAO.alterar(id, comentar, 0, 1);
                                response.sendRedirect("item-listar.html?item="+item);
                            }
                        }
                        catch(Exception ex)
                        {
                            aDAO.criar(id, comentar, 0, 1);
                            response.sendRedirect("item-listar.html?item="+item);
                            return;
                        }
                    }
                }
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
