<%-- 
    Document   : criarTopico
    Created on : 25 de mai. de 2023, 21:01:07
    Author     : urlas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Criar novo tópico</title>
    </head>
    <body>
        <form method="post" action="criaTopico">
            <h1>Sobre o que deseja falar hoje?</h1>
            <div>
                <p>Título do tópico:</p>
                <textarea placeholder="Insira aqui um título..." name="titulo"></textarea>
            </div>
            <div>
                <p>Insira aqui o conteúdo do tópico</p>
                <textarea placeholder="Abra o seu coração..." rows="10" name="conteudo"></textarea>
            </div>
            <input type="submit" value="Criar tópico" />
            <p>Ao clicar em criar tópico você concorda que qualquer ilegalidade ou informação falsa contida no texto do tópico será atribuída ao seu usuário.</p>
        </form>
        
    </body>
</html>
