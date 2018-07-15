package ControlBD;

import Funcionamento.Item;
import java.util.List;

public interface ItemDAO {

    public Item exibirItem(Integer id, Integer idItem) throws Exception;
    public List<Item> listarAllItensOrdemDataInicial() throws Exception;
    public List<Item> listarAllItensOrdemDataFinal() throws Exception;
    public List<Item> listarAllItensOrdemCodigo() throws Exception;
    public void criar(String titulo, String desricacao, String links, Integer idUsuario) throws Exception;
    public List<Item> listarItensUsuario(Integer idUsuario) throws Exception;
    public List<Item> listarAllItens() throws Exception;
    public void alterar(Integer id, String titulo, String descricao, String links) throws Exception;
    public void excluirItem(Integer idItem) throws Exception;
}
