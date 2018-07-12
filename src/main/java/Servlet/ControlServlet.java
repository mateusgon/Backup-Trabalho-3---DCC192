package Servlet;

import Command.Comando;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControlServlet", urlPatterns = {"/index.html", "/login.html", "/logout.html", "/usuario-novo.html", "/item-novo.html", "/meus-itens.html", "/item-excluir.html", "/item-listar.html", "/item-editar.html"})
public class ControlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Map<String, String> rotas = new HashMap<>();
       rotas.put("/index.html", "Command.GetIndexCommand");
       rotas.put("/login.html", "Command.GetLoginCommand");
       rotas.put("/logout.html", "Command.GetLogoutCommand");
       rotas.put("/usuario-novo.html", "Command.GetCadastroCommand");
       rotas.put("/item-novo.html", "Command.GetItemNovoCommand");
       rotas.put("/meus-itens.html", "Command.GetMeusItensCommand");
       rotas.put("/item-listar.html", "Command.GetItemListarCommand");
       rotas.put("/item-editar.html", "Command.GetItemEditarCommand");
       rotas.put("/item-excluir.html", "Command.GetItemExcluirCommand");
       String clazzName = rotas.get(request.getServletPath());
       try {
            Comando comando = (Comando) Class.forName(clazzName).newInstance();
            comando.exec(request, response);
       } catch (Exception ex) {
            response.sendRedirect("index.html");
       } 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Map<String, String> rotas = new HashMap<>();
       rotas.put("/login.html", "Command.PostLoginCommand");
       rotas.put("/usuario-novo.html", "Command.PostCadastroCommand");
       rotas.put("/item-novo.html", "Command.PostItemNovoCommand");
       String clazzName = rotas.get(request.getServletPath());
       try {
            Comando comando = (Comando) Class.forName(clazzName).newInstance();
            comando.exec(request, response);
       } catch (Exception ex) {
            response.sendRedirect("index.html");
       }
    }
}
