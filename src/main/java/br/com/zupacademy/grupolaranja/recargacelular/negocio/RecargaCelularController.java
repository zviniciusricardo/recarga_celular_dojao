package br.com.zupacademy.grupolaranja.recargacelular.negocio;

import br.com.zupacademy.grupolaranja.recargacelular.kafka.EmailTopicProducer;
import br.com.zupacademy.grupolaranja.recargacelular.kafka.ExtratoTopicProducer;
import br.com.zupacademy.grupolaranja.recargacelular.kafka.dto.EmaiDto;
import br.com.zupacademy.grupolaranja.recargacelular.kafka.dto.ExtratoDto;
import br.com.zupacademy.grupolaranja.recargacelular.negocio.client.apioperadora.ApiOperadoraInterface;
import br.com.zupacademy.grupolaranja.recargacelular.negocio.client.apioperadora.dto.RecarregarRequest;
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
            extratoDto = new ExtratoDto(celularResponse.getValor(),
                    "Foi realizado uma recarga no valor de "+celularResponse.getValor()+" para o número "+celularResponse.getNumeroCelular());
            emailDto = new EmaiDto("user@com.br",
                    "Foi realizado uma recarga no valor de "+celularResponse.getValor()+" para o número "+celularResponse.getNumeroCelular());
            this.alimentarTopicos(extratoDto, emailDto);
            logger.info("Foi realizado uma recarga no valor de "+celularResponse.getValor()+" para o número "+celularResponse.getNumeroCelular());


        } catch (FeignException exception) {

            logger.warn("Erro ao tentar conectar com serviço externo "+ exception.getCause()+exception.contentUTF8());
            return ResponseEntity.unprocessableEntity().body("Não foi possível processar essa operação.");
        }
        
        return ResponseEntity.ok().body(celularResponse);
    }

    private void alimentarTopicos(ExtratoDto extrato, EmaiDto email) {
        extratoTopicProducer.send(extrato.toString());
        emailTopicProducer.send(email.toString());
    }
}
