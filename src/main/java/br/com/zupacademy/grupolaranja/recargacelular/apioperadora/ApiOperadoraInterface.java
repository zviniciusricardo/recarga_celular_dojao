package br.com.zupacademy.grupolaranja.recargacelular.apioperadora;

import br.com.zupacademy.grupolaranja.recargacelular.apioperadora.dto.OperadoraResponse;
import br.com.zupacademy.grupolaranja.recargacelular.apioperadora.dto.RecarregarRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "${feign.client.operadora.url}", name = "ApiOperadora")
public interface ApiOperadoraInterface {
    
    @PostMapping
    OperadoraResponse recarregarCelular(@RequestBody RecarregarRequest request);
}
