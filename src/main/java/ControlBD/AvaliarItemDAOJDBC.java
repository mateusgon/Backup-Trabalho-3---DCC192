package ControlBD;

import Funcionamento.AvaliarItem;
import Funcionamento.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AvaliarItemDAOJDBC implements AvaliarItemDAO{

    private Connection conexao;
    private PreparedStatement operacaoCriar;
    private PreparedStatement operacaoListar;
    private PreparedStatement operacaoAtualizar;
    private PreparedStatement operacaoListarPositivo;
    private PreparedStatement operacaoListarNegativo;
    private PreparedStatement operacaoListarUsuarios;
    private PreparedStatement operacaoExcluir;
    
    public AvaliarItemDAOJDBC() throws Exception{
        conexao = BdConnection.getConnection();
        operacaoCriar = conexao.prepareStatement("insert into usuarioitem (positiva, negativa, fk_codigoUsuario, fk_codigoItem) values (?, ?, ?, ?)");
        operacaoListar = conexao.prepareStatement("select positiva, negativa from usuarioitem where fk_codigoUsuario = ? and fk_codigoItem = ?");
        operacaoAtualizar = conexao.prepareStatement("update usuarioitem set positiva = ?, negativa = ? where fk_codigoUsuario = ? and fk_codigoItem = ?");
        operacaoListarPositivo = conexao.prepareStatement("select positiva from usuarioitem where fk_codigoItem = ? and positiva > 0");
        operacaoListarNegativo = conexao.prepareStatement("select negativa from usuarioitem where fk_codigoItem = ? and negativa > 0");
        operacaoListarUsuarios = conexao.prepareStatement("select fk_codigoItem from usuarioitem where fk_codigoUsuario = ?");
        operacaoExcluir = conexao.prepareStatement("delete from usuarioitem where fk_codigoItem = ?");
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
    public Integer listarEspecificoPositivo(Integer codigoItem) throws Exception {
        operacaoListarPositivo.clearParameters();
        operacaoListarPositivo.setInt(1, codigoItem);
        operacaoListarPositivo.execute();
        ResultSet resultado = operacaoListarPositivo.executeQuery();
        Integer contador = 0;
        while (resultado.next()) {
            contador++;
        }        
        return contador;
    }

    @Override
    public Integer listarEspecificoNegativo(Integer codigoItem) throws Exception {
        operacaoListarNegativo.clearParameters();
        operacaoListarNegativo.setInt(1, codigoItem);
        operacaoListarNegativo.execute();
        ResultSet resultado = operacaoListarNegativo.executeQuery();
        Integer contador = 0;
        while (resultado.next()) {
            contador++;
        }        
        return contador;
    }

    @Override
    public List<Integer> listarItemUsuario(Integer codigoUsiario) throws Exception {
        List<Integer> idItem = new ArrayList<>();
        operacaoListarUsuarios.clearParameters();
        operacaoListarUsuarios.setInt(1, codigoUsiario);
        operacaoListarUsuarios.execute();
        ResultSet resultado = operacaoListarUsuarios.executeQuery();
        while (resultado.next()) {
            Integer id = resultado.getInt("fk_codigoItem");
            idItem.add(id);
        }        
        return idItem;
    }

    @Override
    public void excluir(Integer codigoItem) throws Exception {
        operacaoExcluir.clearParameters();
        operacaoExcluir.setInt(1, codigoItem);
        operacaoExcluir.execute();
    }
    
}
