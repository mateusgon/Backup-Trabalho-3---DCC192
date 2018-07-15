package ControlBD;

import Funcionamento.AvaliarComentario;

public interface AvaliarComentarioDAO {
    public void criar (Integer codigoUsuario, Integer codigoComentario, Integer positivo, Integer negativo) throws Exception;
    public AvaliarComentario listar (Integer codigoUsuario, Integer codigoComentario) throws Exception;
    public void alterar (Integer codigoUsuario, Integer codigoComentario, Integer positivo, Integer negativo) throws Exception;
    public Integer listarEspecificoPositivo (Integer codigoComentario) throws Exception;
    public Integer listarEspecificoNegativo (Integer codigoComentario) throws Exception;
}
