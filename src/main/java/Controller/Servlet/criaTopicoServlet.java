package Controller.Servlet;

import Controller.DAO.AutenticadorDAO;
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


@WebServlet(urlPatterns = {"/criaTopico"})
public class CriaTopicoServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String titulo = request.getParameter("titulo");
        String conteudo = request.getParameter("conteudo");
        
        Cookie[] cookieUsuario = request.getCookies();
        
        TopicoDAO tp = new TopicoDAO();
        AutenticadorDAO at = new AutenticadorDAO();
        String nome = tp.iteradorCookie(cookieUsuario, "nome");
        
        try {
            String login = at.recuperaUsuarioNome(nome);
            tp.criaTopico(titulo, conteudo, login);
            
            List<Topico> listaTopico = tp.retornaTopico();
            
            request.setAttribute("nome", nome);
            request.setAttribute("topico", listaTopico);
            request.getRequestDispatcher("topicoInicial.jsp").forward(request,response);
            
        } catch(SQLException e) {
            request.setAttribute("erro", e.getMessage());
            request.getRequestDispatcher("falha.jsp").forward(request, response);
        }
    }

}
