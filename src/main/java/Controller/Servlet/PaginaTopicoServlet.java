package Controller.Servlet;

import Controller.DAO.UsuarioDAO;
import Controller.DAO.ComentarioDAO;
import Controller.DAO.RankingDAO;
import Controller.DAO.TopicoDAO;
import Model.Comentario;
import Model.Topico;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/paginaTopico"})
public class PaginaTopicoServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        
        TopicoDAO tpDAO = new TopicoDAO();
        UsuarioDAO autDAO = new UsuarioDAO();
        ComentarioDAO comDAO = new ComentarioDAO();
        RankingDAO rnk = new RankingDAO();
        
        Cookie[] cookies = request.getCookies();
        String nome = tpDAO.iteradorCookie(cookies, "nome");
        String titulo = request.getParameter("titulo");
        int idTopico = Integer.parseInt(request.getParameter("idTopico"));
        String comentario = request.getParameter("comentario");
        
        try {
            String login = autDAO.recuperaUsuarioNome(nome);
            comDAO.inserirComentario(comentario, login, idTopico);
            rnk.adicionaPontoComentario(login);
            
            List<Comentario> comList = comDAO.buscarComentarioPorIdPost(idTopico);
            Topico topico = tpDAO.topicoPorTitulo(titulo);
            
            request.setAttribute("topico", topico);
            request.setAttribute("comentario", comList);
            request.getRequestDispatcher("paginaTopico.jsp").forward(request, response);
            
        } catch (SQLException ex) {
            request.setAttribute("erro", ex.getMessage());
            request.getRequestDispatcher("falha.jsp").forward(request, response);
        }
        
        
    }
}
