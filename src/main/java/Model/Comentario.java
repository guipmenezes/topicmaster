package Model;

import java.util.Objects;


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

    @Override
    public String toString() {
        return "Comentario{" + "idComentario=" + idComentario + ", comentario=" + comentario + ", login=" + login + ", idTopico=" + idTopico + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.idComentario;
        hash = 37 * hash + Objects.hashCode(this.comentario);
        hash = 37 * hash + Objects.hashCode(this.login);
        hash = 37 * hash + this.idTopico;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comentario other = (Comentario) obj;
        if (this.idComentario != other.idComentario) {
            return false;
        }
        if (this.idTopico != other.idTopico) {
            return false;
        }
        if (!Objects.equals(this.comentario, other.comentario)) {
            return false;
        }
        return Objects.equals(this.login, other.login);
    }
}
