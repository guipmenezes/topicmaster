package Model;

import java.util.Objects;

public class Usuario {

    private String login;
    private String email;
    private String nome;
    private String senha;
    private int pontos;
    
    public Usuario() {}
    
    public Usuario(String login, String email, String nome, String senha) {
        this.login = login;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.pontos = 0;
    }
    
    public String getLogin() {
        return login;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public int getPontos() {
        return pontos;
    }
     
    public void setLogin(String login) {
        this.login = login;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
    
    public String toString() {
        return "Usuario [login = " + login + ", email = " + email + ", nome = " + nome + ", pontos = " + pontos + "]";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.login);
        hash = 73 * hash + Objects.hashCode(this.email);
        hash = 73 * hash + Objects.hashCode(this.nome);
        hash = 73 * hash + Objects.hashCode(this.senha);
        hash = 73 * hash + this.pontos;
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
        final Usuario other = (Usuario) obj;
        if (this.pontos != other.pontos) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.senha, other.senha);
    }
    
    
    
}
