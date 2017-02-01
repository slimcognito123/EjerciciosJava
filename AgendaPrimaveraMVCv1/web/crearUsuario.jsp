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
    Tomcat Agenda
</header>
<article>
    <spf:form commandName="createUser" method="post">
        <label for="usuario"><spring:message code="label.usuario"/></label>
            <spf:input type="text" name="usuario" id="usuario"  path="usuario"/>
        <spf:errors path="errorCrearUsuario"/>
       <br>
        <label for="password"><spring:message code="label.contrasena1"/> <spf:password name="password" id="password" path="password" required="true"/></label><br>
        <label for="password2"><spring:message code="label.contrasena2"/> <spf:password name="password2" id="password2" path="password2" required="true" /></label><br>
        <spf:errors path="errorContrasenaConcordancia"/>
        <input type="submit" value="create">
    </spf:form>
</article>
<a href="index.jsp"><spring:message code="label.mensajeVolver"/> </a>
</body>
</html>