<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="style/Style.css">
    <title>Agenda</title>
</head>
<body>
<core:set var="usuario" scope="session" value="${user}"/>
<core:set var="contacto" value="${requestScope.contacto}"/>
<header>
    <img src="images/tomcat.png" alt="logo">
    Tomcat Agenda
</header>
<nav>
    <form action="/buscarMes" method="post">
        <input type="submit" value="volver al menu">
    </form>
</nav>

<article>
    <form action="modificar" method="post">
        <label>
            telefono:
            <input type="number" name="tlf" value='${contacto.telefono}'><br>
        </label>
        <label>
            nombre:
            <input type="text" name="nombre" value='${contacto.nombre}'><br>
        </label>
        <label>
            apellido:
            <input type="text" name="apellido" value='${contacto.apellidos}'><br>
        </label>
        <label>
            Fecha Nacimiento:
            <input type="date" name="date" value='${contacto.fecha}'><br>
        </label>
        <input type='hidden' name='id' value='${contacto.id}'>
        <input type="submit" value="modificar">
    </form>
</article>
</body>
</html>
