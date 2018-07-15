package Funcionamento;

import java.util.Date;

public class Comentario {
    private Integer id;
    private String comentario;
    private Date criacao;
    private Date atualizacao;
    private Integer idItem;
    private Integer idUsuario;
    private Integer positivo;
    private Integer negativo;

    public Comentario() {
    }

    public Comentario(Integer id, String comentario, Date criacao, Date atualizacao, Integer idItem, Integer idUsuario) {
        this.id = id;
        this.comentario = comentario;
        this.criacao = criacao;
        this.atualizacao = atualizacao;
        this.idItem = idItem;
        this.idUsuario = idUsuario;
    }

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getCriacao() {
        return criacao;
    }

    public void setCriacao(Date criacao) {
        this.criacao = criacao;
    }

    public Date getAtualizacao() {
        return atualizacao;
    }

    public void setAtualizacao(Date atualizacao) {
        this.atualizacao = atualizacao;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getPositivo() {
        return positivo;
    }

    public Integer getNegativo() {
        return negativo;
    }
    
    public void setPositivo(Integer positivo)
    {
        this.positivo = positivo;
    }
    
    public void setNegativo(Integer negativo)
    {
        this.negativo = negativo;
    }
}
