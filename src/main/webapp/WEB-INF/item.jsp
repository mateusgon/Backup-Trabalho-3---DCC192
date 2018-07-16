<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="jspf/cabecalho.jspf" %>
<div class="container text-center">
    <table class="table" style="margin-top:2rem">
        <thead>
            <tr>
                <th scope="col">Item</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <th>
                    <div class="container text-left">
                        <p> <fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${item.dataInicial}" />  
                            <c:choose>
                                <c:when test="${item.dataAtualizacao != null}">
                                    e Atualização: <fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${item.dataAtualizacao}" />
                                </c:when>
                            </c:choose>
                            <c:choose>
                                <c:when test="${item.idCriador == idUser}">
                                    <a href="item-editar.html?item=${item.idItem}"> <i class="material-icons">mode_edit</i> </a>
                                    <a href="item-excluir.html?item=${item.idItem}"> <i class="material-icons">delete</i> </a>
                                </c:when>    
                            </c:choose>
                            <c:choose>
                                <c:when test="${item.idCriador != idUser}">
                                    <a href="avaliar.html?i=${item.idItem}&c=0&p=1&n=0"> <i class="material-icons" font-size = "1rem" >thumb_up</i> ${item.positivo} </a>
                                    <a href="avaliar.html?i=${item.idItem}&c=0&p=0&n=1"> <i class="material-icons" font-size = "1rem" >thumb_down</i> ${item.negativo} </a> 
                                </c:when>
                                <c:when test="${item.idCriador == idUser}">
                                    <i class="material-icons" font-size = "1rem" >thumb_up</i> ${item.positivo}
                                    <i class="material-icons" font-size = "1rem" >thumb_down</i> ${item.negativo}
                                </c:when>
                            </c:choose>        
                        </p>
                        <p> Item nome: ${item.titulo} </p>
                        <p> Item descricao: ${item.descricao} </p>
                        <p> Item url: <a href="${item.links}"> ${item.links} </a> </p>
                        <c:choose>
                            <c:when test="${!feito}">
                                <c:choose>
                                    <c:when test="${!feito2}">
                                        <a href="comentar.html?item=${item.idItem}" class="btn btn-primary">Comentar</a>
                                    </c:when>    
                                </c:choose>    
                            </c:when>    
                        </c:choose>        
                    </div></th>
            </tr>
            <c:forEach var="comentarios" items="${comentarios}">
            <div class="container text-rigth">
                <th>
                <th>
                    <p style="margin-left:-70px"> 
                        Criação: <fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${comentarios.criacao}" />     
                            <c:choose>
                                <c:when test="${comentarios.atualizacao != null}">
                                    e Atualização: ${comentarios.dataAtualizacao}
                                </c:when>
                            </c:choose>
                            <c:choose>        
                            <c:when test="${comentarios.idUsuario == idUser}">
                                <a href="comentario-editar.html?comentario=${comentarios.id}&item=${item.idItem}"> <i class="material-icons">mode_edit</i> </a>
                                <a href="comentario-excluir.html?comentario=${comentarios.id}&item=${item.idItem}"> <i class="material-icons">delete</i> </a>
                            </c:when>    
                        </c:choose>
                        <c:choose>
                            <c:when test="${comentarios.idUsuario != idUser}">
                                <a href="avaliar.html?i=${item.idItem}&c=${comentarios.id}&p=1&n=0"> <i class="material-icons" font-size = "1rem" >thumb_up</i> ${comentarios.positivo} </a> 
                                <a href="avaliar.html?i=${item.idItem}&c=${comentarios.id}&p=0&n=1"> <i class="material-icons" font-size = "1rem" >thumb_down</i> ${comentarios.negativo} </a>  
                            </c:when>    
                            <c:when test="${comentarios.idUsuario == idUser}">
                                <i class="material-icons" font-size = "1rem" >thumb_up</i> ${comentarios.positivo}
                                <i class="material-icons" font-size = "1rem" >thumb_down</i> ${comentarios.negativo}
                            </c:when>
                        </c:choose>
                    </p>
                    ${comentarios.comentario}
                </th>
                </tr>
            </div> 
        </c:forEach>
        </tr>
        </tbody>
    </table>
</div>
<%@include file="jspf/rodape.jspf" %>
