package Entregou.database.model;

import jakarta.persistence.*;

@Entity
@Table(name = "entrega_pacote")
public class EntregaPacote {
    @EmbeddedId
    private EntregaPacoteId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idEntrega")
    @JoinColumn(name = "id_entrega")
    private Entrega entrega;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idPacote")
    @JoinColumn(name = "id_pacote")
    private Pacote pacote;

    // Getters e Setters
    public EntregaPacoteId getId() { return id; }
    public void setId(EntregaPacoteId id) { this.id = id; }

    public Entrega getEntrega() { return entrega; }
    public void setEntrega(Entrega entrega) { this.entrega = entrega; }

    public Pacote getPacote() { return pacote; }
    public void setPacote(Pacote pacote) { this.pacote = pacote; }
}