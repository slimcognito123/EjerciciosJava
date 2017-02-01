<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import="Beans.Contacto" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Modelo.Business.AgendaBusiness" %>
<%--
  Created by IntelliJ IDEA.
  User: Patata kawaii
  Date: 12/01/2017
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="style/Style.css">
    <title>Agenda</title>
</head>
<body>
<core:set var="list" value="${requestScope.contactos}"/>
<header>
    <img src="images/tomcat.png" alt="logo">
    Tomcat Agenda
</header>
<nav>
    <form action="pantallaAnadir" method='post'><input type='submit' value='a&ntilde;adir'></form>
    <form action="buscarMes" method='post'>
        <select name='mes'>
            <core:forEach begin="0" end="12" var="val">
                <core:if test="${val==0}">
                    <option value="%">TODOS</option>
                </core:if>
                <core:if test="${val!=0}">
                    <option value='${val}'>${val}</option>
                </core:if>
            </core:forEach>
        </select>
        <input type='submit' value='buscar por mes'>
    </form>
    <form action="/logout"><input type='submit' value='logout'></form>
</nav>
<table>
    <tr>
        <th><spring:message code="label.nombreYApellidos"/></th>
        <th><spring:message code="label.telefono"/> </th>
        <th><spring:message code="label.fechaNacimiento"/> </th>
        <th></th>
        <th></th>
    </tr>
    <core:forEach var="contacto" items="${list}">
        <tr>
            <td>
                <core:out value="${contacto.nombre} ${contacto.apellidos}"/>
            </td>
            <td>
                <core:out value="${contacto.telefono}"/>
            </td>
            <td>
                <core:out value="${contacto.fecha}"/>
            </td>
            <td>
                <form action="/modificar" method="get">
                    <%--<input type='submit' value='modificar'>--%>
                        <button type="submit"><spring:message code="label.modificar"/> </button>
                    <input type='hidden' name='id' value='${contacto.id}'>
                </form>
            </td>
            <td>
                <form action='eliminar' method='post'>
                    <input type='hidden' name='id' value=${contacto.id}>
                    <%--<input type='submit' value='eliminar'>--%>
                    <button type="submit"><spring:message code="label.eliminar"/> </button>
                </form>
            </td>
        </tr>
        <%--<%}%>--%>
    </core:forEach>
</table>
</body>
</html>
