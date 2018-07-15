package ControlBD;

import Funcionamento.Item;
import Funcionamento.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOJDBC implements UsuarioDAO{

    private Connection conexao;
    private PreparedStatement operacaoInsereUsuario;
    private PreparedStatement operacaoListarUsuario;
    private PreparedStatement operacaoListarUsuario2;
    private PreparedStatement operacaoListarTodos;

    public UsuarioDAOJDBC() {
        try
        {
            conexao = BdConnection.getConnection();
            operacaoInsereUsuario = conexao.prepareStatement("insert into usuario (nome, nomeUsuario, email, senha) values (?, ?, ?, ?)");
            operacaoListarUsuario = conexao.prepareStatement("select codigoUsuario from usuario where email = ? and senha = ?");
            operacaoListarUsuario2 = conexao.prepareStatement("select codigoUsuario, nome, nomeUsuario from usuario where email = ? and senha = ?");
            operacaoListarTodos = conexao.prepareStatement("select codigoUsuario, nome, nomeUsuario, email, senha from usuario");
        }
        catch (Exception ex)
        {
            
        }
    }

    @Override
    public int criar(String nome, String nomeUsuario, String email, String senha) throws Exception {
        operacaoInsereUsuario.clearParameters();
        operacaoListarUsuario.clearParameters();
        operacaoInsereUsuario.setString(1, nome);
        operacaoInsereUsuario.setString(2, nomeUsuario);
        operacaoInsereUsuario.setString(3, email);
        operacaoInsereUsuario.setString(4, senha);
        operacaoInsereUsuario.executeUpdate();
        operacaoListarUsuario.setString(1, email);
        operacaoListarUsuario.setString(2, senha);
        ResultSet resultado = operacaoListarUsuario.executeQuery();
        resultado.next();
        Integer id = resultado.getInt("codigoUsuario");
        return id;
    }

    @Override
    public Usuario achar(String email, String senha) throws Exception {
        operacaoListarUsuario2.clearParameters();
        operacaoListarUsuario2.setString(1, email);
        operacaoListarUsuario2.setString(2, senha);
        ResultSet resultado = operacaoListarUsuario2.executeQuery();
        resultado.next();
        Integer id = resultado.getInt("codigoUsuario");
        String nome = resultado.getString("nome");
        String nomeUsuario = resultado.getString("nomeUsuario");
        Usuario usuario = new Usuario(id, nome, nomeUsuario, email, senha);
        return usuario;
    }

    @Override
    public List<Usuario> listAll() throws Exception {
        operacaoListarTodos.clearParameters();
        List<Usuario> usuarios = new ArrayList<>();
        ResultSet resultado = operacaoListarTodos.executeQuery();
        while (resultado.next()) {
            Integer id = resultado.getInt("codigoUsuario");
            String nome = resultado.getString("nome");
            String nomeUsuario = resultado.getString("nomeUsuario");
            String email = resultado.getString("email");
            String senha = resultado.getString("senha");
            Usuario usuario = new Usuario(id, nome, nomeUsuario, email, senha);
            usuarios.add(usuario);
        }
        return usuarios;
    }
    
}
