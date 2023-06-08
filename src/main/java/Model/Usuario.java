package Model;

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
    
    public int adicionaPonto(int ponto) {
        return pontos += ponto;
    }
    
    public String toString() {
        return "Usuario [login = " + login + ", email = " + email + ", nome = " + nome + ", pontos = " + pontos + "]";
    }
    
}
