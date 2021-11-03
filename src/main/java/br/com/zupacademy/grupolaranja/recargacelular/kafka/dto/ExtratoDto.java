package br.com.zupacademy.grupolaranja.recargacelular.kafka.dto;

import java.math.BigDecimal;

public class ExtratoDto {
    private BigDecimal valor;
    private String mensagem;

    public ExtratoDto(BigDecimal valor, String mensagem) {
        this.valor = valor;
        this.mensagem = mensagem;
    }


    @Override
    public String toString() {
        return "{" +
                "\"valor\":" + valor +
                ", \"tipoTransacao\":\"" + mensagem + "\""+
                '}';
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getTipoTransacao() {
        return mensagem;
    }
}
