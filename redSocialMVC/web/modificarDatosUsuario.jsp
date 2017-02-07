<%--
  Created by IntelliJ IDEA.
  User: curso mañana
  Date: 06/02/2017
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="style/Style.css">
</head>
<body>
<nav>
    <form action="${pageContext.request.contextPath}/buscarTodos.do">
        <button type="submit">volver</button>
    </form>
</nav>
<article>
    <form action="${pageContext.request.contextPath}/modificarDatos.do" method="post">
        <input type="hidden" name="nombreUsuario" id="nombreUsuario" value="${sessionScope.usuario.nombreUsuario}"/>
        <br>
        <label for="password">contrase&ntilde;a<input type="password" name="password" id="password"
                                                      value="${sessionScope.usuario.password}"
                                                      required/></label><br>
        <label for="email">
            em@il
            <input type="email" name="email" id="email" value="${sessionScope.usuario.email}" required>
        </label><br>
        <label for="imagen"> imagen de perfil<input type="url" name="imagen" id="imagen"
                                                            value="${sessionScope.usuario.imagen}"/></label><br>
        <button type="submit">
            actualizar
        </button>
    </form>
</article>

</body>
</html>
