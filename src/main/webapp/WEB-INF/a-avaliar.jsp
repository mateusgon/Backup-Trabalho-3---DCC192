<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="jspf/cabecalho.jspf" %>
    <div class="container text-center">
        <h1 style="margin-top:2rem"> Todos os itens a serem comentados </h1>
        </div>
         
    <div class="container text-center">
  <!-- Table -->
  <table class="table" style="margin-top:2rem">
      <thead style="background-color: black;color: white">
                <tr>
                    <th scope="col">Itens</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="itens" items="${itens}">
                    <tr>
                        <th>
                            <a href="item.html?item=${itens.idItem}"> ${itens.titulo} </a>
                        </th>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
<%@include file="jspf/rodape.jspf" %>