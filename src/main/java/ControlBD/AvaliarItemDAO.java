package ControlBD;

import Funcionamento.AvaliarItem;

public interface AvaliarItemDAO {
    public void criar (Integer codigoUsuario, Integer codigoItem, Integer positivo, Integer negativo) throws Exception;
    public AvaliarItem listar (Integer codigoUsuario, Integer codigoItem) throws Exception;
    public void alterar (Integer codigoUsuario, Integer codigoItem, Integer positivo, Integer negativo) throws Exception;
    public Integer listarEspecificoPositivo (Integer codigoItem) throws Exception;
    public Integer listarEspecificoNegativo (Integer codigoItem) throws Exception;
}
