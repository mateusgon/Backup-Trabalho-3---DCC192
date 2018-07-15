<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>

<div class="container" style="margin-top: 4cm" >
    <h1> Todos os itens</h1>
    
<div class="container" style="margin-top: 1cm" >
    <ul>
        <li><a href="ranking.html?ordem=navaliacao" />Ordernar por número de avaliações</li></a>
        <li><a href="ranking.html?ordem=melhoravaliacao" />Ordernar por melhor avaliação</li></a>
        <li><a href="ranking.html?ordem=datacriacao" />Ordernar por data de criação</li></a>        
        <li><a href="ranking.html?ordem=dataatualizacao" />Ordernar por atualização mais recente</li></a>
    </ul>
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
                            <a href="item.html?item=${itens.idItem}"> ${itens.titulo} </a>
                        </th>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    <%--
    <div class="row" style="margin-top: 1.5cm">
        <div class="col-sm-6">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">TITULO!!!</h5>
                    <p class="card-text">Mussum Ipsum, cacilds vidis litro abertis. Mauris nec dolor in eros commodo tempor. Aenean aliquam molestie leo, vitae iaculis nisl.</p>
                    <a href="#" class="btn btn-primary">COMENTAR</a>
                </div>
                <div class="card-footer text-muted">
                    <i class="material-icons" font-size = "1rem" >thumb_up</i> 15
                    <i class="material-icons" font-size = "1rem" >thumb_down</i> 12
                                      
                </div>
            </div>
        </div>
    <div class="col-sm-6" >
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">TITULO!!!</h5>
                    <p class="card-text">Mussum Ipsum, cacilds vidis litro abertis. Mauris nec dolor in eros commodo tempor. Aenean aliquam molestie leo, vitae iaculis nisl.</p>
                    <a href="#" class="btn btn-primary">COMENTAR</a>
                </div>
                <div class="card-footer text-muted">
                    <i class="material-icons" font-size = "1rem" >thumb_up</i> 
                    <i class="material-icons" font-size = "1rem" >thumb_down</i> 
                                      
                </div>
            </div>
        </div>
    
        
    </div>
 <div class="row" style="margin-top: 1.5cm">
        <div class="col-sm-6" >
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">TITULO!!!</h5>
                    <p class="card-text">Mussum Ipsum, cacilds vidis litro abertis. Mauris nec dolor in eros commodo tempor. Aenean aliquam molestie leo, vitae iaculis nisl.</p>
                    <a href="#" class="btn btn-primary">COMENTAR</a>
                </div>
                <div class="card-footer text-muted">
                    <i class="material-icons" font-size = "1rem" >thumb_up</i> 
                    <i class="material-icons" font-size = "1rem" >thumb_down</i> 
                                      
                </div>
            </div>
        </div>
    <div class="col-sm-6">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">TITULO!!!</h5>
                    <p class="card-text">Mussum Ipsum, cacilds vidis litro abertis. Mauris nec dolor in eros commodo tempor. Aenean aliquam molestie leo, vitae iaculis nisl.</p>
                    <a href="#" class="btn btn-primary">COMENTAR</a>
                </div>
                <div class="card-footer text-muted">
                    <i class="material-icons" font-size = "1rem" >thumb_up</i> 
                    <i class="material-icons" font-size = "1rem" >thumb_down</i> 
                                      
                </div>
            </div>
        </div>
    
        
    </div> <div class="row" style="margin-top: 1.5cm">
        <div class="col-sm-6" >
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">TITULO!!!</h5>
                    <p class="card-text">Mussum Ipsum, cacilds vidis litro abertis. Mauris nec dolor in eros commodo tempor. Aenean aliquam molestie leo, vitae iaculis nisl.</p>
                    <a href="#" class="btn btn-primary">COMENTAR</a>
                </div>
                <div class="card-footer text-muted">
                    <i class="material-icons" font-size = "1rem" >thumb_up</i> 
                    <i class="material-icons" font-size = "1rem" >thumb_down</i> 
                                      
                </div>
            </div>
        </div>
    <div class="col-sm-6" >
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">TITULO!!!</h5>
                    <p class="card-text">Mussum Ipsum, cacilds vidis litro abertis. Mauris nec dolor in eros commodo tempor. Aenean aliquam molestie leo, vitae iaculis nisl.</p>
                    <a href="#" class="btn btn-primary">COMENTAR</a>
                </div>
                <div class="card-footer text-muted">
                    <i class="material-icons" font-size = "1rem" >thumb_up</i> 
                    <i class="material-icons" font-size = "1rem" >thumb_down</i>                         
                </div>
            </div>
        </div>
    </div> --%>    
</div> 
</div>
<%@include file="jspf/rodape.jspf" %>