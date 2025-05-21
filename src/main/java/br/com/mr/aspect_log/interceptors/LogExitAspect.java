package br.com.mr.aspect_log.interceptors;

import br.com.mr.aspect_log.annotations.method.LogMethodExit;
import br.com.mr.aspect_log.enums.LogType;
import br.com.mr.aspect_log.logging.LogUtils;
import br.com.mr.aspect_log.logging.Sl4jLogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.event.Level;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Aspect
public class LogExitAspect {

    @After("@annotation(br.com.mr.aspect_log.annotations.method.LogMethodExit)")
    public void logMethodExit(JoinPoint joinPoint) {

        var signature = (MethodSignature) joinPoint.getSignature();
        if(signature.getMethod().isAnnotationPresent(LogMethodExit.class)) {
            var method = signature.getMethod();
            var logMethodExitAnnotation = method.getAnnotation(LogMethodExit.class);

            var methodLog = method.getName();
            var messageLog = logMethodExitAnnotation.message();

            var logMap = Map.of(LogType.METHOD, methodLog,
                                LogType.MESSAGE, messageLog);
            var log = LogUtils.formatLog(logMap);

            var logger = new Sl4jLogger(method.getDeclaringClass());
            logger.log(log, Level.INFO);
        }
    }
}
