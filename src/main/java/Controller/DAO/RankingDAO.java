package Controller.DAO;

import Model.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RankingDAO {

    private AutenticadorDAO autDAO = new AutenticadorDAO();

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AutenticadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int pontosPorComentario(String login) throws SQLException {
        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/topicmaster?charset=UTF-8", "postgres", "root")) {
            Usuario u = autDAO.recuperaUsuarioLogin(login);

            PreparedStatement pstm = con.prepareStatement("SELECT usuario.login, comentario.comentario FROM usuario INNER JOIN comentario ON usuario.login = comentario.login");

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                if (rs.getString("login") == login) {
                    u.adicionaPonto(3);
                }
            }
            return u.getPontos();
        }
    }
}
