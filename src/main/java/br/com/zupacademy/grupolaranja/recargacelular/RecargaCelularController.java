package br.com.zupacademy.grupolaranja.recargacelular;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.PersistenceContext;

@RestController
@RequestMapping("/recarga-celular")
public class RecargaCelularController {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @PersistenceContext
    public ResponseEntity<?> recarregaCelular(@RequestBody ClienteRequest request) {
        Cliente cliente = request.toModel();
        
        return ResponseEntity.ok().body(new ClienteResponse(cliente), HttpStatus.CREATED);
    }
}
