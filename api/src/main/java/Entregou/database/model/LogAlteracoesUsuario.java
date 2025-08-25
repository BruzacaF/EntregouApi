package Entregou.database.model;

import Entregou.database.model.Usuario;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import java.time.LocalDateTime;

@Entity
@Table(name = "log_alteracoes_usuario")
public class LogAlteracoesUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(name = "campo_alterado", length = 100)
    private String campoAlterado;

    @Column(name = "valor_antigo", columnDefinition = "TEXT")
    private String valorAntigo;

    @Column(name = "valor_novo", columnDefinition = "TEXT")
    private String valorNovo;

    @ColumnDefault("NOW()")
    @Column(name = "data_alteracao")
    private LocalDateTime dataAlteracao;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public String getCampoAlterado() { return campoAlterado; }
    public void setCampoAlterado(String campoAlterado) { this.campoAlterado = campoAlterado; }

    public String getValorAntigo() { return valorAntigo; }
    public void setValorAntigo(String valorAntigo) { this.valorAntigo = valorAntigo; }

    public String getValorNovo() { return valorNovo; }
    public void setValorNovo(String valorNovo) { this.valorNovo = valorNovo; }

    public LocalDateTime getDataAlteracao() { return dataAlteracao; }
    public void setDataAlteracao(LocalDateTime dataAlteracao) { this.dataAlteracao = dataAlteracao; }
}