package Entregou.database.controller;
import Entregou.database.model.Role;



public class UserProfileResponse {
    private String email;
    private String nome;
    private Role role;

    public UserProfileResponse(String email, String nome, Role role) {
        this.email = email;
        this.nome = nome;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }
    public String getNome() {
        return nome;
    }
    public Role getRole() {
        return role;
    }
}
