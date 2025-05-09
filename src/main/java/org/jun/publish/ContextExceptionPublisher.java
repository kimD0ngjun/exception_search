package org.jun.publish;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 스프링 컨텍스트 동작 중의 예외 포착
 */
@ControllerAdvice // 컨트롤러 대상 보조 처리
public class ContextExceptionPublisher {

    private final ApplicationEventPublisher publisher;

    public ContextExceptionPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    // 컨텍스트 범위 전역 예외 처리
    @ExceptionHandler(Exception.class)
    public void handle(Exception e) {
        System.err.println(e.getMessage());
    }
}
