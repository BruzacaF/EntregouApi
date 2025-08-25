package Entregou.database.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EntregaPacoteId implements Serializable {
    private Long idEntrega;
    private Long idPacote;

    // Construtores
    public EntregaPacoteId() {}

    public EntregaPacoteId(Long idEntrega, Long idPacote) {
        this.idEntrega = idEntrega;
        this.idPacote = idPacote;
    }

    // Getters e Setters
    public Long getIdEntrega() { return idEntrega; }
    public void setIdEntrega(Long idEntrega) { this.idEntrega = idEntrega; }

    public Long getIdPacote() { return idPacote; }
    public void setIdPacote(Long idPacote) { this.idPacote = idPacote; }

    // equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntregaPacoteId that = (EntregaPacoteId) o;
        return Objects.equals(idEntrega, that.idEntrega) &&
               Objects.equals(idPacote, that.idPacote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEntrega, idPacote);
    }
}