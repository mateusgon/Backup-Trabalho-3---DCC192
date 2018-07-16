package Command;

import ControlBD.ComentarioDAO;
import ControlBD.ComentarioDAOJDBC;
import ControlBD.ItemDAO;
import ControlBD.ItemDAOJDBC;
import ControlBD.UsuarioDAO;
import ControlBD.UsuarioDAOJDBC;
import Funcionamento.Comentario;
import Funcionamento.Item;
import Funcionamento.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetCuradoresCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = "Qualquer";
        Integer id = null;
        if (username != null || !username.isEmpty()) {
            {
                try {
                    ItemDAO iDAO = new ItemDAOJDBC();
                    ComentarioDAO cDAO = new ComentarioDAOJDBC();
                    UsuarioDAO uDAO = new UsuarioDAOJDBC();
                    List<Item> auxItens = new ArrayList<>();
                    List<Item> itens = iDAO.listarAllItens();
                    List<Comentario> comentarios2 = new ArrayList<>();
                    for (Item iten : itens) {
                        iten = iDAO.exibirItem(id, iten.getIdItem());
                        auxItens.add(iten);
                        List<Comentario> comentarios = cDAO.listarComentariosItem(iten.getIdItem());
                        for (Comentario comentario : comentarios) {
                            comentarios2.add(comentario);
                        }
                    }
                    List<Usuario> usuario = new ArrayList<>();
                    usuario = uDAO.listAll();
                    for (Comentario comentario : comentarios2) {
                        for (Usuario user : usuario) {
                            if (comentario.getIdUsuario() == user.getId())
                            {
                                user.setComentariosPositivos(user.getComentariosPositivos() + comentario.getPositivo());
                            }
                        }
                    }
                    Collections.sort(usuario, new Comparator() {
                        public int compare(Object o1, Object o2) {
                            Usuario p1 = (Usuario) o1;
                            Usuario p2 = (Usuario) o2;
                            return p1.getComentariosPositivos()> p2.getComentariosPositivos() ? -1 : (p1.getComentariosPositivos() < p2.getComentariosPositivos()? +1 : 0);
                        }
                    });
                    Boolean logado = true;
                    request.setAttribute("usuarios", usuario);
                    request.setAttribute("logado", logado);
                    RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/curadores.jsp");
                    dispacher.forward(request, response);
                    return;
                }
                catch(Exception ex)
                {               
                    response.sendRedirect("erro.html");
                }

            }
        }
    }
}
