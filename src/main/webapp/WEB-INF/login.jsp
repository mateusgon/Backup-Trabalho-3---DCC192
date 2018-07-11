<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
        <div class="container text-center">
            <c:choose>
                <c:when test="${login}">
                    <form method="post">
                        <div class="form-group row">
                            <label>Email</label>
                            <input type="email" class="form-control" name="email" placeholder="Seu email" required>
                            <label>Senha</label>
                            <input type="password" class="form-control" name="password" size="20" placeholder="Sua senha" required>
                        </div>
                             <button type="submit" class="btn btn-success">Enviar</button>
                            <button type="reset" class="btn btn-secondary">Limpar</button>
                       
                    </form>
                </c:when>
                <c:when test="${!login}">
                    <h5><font color="FF0000"> Algo informado não está certo! Digite novamente </font></h5>
                    <form method="post">
                        <div class="form-group row">
                            <label>Email</label>
                            <input type="email" class="form-control" name="email" placeholder="Seu email" required>
                            <label>Senha</label>
                            <input type="password" class="form-control" name="password" size="20" placeholder="Sua senha" required>
                        </div>
                             <button type="submit" class="btn btn-success">Enviar</button>
                            <button type="reset" class="btn btn-secondary">Limpar</button>
                       
                    </form>
                </c:when>
            </c:choose>
        </div>
<%@include file="jspf/rodape.jspf" %>
