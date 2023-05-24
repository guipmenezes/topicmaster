package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "CadastroServlet", urlPatterns = {"/cadastro"})
public class CadastroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome = request.getParameter("nome");
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        AutenticadorDAO autentica = new AutenticadorDAO();
        try{
            autentica.cadastraUsuario(login, email, nome, senha);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } catch(SQLException e) {
            request.setAttribute("erro", e.getMessage());
            request.getRequestDispatcher("falha.jsp");
        } 
    }


}
