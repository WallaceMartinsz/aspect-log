package br.com.mr.aspect_log.testelocal;

import br.com.mr.aspect_log.annotations.method.LogMethodExit;
import org.springframework.stereotype.Component;

@Component
public class Teste {

    @LogMethodExit(message = "SOMA REALIZADA COM SUCESSO")
    public int soma(int numero1, int numero2) {
        return numero1 + numero2;
    }

    @LogMethodExit(message = "SUBTRACAO REALIZADA COM SUCESSO")
    public int subtracao(int numero1, int numero2) {
        return numero1 - numero2;
    }
}
