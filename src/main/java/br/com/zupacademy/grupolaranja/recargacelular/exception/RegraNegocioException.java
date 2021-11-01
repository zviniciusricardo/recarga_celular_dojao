package br.com.zupacademy.grupolaranja.recargacelular.exception;

public class RegraNegocioException extends RuntimeException {
    
    private ReturnError erroRetorno;
    
    public RegraNegocioException(String mensagem, String campo, Object value) {
        erroRetorno = new ReturnError();
        erroRetorno.addErrorField(campo, value, mensagem);
    }
    
    public ReturnError getErroRetorno() {
        return erroRetorno;
    }
}
