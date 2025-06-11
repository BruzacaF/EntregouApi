package Entregou.database.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pacote")
public class Pacote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String descricao;

    @Column(name = "peso_kg", nullable = false)
    private Double pesoKg;

    private String tamanho;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "armazem_origem_id")
    private Armazem armazemOrigem;

    @ManyToOne
    @JoinColumn(name = "armazem_destino_id")
    private Armazem armazemDestino;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Double getPesoKg() { return pesoKg; }
    public void setPesoKg(Double pesoKg) { this.pesoKg = pesoKg; }

    public String getTamanho() { return tamanho; }
    public void setTamanho(String tamanho) { this.tamanho = tamanho; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Armazem getArmazemOrigem() { return armazemOrigem; }
    public void setArmazemOrigem(Armazem armazemOrigem) { this.armazemOrigem = armazemOrigem; }

    public Armazem getArmazemDestino() { return armazemDestino; }
    public void setArmazemDestino(Armazem armazemDestino) { this.armazemDestino = armazemDestino; }

}