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
    </head>
    <body>
        <h2>Olá mestre! Preencha os campos abaixo para começar a participar da Topic Master:</h2>
        <form method="POST" action="cadastro">
            <p>Seu nome completo:</p>
            <input type="text" name="nome"/>
            <p>Login que deseja utilizar no site:</p>
            <input type="text" name="login"/>
            <p>Email de acesso:</p>
            <input type="text" name="email"/>
            <p>Insira uma senha, para sua segurança:</p>
            <input type="password" name="senha"/>
            <input type="submit" value="Se cadastrar"/>
            <br>
            <a href="login.jsp">Já é cadastrado? Clique aqui para acessar a sua conta de Mestre</a>
        </form>
    </body>
</html>
