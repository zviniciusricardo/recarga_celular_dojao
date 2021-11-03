package br.com.zupacademy.grupolaranja.extranet;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/operadora")
public class EndpointOperadora {

    @PostMapping
    public ResponseEntity<String> recarga(@RequestBody RecarregarRequest request){
        System.out.println(request.getValorRecarga().compareTo(new BigDecimal("10")));
        if (request.getValorRecarga().compareTo(new BigDecimal("10")) == -1){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

}
