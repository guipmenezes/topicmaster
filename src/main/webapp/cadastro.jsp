<%-- 
    Document   : index
    Created on : 25 de mai. de 2023, 15:54:19
    Author     : urlas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro - TopicMaster</title>
        <link rel="stylesheet" href="css/cadastro.css"/>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Trade+Winds&display=swap" rel="stylesheet">
    </head>
    <body>
        <h1 id="titulo-master">Topic Master</h1>
        <h2 id="titulo">Olá mestre! Preencha os campos abaixo para começar a participar da Topic Master</h2>
        <form method="post" action="cadastro" id="form">
            <p class="formulario-label">Seu nome completo:</p>
            <input class="formulario-field" type="text" name="nome"/>
            <p class="formulario-label">Login que deseja utilizar no site:</p>
            <input class="formulario-field" type="text" name="login"/>
            <p class="formulario-label">Email de acesso:</p>
            <input class="formulario-field" type="text" name="email"/>
            <p class="formulario-label">Insira uma senha, para sua segurança:</p>
            <input class="formulario-field" type="password" name="senha"/>
            <br>
            <input class="formulario-btn" type="submit" value="Se cadastrar"/>
            <br>
            <a href="login.jsp">Já é cadastrado? Clique aqui para acessar a sua conta de Mestre</a>
        </form>
    </body>
</html>
