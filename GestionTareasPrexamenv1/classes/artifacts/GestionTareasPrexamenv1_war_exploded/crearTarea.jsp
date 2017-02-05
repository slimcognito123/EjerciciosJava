<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style/Style.css">
    <title>Agenda</title>
</head>
<body>
<header>
    <img src="images/tomcat.png" alt="logo">
    Tomcat Agenda
</header>
<article>
    <form action="${pageContext.request.contextPath}/crearTarea.do" method="post">
        <label for="titulo">titulo</label>
        <input type="text" name="titulo" id="titulo" required/>
        <br>
        <label for="descripcion">descripcion<input type="text" name="descripcion" id="descripcion"
                                                      required/></label><br>
        <button type="submit">
            crear
        </button>
    </form>
</article>
<a href="${pageContext.request.contextPath}/buscarTodos.do">volver</a>
</body>