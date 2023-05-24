package Model;

import java.util.ArrayList;
import java.util.List;


public class Topico extends Usuario{
    
    private int idTopico;
    private String titulo;
    private String texto;
    private String login;
    
    public String getTitulo() {
        return titulo;
    }
    
    public String getTexto() {
        return texto;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    public String getUsuario() {
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    
    
    public List<Topico> adicionarTopico(String titulo, String texto, String login) {
        List<Topico> nt = new ArrayList<>();
        
        Topico tp = new Topico();
        tp.setTitulo(titulo);
        tp.setTexto(texto);
        tp.setLogin(login);
        
        nt.add(tp);
        
        return nt;
    }
}
