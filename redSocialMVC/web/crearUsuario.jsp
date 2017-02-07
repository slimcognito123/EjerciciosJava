<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style/Style.css">
    <title>Agenda</title>
</head>
<body>
<header>
    <%--<img src="images/tomcat.png" alt="logo">--%>
    redSocial S.A.
</header>
<article>
    <form action="${pageContext.request.contextPath}/createUser.do" method="post">
        <label for="nombreUsuario">usuario
            <input type="text" name="nombreUsuario" id="nombreUsuario" required/></label>
        <br>
        <label for="password">contrase&ntilde;a<input type="password" name="password" id="password"
                                                      required/></label><br>
        <label for="email">
            em@il
            <input type="email" name="email" id="email" required>
        </label><br>
        <label for="imagen"> imagen de perfil<input type="url" name="imagen" id="imagen"/></label><br>
        <button type="submit">
            crear
        </button>
    </form>
</article>
<a href="index.jsp">volver</a>
</body>