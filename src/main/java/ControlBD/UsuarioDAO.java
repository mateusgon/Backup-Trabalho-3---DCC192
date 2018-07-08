package ControlBD;

import Funcionamento.Usuario;

public interface UsuarioDAO {
    public int criar (String nome, String nomeUsuario, String email, String senha) throws Exception;
    public Usuario achar (String email, String senha) throws Exception;
}
