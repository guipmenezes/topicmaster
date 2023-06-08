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
    </head>
    <body>
        <form method="post" action="paginaTopico">
            <div>
                <h2>${topico.titulo}</h2>
                <p>por ${topico.login}</p>
                <p>${topico.texto}</p> 
            </div>
            <div>
                <h3>Comentários</h3>
                <c:forEach items="${comentario}" var="com" >
                    <p>${com.comentario}</p>
                    <p>${com.login}</p>
                </c:forEach>
            </div>
            <div>
                <h3>Adicionar comentário</h3>
                <textarea placeholder="Adicione aqui seu comentário" name="comentario"></textarea>
                <input type="hidden" name="titulo" value="${topico.titulo}"/>
                <input type="hidden" name="idTopico" value="${topico.idTopico}" />
                <input type="submit" value="adicionar">
            </div>
        </form>
    </body>
</html>
