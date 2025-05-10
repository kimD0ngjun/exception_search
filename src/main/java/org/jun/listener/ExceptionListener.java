package org.jun.listener;

import org.jun.dto.ExceptionInfoDTO;
import org.springframework.context.event.EventListener;
import org.springframework.web.reactive.function.client.WebClient;

public class ExceptionListener {

    private final WebClient webClient;

    public ExceptionListener(WebClient webClient) {
        this.webClient = webClient;
    }

    @EventListener
    public void listenException(ExceptionInfoDTO request) {
        System.err.println("예외 커스텀 포착");
        System.out.println("예외명: " + request.getExceptionName() + "\n"
        + "요청 URI: " + request.getRequestUri() + "\n"
        + "요청 메세지: " + request.getMessage() + "\n"
        + "타임스탬프: " + request.getTimestamp() + "\n"
        + "클래스 출처: " + request.getOriginClass() + "\n"
        + "메소드 출처: " + request.getOriginMethod() + "\n"
        + "모듈 출처: " + request.getOriginModule() + "\n");
    }
}
