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
        <title>Cadastro - Topic Master</title>
    </head>
    <body>
        <h2>Para ser um mestre dos tópicos, preencha as informações abaixo:</h2>
        <form method="POST">
            <p>Seu nome completo:</p>
            <input type="text" name="nome"/>
            <p>Login que deseja utilizar no site:</p>
            <input type="text" name="login"/>
            <p>Email de acesso:</p>
            <input type="text" name="email"/>
            <p>Insira uma senha, para sua segurança:</p>
            <input type="password" name="senha"/>
            <input type="submit" value="Se cadastrar"/>
        </form>
    </body>
</html>
