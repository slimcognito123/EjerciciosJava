<%@ page import="Beans.Persona" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Controlador.AgendaController" %><%--
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
<%

    ArrayList<Persona> list = (ArrayList<Persona>) request.getAttribute("contactos");
    System.out.println(list);
%>
<header>
    <img src="images/tomcat.png" alt="logo">
    Tomcat Agenda
</header>
<nav>
    <form action="pantallaAnadir" method='post'><input type='submit' value='a&ntilde;adir'></form>
    <form action="buscarMes" method='post'>
        <select name='mes'>
            <% for (int i = 0; i < 13; i++) {
                if (i == 0) {%>
            <option value='%'>TODOS</option>
            <%} else {%>
            <option value=<%=i%>><%=i%>
            </option>
            <%}
            }%>
        </select>
        <input type='submit' value='buscar por mes'>
    </form>
    <form action="/logout"><input type='submit' value='logout'></form>
</nav>
<table>
    <tr>
        <th>Nombre y apellidos</th>
        <th>Telefono</th>
        <th>Fecha nacimiento</th>
        <th></th>
        <th></th>
    </tr>
    <% for (Persona persona : list) {%>
    <tr>
        <td><%=persona.getNombre() + " " + persona.getApellidos()%>
        </td>
        <td><%=persona.getTelefono()%>
        </td>
        <td><%=persona.getFecha()%>
        </td>
        <td>
            <form action="PantallaModificar.jsp" method="post">
                <input type='submit' value='modificar'>
                <input type='hidden' name='id' value=<%="'"+persona.getId()+"'"%>>
            </form>
        </td>
        <td>
            <form action='eliminar' method='post'>
                <input type='hidden' name='id' value=<%="'"+persona.getId()+"'"%>>
                <input type='submit' value='eliminar'>
            </form>
        </td>
    </tr>
    <%}%>
</table>
</body>
</html>
