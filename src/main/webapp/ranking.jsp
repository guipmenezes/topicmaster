<%-- 
    Document   : ranking
    Created on : 8 de jun. de 2023, 13:18:35
    Author     : urlas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ranking</title>
        <link rel="stylesheet" href="css/ranking.css"/>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Trade+Winds&display=swap" rel="stylesheet">
    </head>
    <body>
        <form method="post" action="ranking">
            <h1 id="titulo-master">TopicMaster</h1>
            <h2>Ranking de pontuação Topic Master</h2>
            <table id="tabela" border="1px">
                <thead>
                    <tr class="tabela-head">
                        <td class="tabela-titulo">Nome</td>
                        <td class="tabela-titulo">Login</td>
                        <td class="tabela-titulo">Pontos</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${usuario}" var="usuario" >
                        <tr>
                            <td class="tabela-linha">${usuario.nome}</td>
                            <td class="tabela-linha">${usuario.login}</td>
                            <td class="tabela-linha">${usuario.pontos}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <input class="form-btn" type="submit" value="Atualizar ranking"/>
        </form>
        <p>Os requisitos para ganhar pontos são:</p>
        <li>10 pontos por tópico criado</li>
        <li>3 pontos por comentário</li>
    </body>
</html>
