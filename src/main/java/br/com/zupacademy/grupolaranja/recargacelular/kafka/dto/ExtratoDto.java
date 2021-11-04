package br.com.zupacademy.grupolaranja.recargacelular.kafka.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class ExtratoDto {

    private String idCliente;
    private BigDecimal valor;
    private String mensagem;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public ExtratoDto(String idCliente, BigDecimal valor, String mensagem) {
        this.valor = valor;
        this.mensagem = mensagem;
        this.idCliente = idCliente;
    }

    public String paraKafka() throws JsonProcessingException {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            logger.warn("Erro ao converter objeto para json"+idCliente+" - "+mensagem+" - "+valor);
            throw e;
        }
    }

    public String getIdCliente() {
        return idCliente;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getMensagem() {
        return mensagem;
    }
}
