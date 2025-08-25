package Entregou.database.model;

import jakarta.persistence.*;

@Entity
@Table(name = "empresa")
public class Empresa {
    @Id
    @Column(name = "id_cliente")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column(name = "razao_social", length = 100)
    private String razaoSocial;

    @Column(name = "nome_fantasia", length = 100)
    private String nomeFantasia;

    @Column(name = "inscricao_estadual", length = 20)
    private String inscricaoEstadual;

    @Column(name = "cnpj", length = 20)
    private String cnpj;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public String getRazaoSocial() { return razaoSocial; }
    public void setRazaoSocial(String razaoSocial) { this.razaoSocial = razaoSocial; }

    public String getNomeFantasia() { return nomeFantasia; }
    public void setNomeFantasia(String nomeFantasia) { this.nomeFantasia = nomeFantasia; }

    public String getInscricaoEstadual() { return inscricaoEstadual; }
    public void setInscricaoEstadual(String inscricaoEstadual) { this.inscricaoEstadual = inscricaoEstadual; }

    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
}