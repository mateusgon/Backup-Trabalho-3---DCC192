package ControlBD;

import Funcionamento.Comentario;
import java.util.List;

public interface ComentarioDAO {
    public void criar(String comentario, Integer idUsuario, Integer idItem) throws Exception;
    public List<Comentario> listarComentariosItem(Integer idItem) throws Exception;
    public Comentario listarEspecifico(Integer idComentario) throws Exception;
    public List<Integer> localizaItemLista (List<Integer> idComentario) throws Exception;
    public List<Integer> localizaItemUsuario (Integer idUsuario) throws Exception;
    public void excluir(Integer idItem) throws Exception;
    public void excluir2(Integer idComentario) throws Exception;
    public void alterar(Integer idComentario, String comentario) throws Exception;
}
