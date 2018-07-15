<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="jspf/cabecalho.jspf" %>
    <div class="container text-center">
        <h1> Trolls </h1>
        </div>
        <table class="table table-light">
            <thead>
                <tr>
                    <th scope="col">Usuários</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="usuarios" items="${usuarios}">
                    <tr>
                        <th>
                            ${usuarios.nome}  
                        </th>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
<%@include file="jspf/rodape.jspf" %>