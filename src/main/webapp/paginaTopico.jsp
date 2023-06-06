<%-- 
    Document   : paginaTopico
    Created on : 5 de jun. de 2023, 11:39:38
    Author     : urlas
--%>

<%@page import="Model.Topico"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tópicos</title>
    </head>
    <body>
        <form action="paginaTopico">
            <% 
                String topico = request.getParameter("topico");
            %>
            
            <!-- Uma das possíveis soluções vai ser abstrair em outros métodos, e cada um pegando
            uma parte e distribuindo aqui na página-->
            <h2>Essa é uma página do tópico</h2>
            <p><%= topico %></p>
            <p>guimenezes</p>
        </form>

    </body>
</html>
