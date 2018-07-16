    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@include file="jspf/cabecalho.jspf" %>
    <div class="container text-center">
        <h1> Bem vindo ao sistema de revisão ${authUser} </h1>
    </div>
    
        <div class="container text-center">

    <div class="row" style="margin-top: 1.5cm">
      <div class="col-sm-6" >
            <div class="card">
                <div class="card-body">
                <a href="ranking.html?ordem=default">
                    <h5 class="card-title">Raking</h5>
                    <i class="material-icons"  style="font-size:100px;">flash_on</i> 
                </a>
                </div>
           </div>
        </div>
    <div class="col-sm-6" >
            <div class="card">
                <div class="card-body">
                <a href="item-listar.html">
                    <h5 class="card-title">Meus itens</h5>
                    <i class="material-icons"  style="font-size:100px;">folder</i> 
                </a>
                </div>
           </div>
        </div>
    </div>
            <div class="row" style="margin-top: 1.5cm">
        <div class="col-sm-6">
            <div class="card">
                <div class="card-body">
                    <a href="curadores.html" >
                    <h5 class="card-title">Curadores</h5>
                        <i class="material-icons" style="font-size:100px;">grade</i>
                    </a>
                </div>
            </div>
        </div>
    <div class="col-sm-6" >
            <div class="card">
                <div class="card-body">
                <a href="trolls.html">
                    <h5 class="card-title">Trolls</h5>
                    <i class="material-icons"  style="font-size:100px;">adb</i> 
                </a>
                </div>
           </div>
        </div>
    
    </div>
    </div>
    <%@include file="jspf/rodape.jspf" %>