<%-- 
    Document   : paginaTopico
    Created on : 5 de jun. de 2023, 11:39:38
    Author     : urlas
--%>

<%@page import="java.util.List"%>
<%@page import="Model.Comentario"%>
<%@page import="Controller.DAO.ComentarioDAO"%>
<%@page import="Model.Topico"%>
<%@page import="Controller.DAO.TopicoDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tópicos</title>
        <link rel="stylesheet" href="css/pagTopico.css"/>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Trade+Winds&display=swap" rel="stylesheet">
    </head>
    <body>
        <h1 id="titulo-master">TopicMaster</h1>
        <form method="post" action="paginaTopico" id="form-topico">
            <div class="topico-base">
                <h2 class="form-titulo">${topico.titulo}</h2>
                <p class="form-login">por ${topico.login}</p>
                <p class="form-texto">${topico.texto}</p> 
            </div>
            <h3>Comentários</h3>
            <div>
                <c:forEach items="${comentario}" var="com" >
                    <div class="topico-com">
                        <p class="com-com">${com.comentario}</p>
                        <p class="com-login">${com.login}</p>
                    </div>
                </c:forEach>
            </div>
            <h3>Adicionar comentário</h3>
            <div>
                <textarea placeholder="Adicione aqui seu comentário" cols="40" rows="5"  name="comentario"></textarea>
                <input type="hidden" name="titulo" value="${topico.titulo}"/>
                <input type="hidden" name="idTopico" value="${topico.idTopico}" />
                <input type="submit" value="adicionar">
            </div>
        </form>
    </body>
</html>
