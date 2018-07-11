package Funcionamento;

import java.util.Date;

public class Item {
    private Integer idItem;
    private String titulo;
    private String descricao;
    private String links;
    private Date dataInicial;
    private Date dataAtualizacao;
    private Integer idCriador;

    public Item(String titulo, String descricao, String links, Date dataInicial, Date dataAtualizacao, Integer idCriador) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.links = links;
        this.dataInicial = dataInicial;
        this.dataAtualizacao = dataAtualizacao;
        this.idCriador = idCriador;
    }

    public Item() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Integer getIdCriador() {
        return idCriador;
    }

    public void setIdCriador(Integer idCriador) {
        this.idCriador = idCriador;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }
    
    
}
