package Controller.Servlet;

import Controller.DAO.ComentarioDAO;
import Controller.DAO.TopicoDAO;
import Controller.DAO.UsuarioDAO;
import Model.Comentario;
import Model.Topico;
import Model.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/topicoInicial"})
public class TopicoInicialServlet extends HttpServlet {
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        
        String titulo = request.getParameter("titulo");
        
        ComentarioDAO comDAO = new ComentarioDAO();
        TopicoDAO tpDAO = new TopicoDAO();
        
        try {
            Topico topico = tpDAO.topicoPorTitulo(titulo);
            List<Comentario> comList = comDAO.buscarComentarioPorIdPost(topico.getIdTopico());
            request.setAttribute("topico", topico);
            request.setAttribute("comentario", comList);
            request.getRequestDispatcher("paginaTopico.jsp").forward(request, response);
        } catch (SQLException ex) {
            request.setAttribute("erro", ex.getMessage());
            request.getRequestDispatcher("falha.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        
        request.setCharacterEncoding("UTF-8");
        
        UsuarioDAO userDAO = new UsuarioDAO();
        
        try {
            List<Usuario> listUsuario = userDAO.listaUsuarios();
            request.setAttribute("usuario", listUsuario);
            
            request.getRequestDispatcher("ranking.jsp").forward(request, response);
            
        } catch(SQLException ex) {
            request.setAttribute("erro", ex.getMessage());
            request.getRequestDispatcher("falha.jsp").forward(request, response);
        }
    }

}
