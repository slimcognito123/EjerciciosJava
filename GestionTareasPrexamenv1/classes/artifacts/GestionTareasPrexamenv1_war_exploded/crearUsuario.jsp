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
    <form action="${pageContext.request.contextPath}/createUser.do" method="post">
        <label for="nombreUsuario">usuario</label>
        <input type="text" name="nombreUsuario" id="nombreUsuario" required/>
        <br>
        <label for="password">contrase&ntilde;a<input type="password" name="password" id="password"
                                                                                required/></label><br>
       <button type="submit">
            crear
        </button>
    </form>
</article>
<a href="index.jsp">volver</a>
</body>