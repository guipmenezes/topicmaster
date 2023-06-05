<%-- 
    Document   : paginaTopico
    Created on : 31 de mai. de 2023, 12:28:12
    Author     : urlas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tópico para discussão</title>
    </head>
    <body>
        <form action="paginaTopicoServlet">
            <h2>${topico.titulo}</h2>     
            <p>Criado por: ${topico.login}</p>
            <p>${topico.texto}</p>
        </form>
        
    </body>
</html>
