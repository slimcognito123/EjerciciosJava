<%--
  Created by IntelliJ IDEA.
  User: Patata kawaii
  Date: 05/02/2017
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="/login.do" method="post">
    <input type="text" name="nombreUsuario" placeholder="usuario"><br>
    <input type="password" name="contrasena" placeholder="contrase&ntilde;a"><br>
    <button type="submit">entrar</button>
</form>
<a href="crearUsuario.jsp">crear cuenta</a>
</body>
</html>
