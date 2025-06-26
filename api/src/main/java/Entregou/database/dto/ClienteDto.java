package Entregou.database.dto;

import Entregou.database.model.Usuario;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link Entregou.database.model.Cliente}
 */
public class ClienteDto implements Serializable {
    private final Long id;
    private final String nome;
    private final String email;


    public ClienteDto(Long id,

                      String nome,
                      String email) {
        this.id = id;

        this.nome = nome;
        this.email = email;

    }

    public Long getId() {
        return id;
    }

    public String getNome() { return nome; }

    public String getEmail() { return email; }





}