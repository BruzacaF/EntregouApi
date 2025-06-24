package Entregou.database.dto;

import java.io.Serializable;

/**
 * DTO for {@link Entregou.database.model.Pacote}
 */
public class PacoteResponse implements Serializable {
    private final String destinatario;
    private final String remetente;
    private final String tipoPacote;
    private final String codigoRastreio;
    private final String descricaoConteudo;
    private final Boolean prioridade;



    public PacoteResponse(String destinatario,
                          String remetente,
                          String tipoPacote,
                          String codigoRastreio,
                          String descricaoConteudo,
                          Boolean prioridade) {
        this.destinatario = destinatario;
        this.remetente = remetente;
        this.tipoPacote = tipoPacote;
        this.codigoRastreio = codigoRastreio;
        this.descricaoConteudo = descricaoConteudo;
        this.prioridade = prioridade;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getRemetente() { return remetente; }

    public String getTipoPacote() {
        return tipoPacote;
    }

    public String getCodigoRastreio() {
        return codigoRastreio;
    }

    public String getDescricaoConteudo() {
        return descricaoConteudo;
    }

    public Boolean getPrioridade() { return prioridade; }



}