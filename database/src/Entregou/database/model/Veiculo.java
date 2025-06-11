package Entregou.database.model;

import jakarta.persistence.*;

@Entity
@Table(name = "veiculo")
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(unique = true)
    private String placa;

    private String modelo;

    @Column(name = "capacidade_kg", nullable = false)
    private Double capacidadeKg;

    private String tipo;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public Double getCapacidadeKg() { return capacidadeKg; }
    public void setCapacidadeKg(Double capacidadeKg) { this.capacidadeKg = capacidadeKg; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

}