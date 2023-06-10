package Controller.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RankingDAO {

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void adicionaPontoComentario(String login) throws SQLException {
        try(Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/topicmaster?charset=UTF-8", "postgres", "root")) {
            PreparedStatement pstm = con.prepareStatement("UPDATE usuario SET pontos = pontos + 3 WHERE login = ?");
            pstm.setString(1, login);
            
            pstm.executeUpdate();
        }
        
    }
    
    public void adicionaPontoTopico(String login) throws SQLException {
        try(Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/topicmaster?charset=UTF-8", "postgres", "root")) {
            PreparedStatement pstm = con.prepareStatement("UPDATE usuario SET pontos = pontos + 10 WHERE login = ?");
            pstm.setString(1, login);
            
            pstm.executeUpdate();
        }
    }
}
