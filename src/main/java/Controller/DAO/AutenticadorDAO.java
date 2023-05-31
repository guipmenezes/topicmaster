package Controller.DAO;

import Model.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AutenticadorDAO {

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            Logger.getLogger(AutenticadorDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public String autenticaLogin(String login, String senha) throws SQLException {

        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/topicmaster?charset=UTF-8", "postgres", "root")) {
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM usuario WHERE login = ? AND senha = ?");
            pstm.setString(1, login);
            pstm.setString(2, senha);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                return rs.getString("nome");
            } else {
                throw new SQLException("Não foi possível realizar o login");
            }
        }
    }

    public void cadastraUsuario(Usuario u) throws SQLException {

        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/topicmaster?charset=UTF-8", "postgres", "root")) {
            PreparedStatement pstm = con.prepareStatement("INSERT INTO usuario (login, email, nome, senha, pontos) VALUES(?,?,?,?,?)");
            pstm.setString(1, u.getLogin());
            pstm.setString(2, u.getEmail());
            pstm.setString(3, u.getNome());
            pstm.setString(4, u.getSenha());
            pstm.setInt(5, 0);

            pstm.executeUpdate();
        }
    }

    public String recuperaUsuario(String nome) throws SQLException {
        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/topicmaster?charset=UTF-8", "postgres", "root")) {
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM usuario WHERE nome = ?");
            pstm.setString(1, nome);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                return rs.getString("login");
            } else {
                throw new SQLException("Não foi achar o usuário");
            }
        }
    }
}
