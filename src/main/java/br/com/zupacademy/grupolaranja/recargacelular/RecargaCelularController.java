package br.com.zupacademy.grupolaranja.recargacelular;


import br.com.zupacademy.grupolaranja.recargacelular.exception.RegraNegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/recarga-celular")
public class RecargaCelularController {
    
    @Autowired
    public RecargaCelularRepository recargaCelularRepository;
    
    @Transactional
    public ResponseEntity<?> recarregaCelular(@RequestBody @Valid RecargaCelularRequest request) {
        Optional<RecargaCelular> recargaCelular = recargaCelularRepository.
                findByNumeroCelular(request.getNumeroCelular()).orElseThrow(new RegraNegocioException());
        
        recargaCelularRepository.save(recargaCelular);
        
        return ResponseEntity.ok().body(new ClienteResponse(recargaCelular), HttpStatus.CREATED);
    }
}
