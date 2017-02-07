<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: curso mañana
  Date: 06/02/2017
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style/Style.css">
    <title>Title</title>
</head>
<body>
<nav>
    <form action="${pageContext.request.contextPath}/buscarTodos.do">
        <button type="submit">volver</button>
    </form>
</nav>
<article>
    <form action="${pageContext.request.contextPath}/buscarUsuario.do" method="post">
        <label for="nombre">
            <input type="text" name="nombre" id="nombre"/><br>
        </label>
        <input type="submit" value="buscar">
    </form>
    <core:forEach var="follower" items="${busqueda}">
        <section>
            <form action="/seguir.do" method="post">
                <input type="hidden" name="nombreUsuario" value="${follower.nombreUsuario}" id="nombreUsuario">
                <div class="title">
                    <core:out value="${follower.estado}"/>
                    <img src="${follower.imagen}">
                </div>
                <div class="descripcion">
                    @<core:out value="${follower.nombreUsuario}"/>
                </div>
                <button type="submit">empezar a seguir</button>
            </form>
        </section>
    </core:forEach>
</article>
</body>
</html>
