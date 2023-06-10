package Controller.Servlet;

import Controller.DAO.UsuarioDAO;
import Controller.DAO.TopicoDAO;
import Model.Topico;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
        
        UsuarioDAO autentica = new UsuarioDAO();
        TopicoDAO tpDAO = new TopicoDAO();
        
        try{
            String nome = autentica.autenticaLogin(login, senha);
            
            Cookie cookiesUsuario = new Cookie("nome", nome);
            cookiesUsuario.setMaxAge(-1);
            response.addCookie(cookiesUsuario);
            
            List<Topico> topicos = tpDAO.retornaTopico();
            request.setAttribute("topico", topicos);
            request.setAttribute("nome", nome);
            request.getRequestDispatcher("topicoInicial.jsp").forward(request, response);
            
        } catch(SQLException e) {
            request.setAttribute("erro", e.getMessage());
            request.getRequestDispatcher("falha.jsp").forward(request, response);
        } 
    }


}
