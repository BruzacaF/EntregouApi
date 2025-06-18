package Entregou.database.dto;

import Entregou.database.model.Role;

import java.io.Serializable;



public class UsuarioResponse implements Serializable {
    private final String nome;
    private final String email;
    private final Role role;

    public UsuarioResponse( String nome, String email, Role role) {

        this.nome = nome;
        this.email = email;
        this.role = role;
    }

    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
    public Role getRole() {
        return role;
    }


}