package ControlBD;

import Funcionamento.Comentario;
import java.util.List;

public interface ComentarioDAO {
    public void criar(String comentario, Integer idUsuario, Integer idItem) throws Exception;
    public List<Comentario> listarComentariosItem(Integer idItem) throws Exception;
}
