<%-- 
    Document   : Login
    Created on : 10/05/2018, 12:18:06 PM
    Author     : _SERGIO_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Login" method="POST">
            <input type="text" placeholder="usuario" name="email"/>
            <input type="password" placeholder="contraseña" name="pass"/>
            <input type="submit" value="enviar"/>
        </form>
    </body>
</html>
