package org.jun.publish;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionPublisher {

    private final ApplicationEventPublisher publisher;

    public GlobalExceptionPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @ExceptionHandler(Exception.class)
    public void handle(Exception e) {
        System.err.println(e.getMessage());
    }
}
