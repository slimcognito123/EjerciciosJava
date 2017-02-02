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
    <form action="${pageContext.request.contextPath}/login.do" method="post">
        <label for="nombre"><spring:message code="label.usuario"/>
            <input type="text" name="nombre" id="nombre"/><br>
        </label>
        <label for="password"><spring:message code="label.contrasena1"/> <input type="password" name="password"
                                                                                id="password"/></label><br>
        <form:errors path="errorLogin"/>
        <input type="submit" value="enter">
    </form>
</article>
<a href="crearUsuario.jsp"><spring:message code="label.preguntaCrearUsuario"/> </a>
</body>
</html>