<%-- 
    Document   : Exito
    Created on : 10/05/2018, 12:46:41 PM
    Author     : _SERGIO_
--%>

<%@page import="beans.UsuarioBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ingresado con éxito</h1>
        <%-- UsuarioBean us = (UsuarioBean)request.getAttribute("us");--%>
        <jsp:useBean id="us" class="beans.UsuarioBean" scope="request">
            </jsp:useBean>
        <h2>El usuario es:</h2>
        <jsp:getProperty name="us" property="usuario"></jsp:getProperty>
        <h1>${us.usuario}</h1>
        <%--= us.getUsuario() --%>
    </body>
</html>
