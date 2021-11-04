package br.com.zupacademy.grupolaranja.recargacelular.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmailTopicProducer {

    @Value("${topic.email.producer}")
    private String topicName;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final KafkaTemplate<String, String> kafkaTemplate;

    public EmailTopicProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String message){
        logger.info("Payload enviado: "+message);
        kafkaTemplate.send(topicName, message);
    }

}