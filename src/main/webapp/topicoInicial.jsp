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
        <link rel="stylesheet" href="css/pagInicial.css"/>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Trade+Winds&display=swap" rel="stylesheet">
    </head>
    <body>
        <h1 id="titulo-master">Bem-vindo ${nome}!</h1>
        <h2 id="titulo">O que deseja fazer hoje?</h2>
        <div id="container-opcao">
            <a href="criarTopico.jsp"><input class="opcao" type="submit" value="Criar novo tópico"/></a>
            <form action="topicoInicial" method="get">
                <a href="ranking.jsp"><input class="opcao" type="submit" value="Ver ranking" /></a>
            </form>
        </div>
        
        <form method="post" action="topicoInicial" id="form">
            <div class="form-tops">
                <h2 id="titulo">Discussões do momento...</h2>
                <div class="form-head-table">
                    <p class="form-titulo">TÓPICO</p>
                    <p class="form-titulo">CRIADOR</p>
                </div>
                <c:forEach items="${topico}" var="tp">
                    <div class="form-table">
                        <input class="form-titulo" type="submit" name="titulo" value="${tp.titulo}"/>
                        <p class="form-login" name="login">${tp.login}</p>
                    </div>
                </c:forEach>
            </div>
        </form>
    </body>
</html>
