package Controller.Servlet;

import Controller.DAO.UsuarioDAO;
import Model.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/cadastro"})
public class CadastraServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        UsuarioDAO autentica = new UsuarioDAO();
        Usuario usuario = new Usuario(login, email, nome, senha);

        try {
            autentica.cadastraUsuario(usuario);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } catch (SQLException e) {
            request.setAttribute("erro", e.getMessage());
            request.getRequestDispatcher("falha.jsp").forward(request, response);
        }
    }

}
