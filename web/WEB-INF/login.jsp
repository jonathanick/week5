<%-- 
    Document   : login
    Created on : Feb 10, 2021, 1:15:56 PM
    Author     : 828200
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="login" method="post">
        <h2> Username: <input type="text" name="username" value="${session.username}"></h2><br>
        <h2> Password: <input type="text" name="password" value="${session.password}"></h2><br>
        <input type="submit" value="Log in"><br>
        </form>
        <h2>${message}</h2>
    </body>
</html>
