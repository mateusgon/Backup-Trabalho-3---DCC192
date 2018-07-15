package ControlBD;

public interface ComentarioDAO {
    public void criar(String comentario, Integer idUsuario, Integer idItem) throws Exception;
}
