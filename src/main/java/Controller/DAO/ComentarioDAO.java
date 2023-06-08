package Controller.DAO;

import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Comentario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ComentarioDAO {

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch(ClassNotFoundException ex) {
            Logger.getLogger(AutenticadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void inserirComentario(String comentario, String login, int idTopico) throws SQLException{
        
        try(Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/topicmaster?charset=UTF-8", "postgres", "root")) {
            
            PreparedStatement pstm = con.prepareStatement("INSERT INTO comentario (comentario, login, id_topico) VALUES (?,?,?)");
            pstm.setString(1, comentario);
            pstm.setString(2, login);
            pstm.setInt(3, idTopico);
            
            pstm.executeUpdate();
        }
    }
    
    public List<Comentario> buscarComentarioPorIdPost(int idTopico) throws SQLException{
        try(Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/topicmaster?charset=UTF-8", "postgres", "root")) {
            List<Comentario> list = new ArrayList<>();
            
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM comentario WHERE id_topico = ?");
            pstm.setInt(1, idTopico);
            
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()) {
                Comentario comen = new Comentario();
                comen.setComentario(rs.getString("comentario"));
                comen.setLogin(rs.getString("login"));
                comen.setIdComentario(rs.getInt("id_comentario"));
                list.add(comen);
            }
            return list;
        }
    }
}
