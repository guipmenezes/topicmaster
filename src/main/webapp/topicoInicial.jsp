<%-- 
    Document   : topicoInicial
    Created on : 24 de mai. de 2023, 19:08:35
    Author     : urlas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Inicial - Topic Master</title>
    </head>
    <body>
        
            <h1>Bem-vindo <a value="nome">${nome}</a>!</h1>
            <h2>O que deseja fazer hoje?</h2>
            <a href="criarTopico.jsp"><input type="submit" value="Criar novo tópico"/></a>
            <a href="ranking.jsp"><input type="button" value="Ver ranking" /></a>
        <form action="topicoInicialServlet">
            <h2>Tópicos abertos</h2>
            <table>
                <tbody>
                    <c:forEach items="${topico}" var="tp">
                    <tr>
                        <td name="titulo">${tp.titulo}</td>
                        <td name="login">${tp.login}</td>
                    </tr>
                    </c:forEach>
                    
                </tbody>
            </table>
        </form>
        
        
    </body>
</html>
