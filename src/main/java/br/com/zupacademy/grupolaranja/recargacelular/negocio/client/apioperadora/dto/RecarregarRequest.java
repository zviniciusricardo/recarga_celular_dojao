package br.com.zupacademy.grupolaranja.recargacelular.negocio.client.apioperadora.dto;

import br.com.zupacademy.grupolaranja.recargacelular.negocio.Operadora;
import br.com.zupacademy.grupolaranja.recargacelular.negocio.RecargaCelularResponse;

import java.math.BigDecimal;

public class RecarregarRequest {

    private String numeroCelular;
    private Enum<Operadora> operadora;
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
