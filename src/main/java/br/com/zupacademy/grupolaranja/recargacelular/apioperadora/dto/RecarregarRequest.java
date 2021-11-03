package br.com.zupacademy.grupolaranja.recargacelular.apioperadora.dto;

import br.com.zupacademy.grupolaranja.recargacelular.Operadora;
import br.com.zupacademy.grupolaranja.recargacelular.RecargaCelularResponse;

import java.math.BigDecimal;

public class RecarregarRequest {

    private String numeroCelular;
    private Operadora operadora;
    private BigDecimal valorRecarga;

    public RecarregarRequest(RecargaCelularResponse celularResponse) {
        this.numeroCelular = celularResponse.getNumeroCelular();
        this.operadora = celularResponse.getOperadora();
        this.valorRecarga = celularResponse.getValor();
        
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public BigDecimal getValorRecarga() {
        return valorRecarga;
    }
}
