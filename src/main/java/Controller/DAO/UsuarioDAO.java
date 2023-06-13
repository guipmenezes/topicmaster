package Controller.DAO;

import Model.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
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

        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/coursera?charset=UTF-8", "postgres", "root")) {
            PreparedStatement pstm = con.prepareStatement("INSERT INTO usuario (login, email, nome, senha, pontos) VALUES(?,?,?,?,?)");
            pstm.setString(1, u.getLogin());
            pstm.setString(2, u.getEmail());
            pstm.setString(3, u.getNome());
            pstm.setString(4, u.getSenha());
            pstm.setInt(5, 0);

            pstm.executeUpdate();
        }
    }

    public String recuperaUsuarioNome(String nome) throws SQLException {
        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/coursera?charset=UTF-8", "postgres", "root")) {
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

    public Usuario recuperaUsuarioLogin(String login) throws SQLException {
        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/coursera?charset=UTF-8", "postgres", "root")) {
            Usuario u = new Usuario();

            PreparedStatement pstm = con.prepareStatement("SELECT * FROM usuario WHERE login = ?");
            pstm.setString(1, login);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                u.setLogin(rs.getString("login"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setPontos(rs.getInt("pontos"));
                return u;
            } else {
                throw new SQLException("Não foi achar o usuário");
            }
        }
    }

    public List<Usuario> listaUsuarios() throws SQLException {
        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/coursera?charset=UTF-8", "postgres", "root")) {
            List<Usuario> list = new ArrayList<>();

            PreparedStatement pstm = con.prepareStatement("SELECT * FROM usuario ORDER BY pontos DESC");

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setLogin(rs.getString("login"));
                u.setEmail(rs.getString("email"));
                u.setNome(rs.getString("nome"));
                u.setSenha(rs.getString("senha"));
                u.setPontos(rs.getInt("pontos"));
                list.add(u);
            }

            return list;
        }
    }
}
