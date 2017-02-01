
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
    <form:form modelAttribute="comprobarContrasena" method="post">
        <label for="usuario"><spring:message code="label.usuario"/>
            <form:input type="text" name="usuario" path="usuario" /><br>
        </label>
        <label for="password"><spring:message code="label.contrasena1"/> <form:input type="password" name="password" id="" path="password"/></label><br>
        <input type="submit" value="enter">
    </form:form>
</article>
<a href="crearUsuario.jsp"><spring:message code="label.preguntaCrearUsuario"/> </a>
</body>
</html>