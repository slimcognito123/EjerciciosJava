<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="validar" method="post">
    Nombre: <input type="text" name="nombre" id=""><br>
    Edad: <input type="text" name="edad"><br>
    <s:actionerror/>
    <input type="submit" value="entrar">
</form>
</body>
</html>