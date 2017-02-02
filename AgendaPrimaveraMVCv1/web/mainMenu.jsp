<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <form action="${pageContext.request.contextPath}/STA.do" method='post'>
        <button type="submit"><spring:message code="label.anadir"/></button>
    </form>
    <form action="${pageContext.request.contextPath}/search.do" method='post'>
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
    <form action="${pageContext.request.contextPath}/logout.do">
        <button type='submit'><spring:message code="label.logout"/></button>
    </form>
</nav>
<table>
    <tr>
        <th><spring:message code="label.nombreYApellidos"/></th>
        <th><spring:message code="label.telefono"/></th>
        <th><spring:message code="label.fechaNacimiento"/></th>
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
                <form action="${pageContext.request.contextPath}/modifyContact.do" method="get">
                    <button type="submit"><spring:message code="label.modificar"/></button>
                    <input type='hidden' name='id' value='${contacto.id}'>
                </form>
            </td>
            <td>
                <form action='${pageContext.request.contextPath}/removePerson.do' method='post'>
                    <input type='hidden' name='id' value=${contacto.id}>
                    <button type="submit"><spring:message code="label.eliminar"/></button>
                </form>
            </td>
        </tr>
    </core:forEach>
</table>
</body>
</html>
