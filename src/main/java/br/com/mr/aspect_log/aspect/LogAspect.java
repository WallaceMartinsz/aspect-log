package br.com.mr.aspect_log.aspect;

import br.com.mr.aspect_log.annotations.method.LogMethodEntry;
import br.com.mr.aspect_log.annotations.method.LogMethodExit;
import br.com.mr.aspect_log.enums.LogType;
import br.com.mr.aspect_log.logging.LogUtils;
import br.com.mr.aspect_log.logging.Sl4jLogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Aspect
@Component
public class LogAspect {

    private final Sl4jLogger logger = new Sl4jLogger(LogAspect.class);

    @Before("@annotation(logMethodEntry)")
    public void logEntry(JoinPoint joinPoint, LogMethodEntry logMethodEntry) {
        String logFormatado = buildLog(joinPoint, logMethodEntry.message());
        logger.log(logFormatado, org.slf4j.event.Level.INFO);
    }

    @Before("@annotation(logMethodExit)")
    public void logExit(JoinPoint joinPoint, LogMethodExit logMethodExit) {
        String logFormatado = buildLog(joinPoint, logMethodExit.message());
        logger.log(logFormatado, org.slf4j.event.Level.INFO);
    }

    private String buildLog(JoinPoint joinPoint, String mensagem) {
        String nomeClasse = joinPoint.getTarget().getClass().getSimpleName();
        String nomeMetodo = joinPoint.getSignature().getName();

        Map<LogType, String> params = new LinkedHashMap<>();
        params.put(LogType.CLASS, nomeClasse);
        params.put(LogType.METHOD, nomeMetodo);
        params.put(LogType.MESSAGE, mensagem);

        return LogUtils.formatLog(params);
    }
}
