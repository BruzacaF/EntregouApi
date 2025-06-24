package Entregou.database.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * DTO for {@link Entregou.database.model.Pacote}
 */
public class PacoteRequest implements Serializable {
    private final Long id;
    private final ClienteDto idClienteRemetente;
    private final Long idClienteDestinatario;
    private final String tipoPacote;
    private final String dimensoes;
    private final BigDecimal peso;
    private final BigDecimal valorDeclarado;
    private final String codigoRastreio;
    private final String descricaoConteudo;
    private final String tipoEmbalagem;
    private final Boolean prioridade;

    public PacoteRequest(Long id, ClienteDto idClienteRemetente, Long idClienteDestinatario, String tipoPacote, String dimensoes, BigDecimal peso, BigDecimal valorDeclarado, String codigoRastreio, String descricaoConteudo, String tipoEmbalagem, Boolean prioridade) {
        this.id = id;
        this.idClienteRemetente = idClienteRemetente;
        this.idClienteDestinatario = idClienteDestinatario;
        this.tipoPacote = tipoPacote;
        this.dimensoes = dimensoes;
        this.peso = peso;
        this.valorDeclarado = valorDeclarado;
        this.codigoRastreio = codigoRastreio;
        this.descricaoConteudo = descricaoConteudo;
        this.tipoEmbalagem = tipoEmbalagem;
        this.prioridade = prioridade;
    }

    public Long getId() {
        return id;
    }

    public ClienteDto getIdClienteRemetente() {
        return idClienteRemetente;
    }

    public Long getIdClienteDestinatario() {
        return idClienteDestinatario;
    }

    public String getTipoPacote() {
        return tipoPacote;
    }

    public String getDimensoes() {
        return dimensoes;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public BigDecimal getValorDeclarado() {
        return valorDeclarado;
    }

    public String getCodigoRastreio() {
        return codigoRastreio;
    }

    public String getDescricaoConteudo() {
        return descricaoConteudo;
    }

    public String getTipoEmbalagem() {
        return tipoEmbalagem;
    }

    public Boolean getPrioridade() {
        return prioridade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PacoteRequest entity = (PacoteRequest) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.idClienteRemetente, entity.idClienteRemetente) &&
                Objects.equals(this.idClienteDestinatario, entity.idClienteDestinatario) &&
                Objects.equals(this.tipoPacote, entity.tipoPacote) &&
                Objects.equals(this.dimensoes, entity.dimensoes) &&
                Objects.equals(this.peso, entity.peso) &&
                Objects.equals(this.valorDeclarado, entity.valorDeclarado) &&
                Objects.equals(this.codigoRastreio, entity.codigoRastreio) &&
                Objects.equals(this.descricaoConteudo, entity.descricaoConteudo) &&
                Objects.equals(this.tipoEmbalagem, entity.tipoEmbalagem) &&
                Objects.equals(this.prioridade, entity.prioridade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idClienteRemetente, idClienteDestinatario, tipoPacote, dimensoes, peso, valorDeclarado, codigoRastreio, descricaoConteudo, tipoEmbalagem, prioridade);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "idClienteRemetente = " + idClienteRemetente + ", " +
                "idClienteDestinatario = " + idClienteDestinatario + ", " +
                "tipoPacote = " + tipoPacote + ", " +
                "dimensoes = " + dimensoes + ", " +
                "peso = " + peso + ", " +
                "valorDeclarado = " + valorDeclarado + ", " +
                "codigoRastreio = " + codigoRastreio + ", " +
                "descricaoConteudo = " + descricaoConteudo + ", " +
                "tipoEmbalagem = " + tipoEmbalagem + ", " +
                "prioridade = " + prioridade + ")";
    }
}