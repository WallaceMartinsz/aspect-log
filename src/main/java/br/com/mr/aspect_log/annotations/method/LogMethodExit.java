package br.com.mr.aspect_log.annotations.method;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogMethodExit {

    String message() default "";
}
