<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: curso mañana
  Date: 01/02/2017
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ofertas</title>
</head>
<body>
<c:forEach items="${ofertas}" var="o">
    Hotel ${o.hotel} un mínimo de
    ${o.numeroNoches} noches por solo ${o.precio}eur./noche<br>
</c:forEach>
</body>
</html>
