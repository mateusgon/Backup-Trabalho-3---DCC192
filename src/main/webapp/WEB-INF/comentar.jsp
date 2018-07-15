<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
        <div class="container text-center">
            <form method="post">
                <div class="form-group row">
                    <label>Comentário</label>
                    <textarea class="form-control" name="comentario" rows="3"></textarea>
                    <input type="hidden" name="item" value="${item.idItem}"/>
                    <input type="submit" class="btn btn-success"/>
                    <input type="reset" class="btn btn-secondary"/>
                </div>
            </form>
        </div>
<%@include file="jspf/rodape.jspf" %>
