package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        AutenticadorDAO autentica = new AutenticadorDAO();
        try{
            String nome = autentica.autenticaLogin(login, senha);
            request.setAttribute("nome", nome);
            request.getRequestDispatcher("topicoInicial.jsp").forward(request, response);
        } catch(SQLException e) {
            request.setAttribute("erro", e.getMessage());
            request.getRequestDispatcher("falha.jsp").forward(request, response);
        } 
    }


}
