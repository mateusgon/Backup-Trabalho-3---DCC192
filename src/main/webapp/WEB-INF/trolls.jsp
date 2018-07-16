<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="jspf/cabecalho.jspf" %>
    <div class="container text-center">
        <h1> Trolls </h1>
        </div>
           
    <div class="container text-center">
  <!-- Table -->
  <table class="table" style="margin-top:2rem">
        <thead style="background-color: black;color: white">
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
    </div>
<%@include file="jspf/rodape.jspf" %>