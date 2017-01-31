<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: curso mañana
  Date: 26/01/2017
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>registro</title>
    <sx:head/>
</head>
<body>
    <form action="formu" method="post">
        nombre:<input type="text" name="nombre"/> <br>
        email:<input type="email" name="email"/> <br>
        password:<input type="password" name="pass"/> <br>
        password2:<input type="password" name="pass2"/> <br>
        <%--fechaNacimiento:<input type="date" name="fechaNacimiento"/> <br>--%>
        fecha de nacimiento:<sx:datetimepicker name="fechaNacimiento" displayFormat="dd-MMM-yyyy" value="%{'2010-01-01'}"/>
        <input type="submit" name="enviar"/>
    </form>
</body>
</html>
