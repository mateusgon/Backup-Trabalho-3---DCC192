<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>

            
    <div class="container text-center">
            <form method="post">
                <div class="form-group row">
                    <label>T�tulo do produto: </label>
                    <input value = "" type="text" class="form-control" name="titulo" placeholder="Digite o t�tulo do produto" required>
                    <label>Descri��o: </label>
                    <input type="text" class="form-control" name="descricao" placeholder="Descri��o do seu item" required>
                    <label>Link: </label>
                    <input type="url" class="form-control" name="url" placeholder="Digite o link" required>
                    <input type="submit" class="btn btn-success"/>
                    <input type="reset" class="btn btn-secondary"/>
                </div>
            </form>
        </div>
                    
    </c:forEach>                  
<%@include file="jspf/rodape.jspf" %>
