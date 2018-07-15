package ControlBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ComentarioDAOJDBC implements ComentarioDAO{

    private Connection conexao;
    private PreparedStatement operacaoCriar;
    
    public ComentarioDAOJDBC() throws Exception{
        conexao = BdConnection.getConnection();
        operacaoCriar = conexao.prepareStatement("insert into comentario (comentario, dataInicial, fk_codigoCriador, fk_codigoItem) values (?, ?, ?, ?)");
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
    
}
