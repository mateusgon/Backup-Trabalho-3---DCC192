<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="jspf/cabecalho.jspf" %>
    <div class="container text-center">
        <h1> Meus itens </h1>
        </div>
        <table class="table table-light">
            <thead>
                <tr>
                    <th scope="col">Código</th>
                    <th scope="col">Título</th>
                    <th scope="col">Ações</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="itens" items="${itens}">
                    <tr>
                    <th>${itens.idItem}</th>
                    <th>${itens.titulo}</th>
                    <th> 
                         <a href=""> <i class="material-icons">description</i> </a>
                        <a href=""> <i class="material-icons">mode_edit</i> </a>
                        <a href=""> <i class="material-icons">delete</i> </a>
                    </th>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
<%@include file="jspf/rodape.jspf" %>