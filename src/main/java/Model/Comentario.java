package Model;


public class Comentario extends Topico{
    
    private int idComentario;
    private String comentario;
    private String login;
    private int idTopico;
    
    public String getComentario() {
        return comentario;
    }
    
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public int getIdTopico() {
        return idTopico;
    }
    
    public void setIdTopico(int idTopico) {
        this.idTopico = idTopico;
    }
    
    public int getIdComentario() {
        return idComentario;
    }
    
    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }
}
