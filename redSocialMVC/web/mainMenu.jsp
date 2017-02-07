<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: curso mañana
  Date: 06/02/2017
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="style/Style.css">
</head>
<body>
<nav>
    <form action="modificarDatosUsuario.jsp">
        <button type="submit">modificar mis datos</button>
    </form>
    <form action="buscadorUsuarios.jsp">
        <button type="submit">buscar usuarios</button>
    </form>
    <form action="${pageContext.request.contextPath}/logout.do" method="post">
        <button type="submit">salir</button>
    </form>
</nav>
<div>
    <form action="${pageContext.request.contextPath}/modificarEstado.do" method="post">
        estado actual ${usuario.estado} <img src="${usuario.imagen}"><br>
        modificar mi estado <input type="text" name="estado" id="estado">
        <button type="submit">cambiarEstado</button>
    </form>
</div>
<article>
    <core:forEach var="follower" items="${listaSeguidos}">
        <section>
            <form action="${pageContext.request.contextPath}/dejarDeSeguir.do" method="post">
                <input type="hidden" name="nombreUsuario" value="${follower.nombreUsuario}" id="nombreUsuario">
                <div><img src="${follower.imagen}"></div>
                <div class="title">
                    <core:out value="${follower.estado}"/>
                </div>
                <div class="descripcion">
                    @<core:out value="${follower.nombreUsuario}"/>
                </div>
                <button type="submit">dejar de seguir</button>
            </form>
        </section>
    </core:forEach>
</article>

</body>
</html>
