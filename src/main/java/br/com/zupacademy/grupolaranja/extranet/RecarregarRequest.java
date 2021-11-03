package br.com.zupacademy.grupolaranja.extranet;

import java.math.BigDecimal;

public class RecarregarRequest {

    private String numeroCelular;
    private Operadora operadora;
    private BigDecimal valorRecarga;

    public RecarregarRequest(String numeroCelular, Operadora operadora, BigDecimal valorRecarga) {
        this.numeroCelular = numeroCelular;
        this.operadora = operadora;
        this.valorRecarga = valorRecarga;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public BigDecimal getValorRecarga() {
        return valorRecarga;
    }
}
