package Funcionamento;

import java.util.List;

public class Usuario {
    private Integer id;
    private String nome;
    private String nomeUsuario;
    private String email;
    private String senha;
    private List<Item> itens;

    public Usuario(Integer id, String nome, String nomeUsuario, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(Integer id, String nome, String nomeUsuario, String email, String senha, List<Item> itens) {
        this.id = id;
        this.nome = nome;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
        this.itens = itens;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
