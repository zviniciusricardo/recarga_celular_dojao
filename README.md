# recarga_celular_dojao
Repositório destinado ao microsserviço recarga de celular do projeto conta digital

### Endpoint recarga de celular
#### /recarga-celulares
 Payload: {"idCliente":"string","numeroCelular": "(46) 999990800","operadoraEnum": "TIM","valorRecarga" : 100}
  Enum operadora:     CLARO, OI, TIM, VIVO, NEXTEL
 retorno: 200 ok quando feita recarga com sucesso e 422 quando der erro na recarga 
## Tópicos do Kafka e payload.
###	Tópico para extrato: 	extratoRecarga
#### Payload para extrato: {"idCliente":"string","valor":BigDecimal,"mensagem":"string"}
###	Tópico para email:		emailRecarga
#### Payload para email: {"idCliente":"string","destinatario":"string","mensagem":"string"} 
