package Entregou.database.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private Long id;


    @OneToOne
    @MapsId
    @JoinColumn(name = "id_usuario", nullable = false, unique = true)
    private Usuario usuario;

    private String tipoPessoa;
    private String cpfCnpj;

    private String getCpfCnpj() { return cpfCnpj; } ;
    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    private String getTipoPessoa() { return tipoPessoa; } ;
    public void setTipoPessoa(String novoTipo){
        this.tipoPessoa = novoTipo;
    }



    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }



}