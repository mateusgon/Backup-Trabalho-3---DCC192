package ControlBD;

import Funcionamento.Item;
import java.util.List;

public interface ItemDAO {
        public void criar(String titulo, String desricacao, String links, Integer idUsuario) throws Exception;
        public List<Item> listarItensUsuario (Integer idUsuario) throws Exception;
        public void excluirItem (Integer idItem) throws Exception;
}
