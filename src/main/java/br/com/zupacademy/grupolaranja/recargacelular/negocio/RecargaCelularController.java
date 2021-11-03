package br.com.zupacademy.grupolaranja.recargacelular.negocio;

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
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @PostMapping
    @Transactional
    public ResponseEntity<?> recarregaCelular(@RequestBody @Valid RecargaCelularRequest request) {
        RecargaCelular recargaCelular = request.toModel();
        recargaCelularRepository.save(recargaCelular);
        RecargaCelularResponse celularResponse = new RecargaCelularResponse(recargaCelular);
        
        try {
            operadoraInterface.recarregarCelular(new RecarregarRequest(celularResponse));
        } catch (FeignException exception) {
            
            logger.warn("Erro ao tentar conectar com serviço externo "+ exception.getCause()+exception.contentUTF8());
            return ResponseEntity.unprocessableEntity().body("Não foi possível processar essa operação.");
        }
        
        return ResponseEntity.ok().body(celularResponse);
    }
}
