<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<jsp:useBean class="beans.Mensaje" id="mensaje"/>
<jsp:useBean class="beans.Lista" id="lista"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<jsp:setProperty name="mensaje" property="texto" value="soy una patata"/>
El valor en la variable <b>texto</b> es: <br/>
<core:set var="texto" value="esto es un texto"/>
<b>
    &quot
    <core:out value="${mensaje.texto}" default="El valor es null"/>
    &quot
</b>
<p>
    El valor de la variable <b>texto</b> es :
    <core:out value="${texto}"/>
</p>
<p>
    <core:remove var="texto" scope="page"/>
    <core:out value="${texto}" default="bean! patata"/>
</p>
<p>
    <core:catch var="exception">
        <%=3 / 0%>
    </core:catch>
    <core:if test="${
            exception!=null
        }">
        ocurrió una exception: <core:out value="${exception}"/>
    </core:if>
</p>
<p>
    <core:set var="a" value="100"/>
    <core:if test="${a > 100}">
        La variable <b>${a}</b> es <b>mayor</b> que 100.
    </core:if>
    <core:if test="${a < 100 }">
        La variable <b>${a}</b> es <b>menor</b> que 100.
    </core:if>
</p>
<p>
    <core:set var="a" value="1"/>
    <core:choose>
        <core:when test="${a == 1}"><!--if-->
            <b>a</b> es 1.
        </core:when>
        <core:when test="${a == 2 }"><!--if else-->
            <b>a</b> es 2.
        </core:when>
        <core:otherwise><!--else-->
            <b>a</b> tiene un valor diferente de 1 y de 2.
        </core:otherwise>
    </core:choose>
</p>
<p>
    <core:forEach var="nombreActual" items="${lista.listaDeNombres}">
        <b><core:out value="${nombreActual}"/></b> <br/>
    </core:forEach>
</p>
<core:set var="oracion" value="Estos,son,los,tokens,de,la,frase"/> Los tokens son los siguientes: <p>
    <core:forTokens items="${oracion}" delims="," var="token" varStatus="i"> <b>
        <core:out value="${i.count}"/>.</b>
        <core:out value="${token}"/> <br/>
    </core:forTokens>
</p>
<p>
    <core:import url="otroArchivo.jsp"/>
    Contenido de <b>index.jsp</b> .....
</p>
<p>
    Click en el enlace para enviar el parametro :
    <a href="<core:url value="nuevaJSP.jsp"><core:param name="nombre" value="Banana"/> </core:url>">
        link
    </a>
</p>
<%--<core:redirect url="nuevaJSP.jsp">--%>
    <%--<core:param name="nombre" value="patata"/>--%>
<%--</core:redirect>--%>
</body>
</html>