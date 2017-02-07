<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="style/Style.css">
  <title>Agenda</title>
</head>
<body>
<header>
  redSocial S.A.
</header>
<article>
  <form action="${pageContext.request.contextPath}/login.do" method="post">
    <label for="nombreUsuario">usuario
      <input type="text" name="nombreUsuario" id="nombreUsuario"/><br>
    </label>
    <label for="password">contrase&ntilde;a <input type="password" name="password"
                                                                            id="password"/></label><br>
    <input type="submit" value="enter">
  </form>
</article>
<a href="crearUsuario.jsp">&iquest;Aun no tienes cuenta?</a>
</body>
</html>