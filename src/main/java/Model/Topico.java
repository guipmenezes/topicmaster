package Model;


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
    
    public String getLogin() {
        return login;
    }
    
    public int getIdTopico() {
        return idTopico;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
}
