package br.com.zupacademy.grupolaranja.recargacelular;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class RecargaCelular {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String idCliente;

    @Column(nullable = false)
    private String numeroCelular;
    
    @Column(nullable = false, updatable = false)
    @Enumerated
    private Operadora operadoraEnum;
    
    @Column(nullable = false, updatable = false)
    private BigDecimal valorRecarga;
    
    @Column(nullable = false, updatable = false)
    private LocalDateTime criadoEm;
    
    
    public RecargaCelular(RecargaCelularRequest request) {
        this.idCliente = request.getIdCliente();
        this.numeroCelular = request.getNumeroCelular();
        this.operadoraEnum = request.getOperadoraEnum();
        this.valorRecarga = request.getValorRecarga();
        this.criadoEm = LocalDateTime.now();
    }
    
    @Deprecated
    public RecargaCelular() {
    }
    
    public Long getId() {
        return id;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }
    
    public Operadora getOperadoraEnum() {
        return operadoraEnum;
    }
    
    public BigDecimal getValorRecarga() {
        return valorRecarga;
    }
    
    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }
}
