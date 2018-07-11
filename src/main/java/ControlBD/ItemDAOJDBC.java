package ControlBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ItemDAOJDBC implements ItemDAO{

    private Connection conexao;
    private PreparedStatement operacaoInsereItem;

    public ItemDAOJDBC() throws Exception {
        conexao = BdConnection.getConnection();
        operacaoInsereItem = conexao.prepareStatement("insert into item (titulo, descricao, links, dataInicial, fk_codigoCriador) values (?, ?, ?, ?, ?)");
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
    
}
