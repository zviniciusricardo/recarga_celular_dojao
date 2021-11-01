package br.com.zupacademy.grupolaranja.recargacelular;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class ClienteRequest {
    
    @NotBlank 
    @Pattern(regexp = "^\\([1-9]{2}\\) (?:[2-8]|9[1-9])[0-9]{3}\\[0-9]{4}$")
    private String numeroCelular;
    
    @NotBlank
    private Enum<Operadora> operadoraEnum;
    
    @NotNull @Positive
    private BigDecimal valorRecarga;
    
    public ClienteRequest(String numeroCelular, Enum<Operadora> operadoraEnum, BigDecimal valorRecarga) {
        this.numeroCelular = numeroCelular;
        this.operadoraEnum = operadoraEnum;
        this.valorRecarga = valorRecarga;
    }
    
    public Cliente toModel(ClienteRepository repository) {
        Cliente cliente = repository.getById();
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
