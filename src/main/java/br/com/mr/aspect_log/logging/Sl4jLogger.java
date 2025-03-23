package br.com.mr.aspect_log.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sl4jLogger {

    private Logger logger;

    public Sl4jLogger(Class logClass) {
        this.logger = LoggerFactory.getLogger(logClass);
    }

    public void logInfo(String log) {
        logger.info(log);
    }

    public void logError(String log) {
        logger.error(log);
    }
}
