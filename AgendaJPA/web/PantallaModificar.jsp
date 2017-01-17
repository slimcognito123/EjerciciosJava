<%@ page import="Controlador.AgendaController" %>
<%@ page import="Beans.Contacto" %><%--
  Created by IntelliJ IDEA.
  User: Patata kawaii
  Date: 12/01/2017
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="style/Style.css">
    <title>Agenda</title>
</head>
<body>

<%
    Contacto contacto;
    AgendaController agendaController = new AgendaController();
    String usuario = (String) session.getAttribute("user");
    contacto = agendaController.recuperarPersona(Integer.parseInt(request.getParameter("id")));
%>
<header>
    <img src="images/tomcat.png" alt="logo">
    Tomcat Agenda
</header>
<nav>
    <form action="/buscarMes" method="post">
        <input type="submit" value="volver al menu">
    </form>
</nav>

<article>
    <form action="modificar" method="post">
        <label>
            telefono:
            <input type="number" name="tlf" value=<%="'"+contacto.getTelefono()+"'"%>><br>
        </label>
        <label>
            nombre:
            <input type="text" name="nombre" value=<%="'"+contacto.getNombre()+"'"%>><br>
        </label>
        <label>
            apellido:
            <input type="text" name="apellido" value=<%="'"+contacto.getApellidos()+"'"%>><br>
        </label>
        <label>
            Fecha Nacimiento:
            <input type="date" name="date" value=<%="'"+contacto.getFecha()+"'"%>><br>
        </label>
        <input type='hidden' name='id' value=<%="'"+contacto.getId()+"'"%>>
        <input type="submit" value="modificar">
    </form>
</article>
</body>
</html>
