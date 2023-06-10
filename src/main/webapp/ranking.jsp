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
    </head>
    <body>
        <form method="post" action="ranking">
            <h1>Ranking de pontuação Topic Master</h1>
            <table>
                <thead>
                    <tr>
                        <td>Nome</td>
                        <td>Login</td>
                        <td>Pontos</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${usuario}" var="usuario" >
                        <tr>
                            <td>${usuario.nome}</td>
                            <td>${usuario.login}</td>
                            <td>${usuario.pontos}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <input type="submit" value="atualizar ranking"/>
        </form>
        <p>Os requisitos para ganhar pontos são:</p>
        <li>10 pontos por tópico criado</li>
        <li>3 pontos por comentário</li>
    </body>
</html>
