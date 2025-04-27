package br.com.mr.aspect_log.testelocal;

import br.com.mr.aspect_log.annotations.method.LogMethodEntry;
import br.com.mr.aspect_log.annotations.method.LogMethodExit;
import org.springframework.stereotype.Component;

@Component
public class Teste {

    @LogMethodEntry(message = "INICIANDO A OPERAÇÃO")
    @LogMethodExit(message = "SOMA REALIZADA COM SUCESSO")
    public int soma(int numero1, int numero2) {
        return numero1 + numero2;
    }

    @LogMethodEntry(message = "INICIANDO A OPERAÇÃO")
    @LogMethodExit(message = "SUBTRAÇÃO REALIZADA COM SUCESSO")
    public int subtracao(int numero1, int numero2) {
        return numero1 - numero2;
    }
}
