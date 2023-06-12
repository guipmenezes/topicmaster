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
        <link rel="stylesheet" href="css/login.css"/>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Trade+Winds&display=swap" rel="stylesheet">
    </head>
    <body>
        <h1 id="titulo-master">Topic Master</h1>
        <h2 id="titulo">Bem vindo de volta mestre, forneça suas informações abaixo:</h2>
        <form method="post" action="login" id="form">
            <p class="formulario-label">Login:</p>
            <input type="text" name="login" class="formulario-field"/>
            <p class="formulario-label">Senha:</p>
            <input type="password" name="senha" class="formulario-field"/>
            <input type="submit" value="Fazer login" class="formulario-btn"/>
        </form>
    </body>
</html>
