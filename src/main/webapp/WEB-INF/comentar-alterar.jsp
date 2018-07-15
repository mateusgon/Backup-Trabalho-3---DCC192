<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
        <div class="container text-center">
            <form method="post">
                <div class="form-group row">
                    <label>Comentário</label>
                    <textarea class="form-control" name="descricao" rows="3">${comentario.comentario}</textarea>
                    <input type="hidden" name="idComentario" value="${comentario.id}"/>
                    <input type="hidden" name="idItem" value="${idItem}"/>
                    <input type="submit" class="btn btn-success"/>
                    <input type="reset" class="btn btn-secondary"/>
                </div>
            </form>
        </div>
<%@include file="jspf/rodape.jspf" %>
