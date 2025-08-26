package Entregou.database.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column(name = "rua", length = 100)
    private String rua;

    @Column(name = "numero", length = 10)
    private String numero;

    @Column(name = "complemento", length = 50)
    private String complemento;

    @Column(name = "bairro", length = 50)
    private String bairro;

    @Column(name = "cidade", length = 50)
    private String cidade;

    @Column(name = "estado", length = 2)
    private String estado;

    @Column(name = "cep", length = 10)
    private String cep;

    @Column(name = "ponto_referencia", length = 100)
    private String pontoReferencia;

    @ColumnDefault("false")
    @Column(name = "principal")
    private Boolean principal;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public String getRua() { return rua; }
    public void setRua(String rua) { this.rua = rua; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getComplemento() { return complemento; }
    public void setComplemento(String complemento) { this.complemento = complemento; }

    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }

    public String getPontoReferencia() { return pontoReferencia; }
    public void setPontoReferencia(String pontoReferencia) { this.pontoReferencia = pontoReferencia; }

    public Boolean getPrincipal() { return principal; }
    public void setPrincipal(Boolean principal) { this.principal = principal; }
}