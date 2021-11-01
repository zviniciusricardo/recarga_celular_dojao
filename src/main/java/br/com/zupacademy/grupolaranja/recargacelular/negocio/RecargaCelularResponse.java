package br.com.zupacademy.grupolaranja.recargacelular.negocio;

import java.math.BigDecimal;

public class RecargaCelularResponse {
    
    public String numeroCelular;
    public Enum<Operadora> operadora;
    public BigDecimal valor;
    
    public RecargaCelularResponse(RecargaCelular recargaCelular) {
        this.numeroCelular = recargaCelular.getNumeroCelular();
        this.operadora = recargaCelular.getOperadoraEnum();
        this.valor = recargaCelular.getValorRecarga();
    }
    
    public String getNumeroCelular() {
        return numeroCelular;
    }
    
    public Enum<Operadora> getOperadora() {
        return operadora;
    }
    
    public BigDecimal getValor() {
        return valor;
    }
}
