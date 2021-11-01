package br.com.zupacademy.grupolaranja.recargacelular;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class RecargaCelular {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    private String numeroCelular;
    private Enum<Operadora> operadoraEnum;
    private BigDecimal valorRecarga;
    
    
    public RecargaCelular(RecargaCelularRequest request) {
    }
}
