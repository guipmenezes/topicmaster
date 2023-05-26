<%-- 
    Document   : cadastro
    Created on : 23 de mai. de 2023, 16:31:54
    Author     : urlas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login - Topic Master</title>
    </head>
    <body>
        <h2>Bem vindo de volta mestre, forneça suas informações abaixo:</h2>
        <form method="POST" action="login">
            <p class="label">Login:</p>
            <input type="text" name="login"/>
            <p>Senha:</p>
            <input type="password" name="senha"/>
            <input type="submit" value="Fazer login"/>
        </form>
    </body>
</html>
