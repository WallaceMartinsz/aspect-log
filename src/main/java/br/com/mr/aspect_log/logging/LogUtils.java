package br.com.mr.aspect_log.logging;

import br.com.mr.aspect_log.enums.LogType;

import java.util.Map;

public class LogUtils {

    private LogUtils(){}

    public static String formatLog(Map<LogType, String> params) {
        return params.keySet()
                .stream()
                .map(key -> "\n".concat(key.name()).concat(": ").concat(params.get(key)))
                .reduce(String::concat)
                .orElseThrow(() -> new RuntimeException("Erro ao formatar log: " + params));
    }
}
