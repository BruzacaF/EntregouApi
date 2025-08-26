package Entregou.database.model;

import jakarta.persistence.*;

@Entity
@Table(name = "telefone_usuario")
public class TelefoneUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(name = "numero", nullable = false, length = 20)
    private String numero;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
}