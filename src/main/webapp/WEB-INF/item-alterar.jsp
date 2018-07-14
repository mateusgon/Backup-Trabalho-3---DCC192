<%@page import="Funcionamento.Item"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>

<%
    Item item = (Item) request.getAttribute("item");
%>
            
    <div class="container text-center">
            <form method="post">
                <div class="form-group row">
                    <label>Título do produto: </label>
                    <input value = "<%=item.getTitulo()%>" type="text" class="form-control" name="titulo" placeholder="Digite o título do produto" required>
                    <label>Descrição: </label>
                    <input value = "<%=item.getDescricao()%>" type="text" class="form-control" name="descricao" placeholder="Descrição do seu item" required>
                    <label>Link: </label>
                    <input value = "<%=item.getLinks()%>" type="url" class="form-control" name="url" placeholder="Digite o link" required>
                    <input value="<%=item.getIdItem()%>" type="hidden" name="idItem" class="form-control">
                    <input type="submit" class="btn btn-success"/>
                    <input type="reset" class="btn btn-secondary"/>
                </div>
            </form>
        </div>
                    
                    
<%@include file="jspf/rodape.jspf" %>
