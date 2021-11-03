package br.com.zupacademy.grupolaranja.recargacelular.negocio;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class RecargaCelularRequest {
    
    @NotBlank
    @Pattern(regexp = "^\\([1-9]{2}\\) (?:[2-8]|9[1-9])[0-9]{3}[0-9]{4}$")
    private String numeroCelular;
    
    @NotNull
    private Operadora operadoraEnum;
    
    @NotNull @Positive
    private BigDecimal valorRecarga;
    
    public RecargaCelularRequest(String numeroCelular, Operadora operadoraEnum, BigDecimal valorRecarga) {
        this.numeroCelular = numeroCelular;
        this.operadoraEnum = operadoraEnum;
        this.valorRecarga = valorRecarga;
    }
    
    public RecargaCelular toModel() {
        return new RecargaCelular(this);
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
}
