package br.com.zupacademy.grupolaranja.recargacelular.kafka.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmaiDto {

    private String destinatario;
    private String assunto;
    private String corpo;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public EmaiDto(String destinatario, String assunto, String corpo) {
        this.destinatario = destinatario;
        this.assunto = assunto;
        this.corpo = corpo;
    }

    public String paraKafka() throws JsonProcessingException {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            logger.info("Erro ao converter objeto em json "+destinatario+" - "+assunto+" - "+corpo);
            throw e;
        }
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getAssunto() {
        return assunto;
    }

    public String getCorpo() {
        return corpo;
    }
}
