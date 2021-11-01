package br.com.zupacademy.grupolaranja.recargacelular.negocio.client.apioperadora.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class OperadoraResponse {

    @JsonProperty
    private String numero;
    @JsonProperty
    private BigDecimal valor;

    public OperadoraResponse(String numero, BigDecimal valor) {
        this.numero = numero;
        this.valor = valor;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
