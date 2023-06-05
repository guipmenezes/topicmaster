package Controller.Servlet;

import Controller.DAO.TopicoDAO;
import Model.Topico;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/topicoInicialServlet"})
public class TopicoInicialServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        
        TopicoDAO tpDAO = new TopicoDAO();
        
        String titulo = request.getParameter("titulo");
        
        try {
            Topico tp = tpDAO.topicoPorTitulo(titulo);
            request.setAttribute("topico", tp);
            request.getRequestDispatcher("paginaTopico.jsp").forward(request, response);
            
        } catch(SQLException e) {
            request.setAttribute("erro", e.getMessage());
            request.getRequestDispatcher("falha.jsp").forward(request, response);
        } 
    }

}
