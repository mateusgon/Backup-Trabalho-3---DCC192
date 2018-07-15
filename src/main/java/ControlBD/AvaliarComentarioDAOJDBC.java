package ControlBD;

import Funcionamento.AvaliarComentario;
import Funcionamento.AvaliarItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AvaliarComentarioDAOJDBC implements AvaliarComentarioDAO{

    private Connection conexao;
    private PreparedStatement operacaoCriar;
    private PreparedStatement operacaoListar;
    private PreparedStatement operacaoAtualizar;
    private PreparedStatement operacaoListarPositivo;
    private PreparedStatement operacaoListarNegativo;
   
    public AvaliarComentarioDAOJDBC() throws Exception{
        conexao = BdConnection.getConnection();
        operacaoCriar = conexao.prepareStatement("insert into usuariocomentario (positiva, negativa, fk_codigoUsuario, fk_codigoComentario) values (?, ?, ?, ?)");
        operacaoListar = conexao.prepareStatement("select positiva, negativa from usuariocomentario where fk_codigoUsuario = ? and fk_codigoComentario = ?");
        operacaoAtualizar = conexao.prepareStatement("update usuariocomentario set positiva = ?, negativa = ? where fk_codigoUsuario = ? and fk_codigoComentario = ?");
        operacaoListarPositivo = conexao.prepareStatement("select positiva, negativa from usuariocomentario where fk_codigoComentario = ? and positiva > 0");
        operacaoListarNegativo = conexao.prepareStatement("select positiva, negativa from usuariocomentario where fk_codigoComentario = ? and negativa > 0");
    }

    @Override
    public void criar(Integer codigoUsuario, Integer codigoComentario, Integer positivo, Integer negativo) throws Exception {
        operacaoCriar.clearParameters();
        operacaoCriar.setInt(1, positivo);
        operacaoCriar.setInt(2, negativo);
        operacaoCriar.setInt(3, codigoUsuario);
        operacaoCriar.setInt(4, codigoComentario);
        operacaoCriar.executeUpdate();
    }

    @Override
    public AvaliarComentario listar(Integer codigoUsuario, Integer codigoComentario) throws Exception {
        operacaoListar.clearParameters();
        operacaoListar.setInt(1, codigoUsuario);
        operacaoListar.setInt(2, codigoComentario);
        operacaoListar.execute();
        ResultSet resultado = operacaoListar.executeQuery();
        AvaliarComentario aC = new AvaliarComentario();
        while (resultado.next()) {
            aC.setPositivo(resultado.getInt("positiva"));
            aC.setNegativo(resultado.getInt("negativa"));
        }        
        return aC;
    }

    @Override
    public void alterar(Integer codigoUsuario, Integer codigoComentario, Integer positivo, Integer negativo) throws Exception {
       operacaoAtualizar.clearParameters();
       operacaoAtualizar.setInt(1, positivo);
       operacaoAtualizar.setInt(2, negativo);
       operacaoAtualizar.setInt(3, codigoUsuario);
       operacaoAtualizar.setInt(4, codigoComentario);
       operacaoAtualizar.executeUpdate();
    }

    @Override
    public Integer listarEspecificoPositivo(Integer codigoComentario) throws Exception {
        operacaoListarPositivo.clearParameters();
        operacaoListarPositivo.setInt(1, codigoComentario);
        operacaoListarPositivo.execute();
        ResultSet resultado = operacaoListarPositivo.executeQuery();
        Integer contador = 0;
        while (resultado.next()) {
            contador++;
        }        
        return contador;
    }

    @Override
    public Integer listarEspecificoNegativo(Integer codigoComentario) throws Exception {
        operacaoListarNegativo.clearParameters();
        operacaoListarNegativo.setInt(1, codigoComentario);
        operacaoListarNegativo.execute();
        ResultSet resultado = operacaoListarNegativo.executeQuery();
        Integer contador = 0;
        while (resultado.next()) {
            contador++;
        }        
        return contador;
    }
    
}
