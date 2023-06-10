package Controller.Servlet;

import Controller.DAO.UsuarioDAO;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/ranking"})
public class RankingServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UsuarioDAO userDAO = new UsuarioDAO();
        
        try {
            List<Usuario> listUsuario = userDAO.listaUsuarios();
            request.setAttribute("usuario", listUsuario);
            
            request.getRequestDispatcher("ranking.jsp").forward(request, response);
            
        } catch(SQLException ex) {
            
        }
    }

}
