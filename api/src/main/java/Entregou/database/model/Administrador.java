package Entregou.database.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "administrador")
public class Administrador {
    @Id
    @Column(name = "id_usuario")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(name = "ultimo_login")
    private LocalDateTime ultimoLogin;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public LocalDateTime getUltimoLogin() { return ultimoLogin; }
    public void setUltimoLogin(LocalDateTime ultimoLogin) { this.ultimoLogin = ultimoLogin; }
}