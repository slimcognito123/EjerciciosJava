<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="style/Style.css">
    <title>TareasS.A.</title>
</head>
<body>
<core:set var="list" value="${requestScope.contactos}"/>
<header>
    Tareas S.A.
</header>
<nav>
    <form action="crearTarea.jsp">
        <button>Anadir</button>
    </form>

    <form action="/logout.do" method="post">
        <button>logout</button>
    </form>
</nav>
<article>
    <section>
        <core:forEach var="tarea" items="${tareasVisibles}">
            <form action="${pageContext.request.contextPath}/actualizar.do" method="post">
                <input type="hidden" value="${tarea.idTarea}" name="id"/>
                <div class="title">
                    <core:out value="${tarea.titulo}"/>
                </div>
                <div class="descripcion">
                    <core:out value="${tarea.descripcion}"/>
                </div>
                <core:choose>
                    <core:when test="${tarea.realizada}">
                        <core:out value="${tarea.fechaRealizacion}"/>
                        <core:out value="${tarea.usuarioRealiza.nombreUsuario}"/>
                    </core:when>
                    <core:otherwise>
                        <button type="submit">marcar como completada</button>

                    </core:otherwise>
                </core:choose>
            </form>
        </core:forEach>
    </section>
</article>
<aside>
    <form action="${pageContext.request.contextPath}/buscarTodos.do" method="get">
        <button type="submit">Todos</button>
    </form>
    <form action="${pageContext.request.contextPath}/buscarEstado.do" method="get">
        <input type="hidden" value="1" name="estado"/>
        <button type="submit">realizados</button>
    </form>
    <form action="${pageContext.request.contextPath}/buscarEstado.do" method="get">
        <input type="hidden" value="0" name="estado"/>
        <button type="submit">no realizados</button>
    </form>
</aside>
</body>
</html>
