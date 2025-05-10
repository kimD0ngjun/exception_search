package org.jun.listener;

import org.jun.dto.ExceptionInfoDTO;
import org.jun.request.ExceptionInfoRequest;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

public class ExceptionListener {

    private final WebClient webClient;

    public ExceptionListener(WebClient webClient) {
        this.webClient = webClient;
    }

    @EventListener
    public void listenException(ExceptionInfoDTO dto) {
        System.err.println("예외 커스텀 포착");
        System.out.println("예외명: " + dto.getExceptionName() + "\n"
        + "요청 URI: " + dto.getRequestUri() + "\n"
        + "요청 메세지: " + dto.getMessage() + "\n"
        + "타임스탬프: " + dto.getTimestamp() + "\n"
        + "클래스 출처: " + dto.getOriginClass() + "\n"
        + "메소드 출처: " + dto.getOriginMethod() + "\n"
        + "모듈 출처: " + dto.getOriginModule() + "\n");

        ExceptionInfoRequest request = ExceptionInfoDTO.of(dto);
        webClient.post()
                .uri("/exception-log")
                .bodyValue(request)
                .retrieve()
                // 클라이언트에 예외를 전달하는 게 맞으려나?
                .onStatus(HttpStatusCode::is4xxClientError, ClientResponse::createException)
                .onStatus(HttpStatusCode::is5xxServerError, ClientResponse::createException)
                .bodyToMono(Void.class)
                .doOnError(error -> System.err.println("예외 전송 실패: " + error.getMessage()))
                .subscribe();
    }
}
