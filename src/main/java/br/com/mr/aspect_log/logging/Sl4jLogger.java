package br.com.mr.aspect_log.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;

public class Sl4jLogger {

    private Logger logger;

    public Sl4jLogger(Class logClass) {
        this.logger = LoggerFactory.getLogger(logClass);
    }

    public void log(String log, Level level) {

        switch(level) {
            case INFO -> logger.info(log);
            case WARN -> logger.warn(log);
            case ERROR -> logger.error(log);
            case DEBUG -> logger.debug(log);
            case TRACE -> logger.trace(log);
        }
    }
}
