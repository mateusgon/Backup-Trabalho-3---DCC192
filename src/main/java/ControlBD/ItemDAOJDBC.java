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

public class ItemDAOJDBC implements ItemDAO {

    private Connection conexao;
    private PreparedStatement operacaoInsereItem;
    private PreparedStatement operacaoListar;
    private PreparedStatement operacaoListarAllOrdem;
    private PreparedStatement operacaoListarAll;
    private PreparedStatement operacaoExcluir;
    private PreparedStatement operacaoExibir;
    private PreparedStatement operacaoAlterar;
    private PreparedStatement operacaoListarAllOrdemDataInicial;
    private PreparedStatement operacaoListarAllOrdemDataFinal;
    private PreparedStatement operacaoListarAllOrdemCodigo;

    public ItemDAOJDBC() throws Exception {
        conexao = BdConnection.getConnection();
        operacaoInsereItem = conexao.prepareStatement("insert into item (titulo, descricao, links, dataInicial, fk_codigoCriador) values (?, ?, ?, ?, ?)");
        operacaoListar = conexao.prepareStatement("select codigoItem, titulo, descricao, links, dataInicial, dataAtualizacao "
                + "from item where fk_codigoCriador = ?");
        operacaoListarAllOrdemDataInicial = conexao.prepareStatement("select * from item order by dataInicial asc");
        operacaoListarAllOrdemDataFinal = conexao.prepareStatement("select * from item order by dataInicial desc");
        operacaoListarAllOrdemCodigo = conexao.prepareStatement("select * from item order by codigoItem asc");
        operacaoListarAll = conexao.prepareStatement("select * from item");
        operacaoExibir = conexao.prepareStatement("select *  from item where codigoItem = ?");
        operacaoExcluir = conexao.prepareStatement("delete from item where codigoItem = ?");
        operacaoAlterar = conexao.prepareStatement("update item set titulo = ?, descricao = ?, links = ?, dataAtualizacao = ? where codigoItem = ?");
    }

    @Override
    public void criar(String titulo, String desricacao, String links, Integer idUsuario) throws Exception {
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
        operacaoInsereItem.setInt(5, idUsuario);
        operacaoInsereItem.executeUpdate();
    }

    @Override
    public List<Item> listarItensUsuario(Integer idUsuario) throws Exception {
        List<Item> itens = new ArrayList<>();
        operacaoListar.clearParameters();
        operacaoListar.setInt(1, idUsuario);
        ResultSet resultado = operacaoListar.executeQuery();
        while (resultado.next()) {
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
    public List<Item> listarAllItensOrdemDataFinal() throws Exception {
        List<Item> itens = new ArrayList<>();
        operacaoListarAllOrdemDataFinal.clearParameters();

        ResultSet resultado = operacaoListarAllOrdemDataFinal.executeQuery();
        while (resultado.next()) {
            Item i = new Item();
            i.setIdItem(resultado.getInt("codigoItem"));
            i.setTitulo(resultado.getString("titulo"));
            i.setDescricao(resultado.getString("descricao"));
            i.setLinks(resultado.getString("links"));
            i.setDataInicial(resultado.getTimestamp("dataInicial"));
            i.setDataAtualizacao(resultado.getTimestamp("dataAtualizacao"));
            i.setIdCriador(resultado.getInt("fk_codigoCriador"));
            itens.add(i);
        }
        return itens;
    }

    @Override
    public List<Item> listarAllItensOrdemDataInicial() throws Exception {
        List<Item> itens = new ArrayList<>();
        operacaoListarAllOrdemDataInicial.clearParameters();

        ResultSet resultado = operacaoListarAllOrdemDataInicial.executeQuery();
        while (resultado.next()) {
            Item i = new Item();
            i.setIdItem(resultado.getInt("codigoItem"));
            i.setTitulo(resultado.getString("titulo"));
            i.setDescricao(resultado.getString("descricao"));
            i.setLinks(resultado.getString("links"));
            i.setDataInicial(resultado.getTimestamp("dataInicial"));
            i.setDataAtualizacao(resultado.getTimestamp("dataAtualizacao"));
            i.setIdCriador(resultado.getInt("fk_codigoCriador"));
            itens.add(i);
        }
        return itens;
    }

    @Override
    public List<Item> listarAllItens() throws Exception {
        List<Item> itens = new ArrayList<>();
        operacaoListarAll.clearParameters();
        ResultSet resultado = operacaoListarAll.executeQuery();
        while (resultado.next()) {
            Item i = new Item();
            i.setIdItem(resultado.getInt("codigoItem"));
            i.setTitulo(resultado.getString("titulo"));
            i.setDescricao(resultado.getString("descricao"));
            i.setLinks(resultado.getString("links"));
            i.setDataInicial(resultado.getTimestamp("dataInicial"));
            i.setDataAtualizacao(resultado.getTimestamp("dataAtualizacao"));
            i.setIdCriador(resultado.getInt("fk_codigoCriador"));
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
    public Item exibirItem(Integer id, Integer idItem) throws Exception {
        operacaoExcluir.clearParameters();
        operacaoExibir.setInt(1, idItem);
        operacaoExibir.execute();
        ResultSet resultado = operacaoExibir.executeQuery();
        Item i = new Item();
        while (resultado.next()) {
            i.setIdItem(resultado.getInt("codigoItem"));
            i.setTitulo(resultado.getString("titulo"));
            i.setDescricao(resultado.getString("descricao"));
            i.setLinks(resultado.getString("links"));
            i.setDataInicial(resultado.getTimestamp("dataInicial"));
            i.setDataAtualizacao(resultado.getTimestamp("dataAtualizacao"));
            i.setIdCriador(resultado.getInt("fk_codigoCriador"));
        }
        AvaliarItemDAO aI = new AvaliarItemDAOJDBC();
        try{
            i.setPositivo(aI.listarEspecificoPositivo(id, idItem));
            try
            {
                i.setNegativo(aI.listarEspecificoNegativo(id, idItem));
                return i;
            }
            catch (Exception ex)
            {
                i.setNegativo(0);
                return i;
            }
        }
        catch(Exception ex)
        {
            try
            {
                i.setNegativo(aI.listarEspecificoNegativo(id, idItem));
                return i;
            }
            catch (Exception ex2)
            {                
                i.setPositivo(0);
                i.setNegativo(0);
                return i;
            }
        }
    }

    @Override
    public void alterar(Integer id, String titulo, String descricao, String links) throws Exception {
        operacaoAlterar.clearParameters();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        Calendar cal = Calendar.getInstance();
        Date data = new Date();
        cal.setTime(data);
        java.sql.Timestamp dataSqlAtualizacao;
        dataSqlAtualizacao = new java.sql.Timestamp(data.getTime());
        operacaoAlterar.setString(1, titulo);
        operacaoAlterar.setString(2, descricao);
        operacaoAlterar.setString(3, links);
        operacaoAlterar.setTimestamp(4, dataSqlAtualizacao);
        operacaoAlterar.setInt(5, id);
        operacaoAlterar.executeUpdate();
    }

    @Override
    public List<Item> listarAllItensOrdemCodigo() throws Exception {
        List<Item> itens = new ArrayList<>();
        operacaoListarAllOrdemCodigo.clearParameters();
        ResultSet resultado = operacaoListarAllOrdemCodigo.executeQuery();
        while (resultado.next()) {
            Item i = new Item();
            i.setIdItem(resultado.getInt("codigoItem"));
            i.setTitulo(resultado.getString("titulo"));
            i.setDescricao(resultado.getString("descricao"));
            i.setLinks(resultado.getString("links"));
            i.setDataInicial(resultado.getTimestamp("dataInicial"));
            i.setDataAtualizacao(resultado.getTimestamp("dataAtualizacao"));
            i.setIdCriador(resultado.getInt("fk_codigoCriador"));
            itens.add(i);
        }
        return itens;
    }

}
