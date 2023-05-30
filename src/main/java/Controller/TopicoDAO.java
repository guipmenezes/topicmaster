package Controller;

import Model.Topico;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Cookie;

public class TopicoDAO {

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            Logger.getLogger(AutenticadorDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public List<Topico> retornaTopico() throws SQLException {
        List<Topico> nt = new ArrayList<>();

        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/topicmaster?charset=UTF-8", "postgres", "root")) {
            PreparedStatement pstm = con.prepareStatement("SELECT titulo, login FROM topico");
            
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()) {
                Topico tp = new Topico();
                tp.setTitulo(rs.getString("titulo"));
                tp.setLogin(rs.getString("login"));
                nt.add(tp);
            }
            return nt;
        }

    }

    public void criaTopico(String titulo, String conteudo, String login) throws SQLException {
        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/topicmaster?charset=UTF-8", "postgres", "root")) {

            PreparedStatement pstm = con.prepareStatement("INSERT INTO topico (titulo, conteudo, login) VALUES(?,?,?)");
            pstm.setString(1, titulo);
            pstm.setString(2, conteudo);
            pstm.setString(3, login);

            pstm.executeUpdate();
        }
    }
    
    //Gerenciamento de Cookie
    public String iteradorCookie(Cookie[] cookies, String objetoP) {
        if(cookies != null) {
            for (Cookie cookie : cookies) {
                if ((cookie.getName() != null) && (cookie.getName().equals(objetoP))) {
                    objetoP = cookie.getValue();
                }
            }
        }
        return objetoP;
    }

}
