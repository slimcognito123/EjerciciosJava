<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="style/Style.css">
    <title>Agenda</title>
</head>
<body>
<core:set var="nombre" scope="session" value="${user}"/>
<core:set var="contacto" value="${contacto}"/>
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
    <form action="${pageContext.request.contextPath}/modifyContact.do" method="post">
        <label>
            telefono:
            <input type="number" name="telefono" value='${contacto.telefono}'><br>
        </label>
        <label>
            nombre:
            <input type="text" name="nombre" value='${contacto.nombre}'><br>
        </label>
        <label>
            apellido:
            <input type="text" name="apellidos" value='${contacto.apellidos}'><br>
        </label>
        <label>
            Fecha Nacimiento:
            <input type="date" name="fecha" value='${contacto.fecha}'><br>
        </label>
        <input type='hidden' name='id' value='${contacto.id}'>
        <input type="submit" value="modificar">
    </form>
</article>
</body>
</html>
