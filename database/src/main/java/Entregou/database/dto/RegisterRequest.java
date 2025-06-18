package Entregou.database.dto;
import Entregou.database.model.Role;

public class RegisterRequest {
    private String nome;
    private String email;
    private String senha;
    private Role role;


    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getSenha() {return senha;}
    public void setSenha(String senha) {this.senha = senha;}

    public Role getRole() {return role;}
    public void setRole(Role role) {this.role = role;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
}
