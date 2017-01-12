<%--
  Created by IntelliJ IDEA.
  User: curso mañana
  Date: 12/01/2017
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!
    String nombre;
    //pene
    int edad;
%>
<% nombre=(String) request.getAttribute("nombre");
    edad=(int)request.getAttribute("edad");
%>
<%= "hola "+nombre+" tu edad es "+edad+"a&ntilde;os"%>
</body>
</html>
