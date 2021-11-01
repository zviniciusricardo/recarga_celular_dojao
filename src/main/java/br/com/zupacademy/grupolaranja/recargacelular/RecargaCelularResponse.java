package br.com.zupacademy.grupolaranja.recargacelular;

import java.math.BigDecimal;

public class RecargaCelularResponse {
    
    public String numeroCelular;
    public String operadora;
    public String saldo;
    public String criadoEm;
    
    
    public RecargaCelularResponse(RecargaCelular recargaCelular) {
        this.numeroCelular = recargaCelular.getNumeroCelular();
        this.operadora = recargaCelular.getOperadoraEnum().toString();
        this.saldo = recargaCelular.getValorRecarga().toString();
        this.criadoEm = recargaCelular.getCriadoEm().toString();
    }
    
    public String getNumeroCelular() {
        return numeroCelular;
    }
    
    public String getOperadora() {
        return operadora;
    }
    
    public String getSaldo() {
        return saldo;
    }
    
    public String getCriadoEm() {
        return criadoEm;
    }
}
