<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style/Style.css">
    <title>Agenda</title>
</head>
<body>
<header>
    <img src="images/tomcat.png" alt="logo">
    Tareas S.A.
</header>
<article>
    <form action="${pageContext.request.contextPath}/createUser.do" method="post">
        <label for="usuario"><spring:message code="label.usuario"/></label>
        <input type="text" name="usuario" id="usuario" />
        <br>
        <spf:errors path="errorCrearUsuario"/>
        <br>
        <label for="password"><spring:message code="label.contrasena1"/> <input type="password" name="password" id="password"
                                                                                       required/></label><br>
        <label for="password2"><spring:message code="label.contrasena2"/> <input type="password" name="password2" id="password2"
                                                                                        required/></label><br>
        <spf:errors path="errorContrasenaConcordancia"/>
        <button type="submit">
            <spring:message code="label.create"/>
        </button>
    </form>
</article>
<a href="index.jsp"><spring:message code="label.mensajeVolver"/> </a>
</body>
</html>