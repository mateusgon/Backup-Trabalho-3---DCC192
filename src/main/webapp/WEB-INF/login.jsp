<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
        <div class="container text-center">
            <c:choose>
                <c:when test="${login}">
                    <form method="post">
                        <div class="form-group row">
                               <label>Email: <input name="email" required type="email"/></label>
                               <label>Senha: <input name="password" required type="password"/></label></div>
                               <input type="submit" class="btn btn-success"/>
                               <input type="reset" class="btn btn-secondary"/>
                        </div>
                    </form>
                </c:when>
                <c:when test="${!login}">
                    <h5><font color="FF0000"> Algo informado não está certo! Digite novamente </font></h5>
                    <form method="post">
                        <div class="form-group row">
                            <label>Email: <input name="email" required type="email"/></label>
                            <label>Senha: <input name="password" required type="password"/></label>
                            <input type="submit" class="btn btn-success"/>
                            <input type="reset" class="btn btn-secondary"/>
                        </div>
                    </form>
                </c:when>
            </c:choose>
        </div>
<%@include file="jspf/rodape.jspf" %>
