package Entregou.database.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "motorista")
public class Motorista {
    @Id
    @Column(name = "id_usuario")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(name = "cnh", length = 20)
    private String cnh;

    @Column(name = "categoria_cnh", length = 5, nullable = false)
    private String categoriaCnh; // A, B, C, D, E

    @Column(name = "validade_cnh")
    private LocalDate validadeCnh;

    @Column(name = "avaliacao_media", precision = 3, scale = 2)
    private BigDecimal avaliacaoMedia;

    @Column(name = "ultima_entrega_id")
    private Integer ultimaEntregaId;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public String getCnh() { return cnh; }
    public void setCnh(String cnh) { this.cnh = cnh; }

    public String getCategoriaCnh() { return categoriaCnh; }
    public void setCategoriaCnh(String categoriaCnh) { this.categoriaCnh = categoriaCnh; }

    public LocalDate getValidadeCnh() { return validadeCnh; }
    public void setValidadeCnh(LocalDate validadeCnh) { this.validadeCnh = validadeCnh; }

    public BigDecimal getAvaliacaoMedia() { return avaliacaoMedia; }
    public void setAvaliacaoMedia(BigDecimal avaliacaoMedia) { this.avaliacaoMedia = avaliacaoMedia; }

    public Integer getUltimaEntregaId() { return ultimaEntregaId; }
    public void setUltimaEntregaId(Integer ultimaEntregaId) { this.ultimaEntregaId = ultimaEntregaId; }
}