package ControlBD;

import Funcionamento.AvaliarItem;
import Funcionamento.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AvaliarItemDAOJDBC implements AvaliarItemDAO{

    private Connection conexao;
    private PreparedStatement operacaoCriar;
    private PreparedStatement operacaoListar;
    private PreparedStatement operacaoAtualizar;
    private PreparedStatement operacaoListarPositivo;
    private PreparedStatement operacaoListarNegativo;
    
    public AvaliarItemDAOJDBC() throws Exception{
        conexao = BdConnection.getConnection();
        operacaoCriar = conexao.prepareStatement("insert into usuarioitem (positiva, negativa, fk_codigoUsuario, fk_codigoItem) values (?, ?, ?, ?)");
        operacaoListar = conexao.prepareStatement("select positiva, negativa from usuarioitem where fk_codigoUsuario = ? and fk_codigoItem = ?");
        operacaoAtualizar = conexao.prepareStatement("update usuarioitem set positiva = ?, negativa = ? where fk_codigoUsuario = ? and fk_codigoItem = ?");
        operacaoListarPositivo = conexao.prepareStatement("select positiva from usuarioitem where fk_codigoUsuario = ? and fk_codigoItem = ? and positiva > 0");
        operacaoListarNegativo = conexao.prepareStatement("select negativa from usuarioitem where fk_codigoUsuario = ? and fk_codigoItem = ? and negativa > 0");
    }

    @Override
    public void criar(Integer codigoUsuario, Integer codigoItem, Integer positivo, Integer negativo) throws Exception {
        operacaoCriar.clearParameters();
        operacaoCriar.setInt(1, positivo);
        operacaoCriar.setInt(2, negativo);
        operacaoCriar.setInt(3, codigoUsuario);
        operacaoCriar.setInt(4, codigoItem);
        operacaoCriar.executeUpdate();
    }

    @Override
    public AvaliarItem listar(Integer codigoUsuario, Integer codigoItem) throws Exception {
        operacaoListar.clearParameters();
        operacaoListar.setInt(1, codigoUsuario);
        operacaoListar.setInt(2, codigoItem);
        operacaoListar.execute();
        ResultSet resultado = operacaoListar.executeQuery();
        AvaliarItem aI = new AvaliarItem();
        while (resultado.next()) {
            aI.setPositivo(resultado.getInt("positiva"));
            aI.setNegativo(resultado.getInt("negativa"));
        }        
        return aI;
    }

    @Override
    public void alterar(Integer codigoUsuario, Integer codigoItem, Integer positivo, Integer negativo) throws Exception {
       operacaoAtualizar.clearParameters();
       operacaoAtualizar.setInt(1, positivo);
       operacaoAtualizar.setInt(2, negativo);
       operacaoAtualizar.setInt(3, codigoUsuario);
       operacaoAtualizar.setInt(4, codigoItem);
       operacaoAtualizar.executeUpdate();
    }

    @Override
    public Integer listarEspecificoPositivo(Integer codigoUsuario, Integer codigoItem) throws Exception {
        operacaoListarPositivo.clearParameters();
        operacaoListarPositivo.setInt(1, codigoUsuario);
        operacaoListarPositivo.setInt(2, codigoItem);
        operacaoListarPositivo.execute();
        ResultSet resultado = operacaoListarPositivo.executeQuery();
        Integer contador = 0;
        while (resultado.next()) {
            contador++;
        }        
        return contador;
    }

    @Override
    public Integer listarEspecificoNegativo(Integer codigoUsuario, Integer codigoItem) throws Exception {
        operacaoListarNegativo.clearParameters();
        operacaoListarNegativo.setInt(1, codigoUsuario);
        operacaoListarNegativo.setInt(2, codigoItem);
        operacaoListarNegativo.execute();
        ResultSet resultado = operacaoListarNegativo.executeQuery();
        Integer contador = 0;
        while (resultado.next()) {
            contador++;
        }        
        return contador;
    }
    
}
