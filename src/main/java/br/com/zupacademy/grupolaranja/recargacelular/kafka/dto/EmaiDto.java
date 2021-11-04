package br.com.zupacademy.grupolaranja.recargacelular.kafka.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmaiDto {

    private String idCliente;
    private String destinatario;
    private String mensagem;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public EmaiDto(String destinatario, String mensagem, String idCliente) {
        this.destinatario = destinatario;
        this.mensagem = mensagem;
        this.idCliente = idCliente;
    }

    public String paraKafka() throws JsonProcessingException {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            logger.info("Erro ao converter objeto em json "+idCliente+" - "+mensagem+" - "+destinatario);
            throw e;
        }
    }

    public String getIdCliente() {
        return idCliente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getMensagem() {
        return mensagem;
    }
}
