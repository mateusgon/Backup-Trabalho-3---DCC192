package ControlBD;

import Funcionamento.AvaliarComentario;
import java.util.List;

public interface AvaliarComentarioDAO {
    public void criar (Integer codigoUsuario, Integer codigoComentario, Integer positivo, Integer negativo) throws Exception;
    public AvaliarComentario listar (Integer codigoUsuario, Integer codigoComentario) throws Exception;
    public void alterar (Integer codigoUsuario, Integer codigoComentario, Integer positivo, Integer negativo) throws Exception;
    public Integer listarEspecificoPositivo (Integer codigoComentario) throws Exception;
    public Integer listarEspecificoNegativo (Integer codigoComentario) throws Exception;
    public List<Integer> listarComentarioUsuario (Integer codigoUsuario) throws Exception;
    public void excluir (Integer codigoComentario) throws Exception;
}
