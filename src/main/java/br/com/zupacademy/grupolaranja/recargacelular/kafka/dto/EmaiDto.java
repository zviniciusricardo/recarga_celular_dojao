package br.com.zupacademy.grupolaranja.recargacelular.kafka.dto;

public class EmaiDto {
    private String destinatario;
    private String mensagem;

    public EmaiDto(String destinatario, String mensagem) {
        this.destinatario = destinatario;
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return "{" +
                "\"destinatario\":\"" + destinatario+ "\"" +
                ", \"mensagem\":\"" + mensagem + "\""+
                '}';
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getMensagem() {
        return mensagem;
    }
}
