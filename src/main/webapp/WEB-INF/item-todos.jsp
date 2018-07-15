<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="jspf/cabecalho.jspf" %>
    <div class="container text-center">
        <h1> Todos os itens </h1>
        </div>
        <table class="table table-light">
            <thead>
                <tr>
                    <th scope="col">Itens</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="itens" items="${itens}">
                    <tr>
                        <th>
                            <a href="item-listar.html?item=${itens.idItem}"> ${itens.titulo} </a>
                        </th>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
<%@include file="jspf/rodape.jspf" %>