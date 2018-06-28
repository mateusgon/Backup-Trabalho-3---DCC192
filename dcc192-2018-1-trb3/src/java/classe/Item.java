/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;

import java.util.Date;

/**
 *
 * @author cassio
 */
public class Item {
     private int codigoItem;
    private String tituloItem;
    private String descricaoItem;
    private String linkItem;
    private Date dataCriacaoItem;
    private Date dataUltimaAtualizacaoItem;
    private Usuario criadorSistemaItem;

    public Item(int codigoItem, String tituloItem, String descricaoItem, String linkItem, Date dataCriacaoItem, Date dataUltimaAtualizacaoItem, Usuario criadorSistemaItem) {
        this.codigoItem = codigoItem;
        this.tituloItem = tituloItem;
        this.descricaoItem = descricaoItem;
        this.linkItem = linkItem;
        this.dataCriacaoItem = dataCriacaoItem;
        this.dataUltimaAtualizacaoItem = dataUltimaAtualizacaoItem;
        this.criadorSistemaItem = criadorSistemaItem;
    }

    public int getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(int codigoItem) {
        this.codigoItem = codigoItem;
    }

    public String getTituloItem() {
        return tituloItem;
    }

    public void setTituloItem(String tituloItem) {
        this.tituloItem = tituloItem;
    }

    public String getDescricaoItem() {
        return descricaoItem;
    }

    public void setDescricaoItem(String descricaoItem) {
        this.descricaoItem = descricaoItem;
    }

    public String getLinkItem() {
        return linkItem;
    }

    public void setLinkItem(String linkItem) {
        this.linkItem = linkItem;
    }

    public Date getDataCriacaoItem() {
        return dataCriacaoItem;
    }

    public void setDataCriacaoItem(Date dataCriacaoItem) {
        this.dataCriacaoItem = dataCriacaoItem;
    }

    public Date getDataUltimaAtualizacaoItem() {
        return dataUltimaAtualizacaoItem;
    }

    public void setDataUltimaAtualizacaoItem(Date dataUltimaAtualizacaoItem) {
        this.dataUltimaAtualizacaoItem = dataUltimaAtualizacaoItem;
    }

    public Usuario getCriadorSistemaItem() {
        return criadorSistemaItem;
    }

    public void setCriadorSistemaItem(Usuario criadorSistemaItem) {
        this.criadorSistemaItem = criadorSistemaItem;
    }

    public Item() {
    }
    
   
}
