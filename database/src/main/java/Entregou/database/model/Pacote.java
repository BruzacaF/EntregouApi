package Entregou.database.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "pacote")
public class Pacote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente_remetente")
    private Cliente remetente;

    @ManyToOne
    @JoinColumn(name = "id_cliente_destinatario")
    private Cliente destinatario;

    @Column(name = "tipo_pacote", length = 50)
    private String tipoPacote;

    @Column(name = "dimensoes", length = 50)
    private String dimensoes;

    @Column(name = "peso", precision = 10, scale = 2)
    private BigDecimal peso;

    @Column(name = "valor_declarado", precision = 10, scale = 2)
    private BigDecimal valorDeclarado;

    @Column(name = "codigo_rastreio", length = 50)
    private String codigoRastreio;

    @Column(name = "descricao_conteudo", length = Integer.MAX_VALUE)
    private String descricaoConteudo;

    @Column(name = "tipo_embalagem", length = 50)
    private String tipoEmbalagem;

    @ColumnDefault("false")
    @Column(name = "prioridade")
    private Boolean prioridade;

    @ManyToMany
    @JoinTable(name = "entrega_pacote",
            joinColumns = @JoinColumn(name = "id_pacote"),
            inverseJoinColumns = @JoinColumn(name = "id_entrega"))
    private Set<Entrega> entregas = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getIdClienteRemetente() {
        return remetente;
    }

    public void setIdClienteRemetente(Cliente idClienteRemetente) {
        this.remetente = idClienteRemetente;
    }

    public Cliente getIdClienteDestinatario() {
        return remetente;
    }

    public void setIdClienteDestinatario(Cliente idClienteDestinatario) {
        this.destinatario = idClienteDestinatario;
    }

    public String getTipoPacote() {
        return tipoPacote;
    }

    public void setTipoPacote(String tipoPacote) {
        this.tipoPacote = tipoPacote;
    }

    public String getDimensoes() {
        return dimensoes;
    }

    public void setDimensoes(String dimensoes) {
        this.dimensoes = dimensoes;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public BigDecimal getValorDeclarado() {
        return valorDeclarado;
    }

    public void setValorDeclarado(BigDecimal valorDeclarado) {
        this.valorDeclarado = valorDeclarado;
    }

    public String getCodigoRastreio() {
        return codigoRastreio;
    }

    public void setCodigoRastreio(String codigoRastreio) {
        this.codigoRastreio = codigoRastreio;
    }

    public String getDescricaoConteudo() {
        return descricaoConteudo;
    }

    public void setDescricaoConteudo(String descricaoConteudo) {
        this.descricaoConteudo = descricaoConteudo;
    }

    public String getTipoEmbalagem() {
        return tipoEmbalagem;
    }

    public void setTipoEmbalagem(String tipoEmbalagem) {
        this.tipoEmbalagem = tipoEmbalagem;
    }

    public Boolean getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Boolean prioridade) {
        this.prioridade = prioridade;
    }

    public Set<Entrega> getEntregas() {
        return entregas;
    }

    public void setEntregas(Set<Entrega> entregas) {
        this.entregas = entregas;
    }

    public Cliente getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Cliente destinatario) {
        this.destinatario = destinatario;
    }
}