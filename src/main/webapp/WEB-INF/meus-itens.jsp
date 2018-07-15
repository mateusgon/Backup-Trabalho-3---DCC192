<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="jspf/cabecalho.jspf" %>
    <div class="container text-center">
        <h1> Meus itens </h1>
        </div>
        <table class="table table-light">
            <thead>
                <tr>
                    <th scope="col">Título</th>
                    <th scope="col">Ações</th>
                </tr>
            </thead>
            <tbody>
                    <tr>
                        <c:forEach var="itens" items="${itens}">
                        <th> <a href="item-listar.html?item=${itens.idItem}"> ${itens.titulo} </a> </th>
                    <th> 
                        <a href="item-editar.html?item=${itens.idItem}"> <i class="material-icons">mode_edit</i> </a>
                        <a href="item-excluir.html?item=${itens.idItem}"> <i class="material-icons">delete</i> </a>
                    </th>
                        </c:forEach>
                    </tr>
            </tbody>
        </table>
<%@include file="jspf/rodape.jspf" %>