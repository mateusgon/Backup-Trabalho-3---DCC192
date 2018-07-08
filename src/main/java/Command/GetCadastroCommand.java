package Command;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCadastroCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("cadastro", true);
        RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/usuario-novo.jsp");
        dispacher.forward(request, response);
    }
    
}
