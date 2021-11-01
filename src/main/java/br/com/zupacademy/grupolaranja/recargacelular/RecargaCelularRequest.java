package br.com.zupacademy.grupolaranja.recargacelular;

import br.com.zupacademy.grupolaranja.recargacelular.validation.UniqueValue;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class RecargaCelularRequest {
    
    @NotBlank
    @UniqueValue(domainClass = RecargaCelular.class, fieldName = "numeroCelular")
    @Pattern(regexp = "^\\([1-9]{2}\\) (?:[2-8]|9[1-9])[0-9]{3}[0-9]{4}$")
    private String numeroCelular;
    
    @NotBlank
    private Enum<Operadora> operadoraEnum;
    
    @NotNull @Positive
    private BigDecimal valorRecarga;
    
    public RecargaCelularRequest(String numeroCelular, Enum<Operadora> operadoraEnum, BigDecimal valorRecarga) {
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
    
    public Enum<Operadora> getOperadoraEnum() {
        return operadoraEnum;
    }
    
    public BigDecimal getValorRecarga() {
        return valorRecarga;
    }
}
