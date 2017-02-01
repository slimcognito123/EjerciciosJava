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
<spf:form modelAttribute="busquedaOferta" method="post">
    <spring:message code="label.precio"/>
    <spf:input path="precio"/><spf:errors path="precio"/>
    <br>
    <spring:message code="label.numeroNoches"/> <spf:select path="numeroNoches">
    <spf:option value="1">1</spf:option>
    <spf:option value="2">2</spf:option>
    <spf:option value="3">3</spf:option>
    <spf:option value="4">4</spf:option>
    <spf:option value="5">5</spf:option>
    <spf:option value="6">6</spf:option>
</spf:select>
    <button type="submit">buscar</button>
</spf:form>
</body>
</html>
