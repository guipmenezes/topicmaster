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
        <link rel="stylesheet" href="css/criaTopico.css"/>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Trade+Winds&display=swap" rel="stylesheet">
    </head>
    <body>
        <form method="post" action="criaTopico">
            <h1 id="titulo-master">TopicMaster</h1>
            <div id="form-topico">
                <h2 class="titulo-top">Sobre o que deseja falar hoje?</h2>
                <div>
                    <p>Título do tópico:</p>
                    <textarea cols="100" rows="5" placeholder="Insira aqui um título..." name="titulo"></textarea>
                </div>
                <div>
                    <p>Insira aqui o conteúdo do tópico</p>
                    <textarea cols="100" rows="10" placeholder="Abra o seu coração..." rows="10" name="conteudo"></textarea>
                </div>
                <input class="form-btn" type="submit" value="Criar tópico"/>
                <p class="regras">Ao clicar em "Criar tópico" você concorda que qualquer ilegalidade ou informação falsa contida no texto do tópico será atribuída ao seu usuário.</p>
            </div>
        </form>
        
    </body>
</html>
