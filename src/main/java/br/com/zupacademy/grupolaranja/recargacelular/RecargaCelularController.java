package br.com.zupacademy.grupolaranja.recargacelular;

import br.com.zupacademy.grupolaranja.recargacelular.kafka.EmailTopicProducer;
import br.com.zupacademy.grupolaranja.recargacelular.kafka.ExtratoTopicProducer;
import br.com.zupacademy.grupolaranja.recargacelular.kafka.dto.EmaiDto;
import br.com.zupacademy.grupolaranja.recargacelular.kafka.dto.ExtratoDto;
import br.com.zupacademy.grupolaranja.recargacelular.apioperadora.ApiOperadoraInterface;
import br.com.zupacademy.grupolaranja.recargacelular.apioperadora.dto.RecarregarRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/recarga-celulares")
public class RecargaCelularController {
    
    @Autowired
    private RecargaCelularRepository recargaCelularRepository;
    
    @Autowired
    private ApiOperadoraInterface operadoraInterface;

    @Autowired
    private EmailTopicProducer emailTopicProducer;

    @Autowired
    private ExtratoTopicProducer extratoTopicProducer;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping
    @Transactional
    public ResponseEntity<?> recarregaCelular(@RequestBody @Valid RecargaCelularRequest request) {
        RecargaCelular recargaCelular = request.toModel();
        RecargaCelularResponse celularResponse = new RecargaCelularResponse(recargaCelular);

        try {
            operadoraInterface.recarregarCelular(new RecarregarRequest(celularResponse));
            recargaCelularRepository.save(recargaCelular);
            ExtratoDto extratoDto;
            EmaiDto emailDto;
            extratoDto = new ExtratoDto(request.getIdCliente(),celularResponse.getValor(),
                    "Foi realizado uma recarga no valor de "+request.getValorRecarga()
                            +" para o n??mero "+request.getNumeroCelular());
            emailDto = new EmaiDto(request.getEmail(), "Uma nova recarga foi Efetuada",
                    "Uma nova recarga de celular foi efetuada no valor de "+request.getValorRecarga()+
                    " para o n??mero "+request.getNumeroCelular());
            this.alimentarTopicos(extratoDto, emailDto);
            logger.info("Foi realizado uma recarga no valor de "+celularResponse.getValor()+" para o n??mero "+celularResponse.getNumeroCelular());

        } catch (FeignException exception) {

            logger.warn("Erro ao tentar conectar com servi??o externo "+ exception.getCause()+exception.contentUTF8());
            return ResponseEntity.unprocessableEntity().body("N??o foi poss??vel processar essa opera????o.");
        }
        
        return ResponseEntity.ok().body(celularResponse);
    }

    private void alimentarTopicos(ExtratoDto extrato, EmaiDto email) {
        try {
            extratoTopicProducer.send(extrato.paraKafka());
            emailTopicProducer.send(email.paraKafka());
        }catch (Exception exception){
            logger.warn("Ocorreu um erro ao enviar mensagens para o kafka "+
                    exception.getMessage()+" - "+exception.getCause());
        }
    }
}
