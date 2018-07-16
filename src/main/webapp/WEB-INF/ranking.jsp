<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>

<div class="container" style="margin-top: 4cm" >
    <h1> Todos os itens</h1>

    <div class="container" style="margin-top: 1cm" >
       <ul class="nav nav-tabs">
  <li class="active"><a href="ranking.html?ordem=navaliacao" />Número de avaliações</li>
  <li style="margin-left: 1cm"><a href="ranking.html?ordem=melhoravaliacao" />Melhor avaliado </a></li>
  <li style="margin-left: 1cm"><a href="ranking.html?ordem=datacriacao" />Data de Criação</a></li>
  <li style="margin-left: 1cm"><a href="ranking.html?ordem=dataatualizacao" />Mais recentes</a></li>
</ul>
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
</div> 
<%@include file="jspf/rodape.jspf" %>