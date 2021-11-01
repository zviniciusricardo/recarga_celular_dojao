package br.com.zupacademy.grupolaranja.recargacelular.apioperadora.dto;

import java.math.BigDecimal;

public class RecarregarRequest {

    private String numeroCelular;
    private BigDecimal valorRecarga;

    public RecarregarRequest(String numeroCelular, BigDecimal valorRecarga) {
        this.numeroCelular = numeroCelular;
        this.valorRecarga = valorRecarga;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public BigDecimal getValorRecarga() {
        return valorRecarga;
    }
}
