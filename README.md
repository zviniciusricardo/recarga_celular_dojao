# recarga_celular_dojao
Repositório destinado ao microsserviço recarga de celular do projeto conta digital

## Tópicos do Kafka e payload.
###	Tópico para extrato: 	extratoRecarga
#### Payload para extrato: {"idCliente":"string","valor":BigDecimal,"mensagem":"string"}
###	Tópico para email:		emailRecarga
#### Payload para email: {"idCliente":"string","destinatario":"string","mensagem":"string"} 


