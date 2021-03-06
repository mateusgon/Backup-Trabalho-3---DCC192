package ControlBD;

import Funcionamento.Comentario;
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

public class ComentarioDAOJDBC implements ComentarioDAO{

    private Connection conexao;
    private PreparedStatement operacaoCriar;
    private PreparedStatement operacaoListar;
    private PreparedStatement operacaoListarEspecifico;
    private PreparedStatement operacaoLocalizarItem;
    private PreparedStatement operacaoLocalizarUsuario;
    private PreparedStatement operacaoExcluir;
    private PreparedStatement operacaoExcluir2;
    private PreparedStatement operacaoAlterar;
    
    public ComentarioDAOJDBC() throws Exception{
        conexao = BdConnection.getConnection();
        operacaoCriar = conexao.prepareStatement("insert into comentario (comentario, dataInicial, fk_codigoCriador, fk_codigoItem) values (?, ?, ?, ?)");
        operacaoListar = conexao.prepareStatement("select codigoComentario, comentario, dataInicial, dataAtualizacao, fk_codigoCriador, fk_codigoItem from comentario where fk_codigoItem = ?");
        operacaoExcluir = conexao.prepareStatement("delete from comentario where fk_codigoItem = ?");
        operacaoExcluir2 = conexao.prepareStatement("delete from comentario where codigoComentario = ?");
        operacaoListarEspecifico = conexao.prepareStatement("select codigoComentario, comentario from comentario where codigoComentario = ?");
        operacaoAlterar = conexao.prepareStatement("update comentario set comentario = ?, dataAtualizacao = ? where codigoComentario = ?");
        operacaoLocalizarItem = conexao.prepareStatement("select fk_codigoItem from comentario where codigoComentario = ?");
        operacaoLocalizarUsuario = conexao.prepareStatement("select fk_codigoItem from comentario where fk_codigoCriador = ?");
    }

    @Override
    public void criar(String comentario, Integer idUsuario, Integer idItem) throws Exception {
        operacaoCriar.clearParameters();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        Calendar cal = Calendar.getInstance();
        Date data = new Date();
        cal.setTime(data);
        java.sql.Timestamp dataSqlCriacao;
        dataSqlCriacao = new java.sql.Timestamp(data.getTime());
        operacaoCriar.setString(1, comentario);
        operacaoCriar.setTimestamp(2, dataSqlCriacao);
        operacaoCriar.setInt(3, idUsuario);
        operacaoCriar.setInt(4, idItem);
        operacaoCriar.executeUpdate();
    }

    @Override
    public List<Comentario> listarComentariosItem(Integer idItem) throws Exception {
        List<Comentario> comentarios = new ArrayList<>();
        operacaoListar.clearParameters();
        operacaoListar.setInt(1, idItem);
        ResultSet resultado = operacaoListar.executeQuery();
        while (resultado.next()) {
            Comentario c = new Comentario();
            c.setId(resultado.getInt("codigoComentario"));
            c.setComentario(resultado.getString("comentario"));
            c.setCriacao(resultado.getTimestamp("dataInicial"));
            c.setAtualizacao(resultado.getTimestamp("dataAtualizacao"));
            c.setIdItem(resultado.getInt("fk_codigoItem"));
            c.setIdUsuario(resultado.getInt("fk_codigoCriador"));
            AvaliarComentarioDAO aDAO = new AvaliarComentarioDAOJDBC();
            try {
                c.setPositivo(aDAO.listarEspecificoPositivo(c.getId()));
                try {
                    c.setNegativo(aDAO.listarEspecificoNegativo(c.getId()));
                    comentarios.add(c);
                } catch (Exception ex) {
                    c.setNegativo(0);
                    comentarios.add(c);
                }
            } catch (Exception ex) {
                try {
                    c.setNegativo(aDAO.listarEspecificoNegativo(c.getId()));
                    comentarios.add(c);
                } catch (Exception ex2) {
                    c.setPositivo(0);
                    c.setNegativo(0);
                    comentarios.add(c);
                }
            }
        }
        return comentarios;
    }

    @Override
    public void excluir(Integer idItem) throws Exception {
        operacaoExcluir.clearParameters();
        operacaoExcluir.setInt(1, idItem);
        operacaoExcluir.execute();
    }

    @Override
    public void excluir2(Integer idComentario) throws Exception {
        operacaoExcluir2.clearParameters();
        operacaoExcluir2.setInt(1, idComentario);
        operacaoExcluir2.execute();
    }

    @Override
    public Comentario listarEspecifico(Integer idComentario) throws Exception {
        operacaoListarEspecifico.clearParameters();
        operacaoListarEspecifico.setInt(1, idComentario);
        ResultSet resultado = operacaoListarEspecifico.executeQuery();
        resultado.next();
        Comentario c = new Comentario();
        c.setId(resultado.getInt("codigoComentario"));
        c.setComentario(resultado.getString("comentario"));
        return c;
    }

    @Override
    public void alterar(Integer idComentario, String comentario) throws Exception {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        Calendar cal = Calendar.getInstance();
        Date data = new Date();
        cal.setTime(data);
        java.sql.Timestamp dataSqlAtualizacao;
        dataSqlAtualizacao = new java.sql.Timestamp(data.getTime());
        operacaoAlterar.clearParameters();
        operacaoAlterar.setString(1, comentario);
        operacaoAlterar.setTimestamp(2, dataSqlAtualizacao);
        operacaoAlterar.setInt(3, idComentario);
        operacaoAlterar.executeUpdate();
    }

    @Override
    public List<Integer> localizaItemLista(List<Integer> idComentario) throws Exception {
        ArrayList<Integer> itens = new ArrayList<>();
        for (Integer integer : idComentario) {
            operacaoLocalizarItem.clearParameters();
            operacaoLocalizarItem.setInt(1, integer);
            ResultSet resultado = operacaoLocalizarItem.executeQuery();
            resultado.next();
            Integer id = resultado.getInt("fk_codigoItem");
            itens.add(id);
        }
        return itens;
    }

    @Override
    public List<Integer> localizaItemUsuario(Integer idUsuario) throws Exception {
        ArrayList<Integer> itens = new ArrayList<>();
        operacaoLocalizarUsuario.clearParameters();
        operacaoLocalizarUsuario.setInt(1, idUsuario);
        ResultSet resultado = operacaoLocalizarUsuario.executeQuery();
        while (resultado.next())
        {
            Integer i = resultado.getInt("fk_codigoItem");
            itens.add(i);
        }
        return itens;
    }
    
}
