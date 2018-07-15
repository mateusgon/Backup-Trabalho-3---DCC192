<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<div class="container text-center">
    <table class="table table-light">
        <thead>
            <tr>
                <th scope="col">Item</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <th>
                    <p> Criação: ${item.dataInicial} e Atualização: ${item.dataAtualizacao}
                        <c:choose>
                            <c:when test="${item.idCriador == idUser}">
                                <a href="item-editar.html?item=${item.idItem}"> <i class="material-icons">mode_edit</i> </a>
                                <a href="item-excluir.html?item=${item.idItem}"> <i class="material-icons">delete</i> </a>
                            </c:when>    
                        </c:choose>
                    <c:choose>
                        <c:when test="${item.idCriador != idUser}">
                            <a href=""> <i class="material-icons" font-size = "1rem" >thumb_up</i> </a>
                            <a href=""> <i class="material-icons" font-size = "1rem" >thumb_down</i> </a> 
                        </c:when>    
                    </c:choose>        
                    </p>
                    <p> Item nome: ${item.titulo} </p>
                    <p> Item descricao: ${item.descricao} </p>
                    <p> Item url: ${item.links} </p>
                    <c:choose>
                        <c:when test="${feito}">
                            <a href="comentar.html?item=${item.idItem}" class="btn btn-primary">Comentar</a>
                        </c:when>    
                    </c:choose>        
                </th>
            </tr>
            <c:forEach var="comentarios" items="${comentarios}">
                <tr>
                    <th>
                        <p> Criação: ${comentarios.criacao} e Atualização: ${comentarios.atualizacao} </p>
                        ${comentarios.comentario}
                        <c:choose>
                            <c:when test="${feito}">
                                <a href="item-editar.html?item=${item.idItem}"> <i class="material-icons">mode_edit</i> </a>
                                <a href="item-excluir.html?item=${item.idItem}"> <i class="material-icons">delete</i> </a>
                            </c:when>    
                        </c:choose>

                    </th>
                </tr>
            </c:forEach>
            </tr>
        </tbody>
    </table>
</div>
<%@include file="jspf/rodape.jspf" %>
