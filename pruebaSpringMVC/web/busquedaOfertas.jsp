<%@ taglib prefix="spf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: curso mañana
  Date: 01/02/2017
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>busquedaOfertas</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/busquedaOfertas.do" method="post">
    <spring:message code="label.precio"/>
    <input type="text" name="precio"/><spf:errors path="precio"/>
    <br>
    <spring:message code="label.numeroNoches"/> <select name="numeroNoches">
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
    <option value="6">6</option>
</select>
    <button type="submit">buscar</button>
</form>
</body>
</html>
