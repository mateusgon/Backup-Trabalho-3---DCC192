package ControlBD;

import Funcionamento.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ItemDAOJDBC implements ItemDAO{

    private Connection conexao;
    private PreparedStatement operacaoInsereItem;
    private PreparedStatement operacaoListar;
    private PreparedStatement operacaoListarAll;
    private PreparedStatement operacaoExcluir;
    private PreparedStatement operacaoExibir;

    public ItemDAOJDBC() throws Exception {
        conexao = BdConnection.getConnection();
        operacaoInsereItem = conexao.prepareStatement("insert into item (titulo, descricao, links, dataInicial, fk_codigoCriador) values (?, ?, ?, ?, ?)");
        operacaoListar = conexao.prepareStatement("select codigoItem, titulo, descricao, links, dataInicial, dataAtualizacao "
                + "from item where fk_codigoCriador = ?");
        operacaoListarAll = conexao.prepareStatement("select * from item");
        operacaoExibir = conexao.prepareStatement("select *  from item where codigoItem = ?");
        operacaoExcluir = conexao.prepareStatement("delete from item where codigoItem = ?");
    }
    
    @Override
    public void criar(String titulo, String desricacao, String links, Integer idUsuario) throws Exception{
        operacaoInsereItem.clearParameters();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        Calendar cal = Calendar.getInstance();
        Date data = new Date();
        cal.setTime(data);
        java.sql.Timestamp dataSqlCriacao;
        dataSqlCriacao = new java.sql.Timestamp(data.getTime());
        operacaoInsereItem.setString(1, titulo);
        operacaoInsereItem.setString(2, desricacao);
        operacaoInsereItem.setString(3, links);
        operacaoInsereItem.setTimestamp(4, dataSqlCriacao);
        operacaoInsereItem.setInt(5,idUsuario);
        operacaoInsereItem.executeUpdate();
    }

    @Override
    public List<Item> listarItensUsuario(Integer idUsuario) throws Exception {
        List<Item> itens = new ArrayList<>();
        operacaoListar.clearParameters();
        operacaoListar.setInt(1, idUsuario);
        ResultSet resultado = operacaoListar.executeQuery();
        while (resultado.next())
        {
            Item i = new Item();
            i.setIdItem(resultado.getInt("codigoItem"));
            i.setTitulo(resultado.getString("titulo"));
            i.setDescricao(resultado.getString("descricao"));
            i.setLinks(resultado.getString("links"));
            i.setDataInicial(resultado.getTimestamp("dataInicial"));
            i.setDataAtualizacao(resultado.getTimestamp("dataAtualizacao"));
            itens.add(i);
        }
        return itens;
    }

    @Override
    public List<Item> listarAllItens() throws Exception {
        List<Item> itens = new ArrayList<>();
        operacaoListarAll.clearParameters();
        ResultSet resultado = operacaoListarAll.executeQuery();
        while (resultado.next())
        {
            Item i = new Item();
            i.setIdItem(resultado.getInt("codigoItem"));
            i.setTitulo(resultado.getString("titulo"));
            i.setDescricao(resultado.getString("descricao"));
            i.setLinks(resultado.getString("links"));
            i.setDataInicial(resultado.getTimestamp("dataInicial"));
            i.setDataAtualizacao(resultado.getTimestamp("dataAtualizacao"));
            itens.add(i);
        }
        return itens;
    }

    
    @Override
    public void excluirItem(Integer idItem) throws Exception {
        operacaoExcluir.clearParameters();
        operacaoExcluir.setInt(1, idItem);
        operacaoExcluir.execute();
    }

    @Override
    public Item exibirItem(Integer idItem) throws Exception {
        operacaoExcluir.clearParameters();
        operacaoExibir.setInt(1, idItem);
        operacaoExibir.execute();
        ResultSet resultado = operacaoExibir.executeQuery();
        Item i = new Item();
        while (resultado.next())
        {
            i.setIdItem(resultado.getInt("codigoItem"));
            i.setTitulo(resultado.getString("titulo"));
            i.setDescricao(resultado.getString("descricao"));
            i.setLinks(resultado.getString("links"));
            i.setDataInicial(resultado.getTimestamp("dataInicial"));
            i.setDataAtualizacao(resultado.getTimestamp("dataAtualizacao"));
        }
        return i;
    }
    
}
