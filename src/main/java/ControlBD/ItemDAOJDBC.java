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

    public ItemDAOJDBC() throws Exception {
        conexao = BdConnection.getConnection();
        operacaoInsereItem = conexao.prepareStatement("insert into item (titulo, descricao, links, dataInicial, fk_codigoCriador) values (?, ?, ?, ?, ?)");
        operacaoListar = conexao.prepareStatement("select codigoItem, titulo, descricao, links, dataInicial, dataAtualizacao from item where fk_codigoCriador = ?");
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
    
}
