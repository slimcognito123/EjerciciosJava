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
<nav>
    <form action="${pageContext.request.contextPath}/search.do" method="get">
        <input type="submit" value="volver al menu">
    </form>
</nav>
<article>
    <form action="${pageContext.request.contextPath}/createPerson.do" method="post">
        <label>
            <spring:message code="label.nombre"/>
            <input type="text" name="nombre"><br>
        </label>
        <label>
            <spring:message code="label.apellidos"/>
            <input type="text" name="apellidos"><br>
        </label>
        <label>
            <spring:message code="label.telefono"/>
            <input type="number" name="telefono" required><br>
            <form:errors code="label.msgTelefonoMalPuesto"/>
        </label>
        <label>
            <spring:message code="label.fechaNacimiento"/>
            <input type="date" name="fecha"><br>
        </label>
        <button type="submit"><spring:message code="label.anadir"/></button>
    </form>
</article>
</body>
</html>