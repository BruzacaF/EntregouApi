package Entregou.database.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Entity
@Table(name = "entrega")
public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_motorista")
    private Motorista motorista;

    @ManyToOne
    @JoinColumn(name = "id_veiculo")
    private Veiculo veiculo;

    @Column(name = "data_coleta")
    private LocalDateTime dataColeta;

    @Column(name = "data_entrega_prevista")
    private LocalDateTime dataEntregaPrevista;

    @Column(name = "data_entrega_real")
    private LocalDateTime dataEntregaReal;

    @Column(name = "status_entrega", length = 50)
    private String statusEntrega;

    @Column(name = "motivo_atraso", columnDefinition = "TEXT")
    private String motivoAtraso;

    @Column(name = "geolocalizacao_eventos", columnDefinition = "TEXT")
    private String geolocalizacaoEventos;

    @ColumnDefault("false")
    @Column(name = "recusado")
    private Boolean recusado;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Motorista getMotorista() { return motorista; }
    public void setMotorista(Motorista motorista) { this.motorista = motorista; }

    public Veiculo getVeiculo() { return veiculo; }
    public void setVeiculo(Veiculo veiculo) { this.veiculo = veiculo; }

    public LocalDateTime getDataColeta() { return dataColeta; }
    public void setDataColeta(LocalDateTime dataColeta) { this.dataColeta = dataColeta; }

    public LocalDateTime getDataEntregaPrevista() { return dataEntregaPrevista; }
    public void setDataEntregaPrevista(LocalDateTime dataEntregaPrevista) { this.dataEntregaPrevista = dataEntregaPrevista; }

    public LocalDateTime getDataEntregaReal() { return dataEntregaReal; }
    public void setDataEntregaReal(LocalDateTime dataEntregaReal) { this.dataEntregaReal = dataEntregaReal; }

    public String getStatusEntrega() { return statusEntrega; }
    public void setStatusEntrega(String statusEntrega) { this.statusEntrega = statusEntrega; }

    public String getMotivoAtraso() { return motivoAtraso; }
    public void setMotivoAtraso(String motivoAtraso) { this.motivoAtraso = motivoAtraso; }

    public String getGeolocalizacaoEventos() { return geolocalizacaoEventos; }
    public void setGeolocalizacaoEventos(String geolocalizacaoEventos) { this.geolocalizacaoEventos = geolocalizacaoEventos; }

    public Boolean getRecusado() { return recusado; }
    public void setRecusado(Boolean recusado) { this.recusado = recusado; }
}