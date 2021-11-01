package br.com.zupacademy.grupolaranja.recargacelular.negocio;


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
    public RecargaCelularRepository recargaCelularRepository;
    
    @PostMapping
    @Transactional
    public ResponseEntity<?> recarregaCelular(@RequestBody @Valid RecargaCelularRequest request) {
        RecargaCelular recargaCelular = request.toModel();
        recargaCelularRepository.save(recargaCelular);
        
        return ResponseEntity.ok().body(new RecargaCelularResponse(recargaCelular));
    }
}
