package org.jun.listener;

import org.jun.dto.ExceptionInfoRequest;
import org.jun.exception.AsyncExceptionInfo;
import org.jun.exception.ContextExceptionInfo;
import org.jun.exception.FilterServletExceptionInfo;
import org.springframework.context.event.EventListener;
import org.springframework.web.reactive.function.client.WebClient;

public class ExceptionListener {

    private final WebClient webClient;

    public ExceptionListener(WebClient webClient) {
        this.webClient = webClient;
    }

    @EventListener
    public void listenContextException(ContextExceptionInfo info) {
        ExceptionInfoRequest request = ExceptionInfoRequest.from(info);
        System.err.println("컨텍스트 범위 익셉션 발생");
        System.out.println("에러 타입: " + request.getType());
        System.out.println("에러 명: " + request.getExceptionName());
        System.out.println("에러 발생 메세지: " + request.getMessage());
        System.out.println("에러 발생 위치 : " + request.getOriginModule());
        System.out.println("에러 발생 메소드: " + request.getOriginMethod());
        System.out.println();
    }

    @EventListener
    public void listenFilterServletException(FilterServletExceptionInfo info) {
        ExceptionInfoRequest request = ExceptionInfoRequest.from(info);
        System.out.println("필터, 서블릿 범위 익셉션 발생");
        System.err.println("컨텍스트 범위 익셉션 발생");
        System.out.println("에러 타입: " + request.getType());
        System.out.println("에러 명: " + request.getExceptionName());
        System.out.println("에러 발생 메세지: " + request.getMessage());
        System.out.println("에러 발생 위치 : " + request.getOriginModule());
        System.out.println("에러 발생 메소드: " + request.getOriginMethod());
        System.out.println("요청 URI: " + request.getRequestUri());
        System.out.println("상태코드: " + request.getHttpStatus());
        System.out.println();
    }

    @EventListener
    public void listenAsyncException(AsyncExceptionInfo info) {
        ExceptionInfoRequest request = ExceptionInfoRequest.from(info);
        System.out.println("비동기 익셉션 발생");
        System.out.println("필터, 서블릿 범위 익셉션 발생");
        System.err.println("컨텍스트 범위 익셉션 발생");
        System.out.println("에러 타입: " + request.getType());
        System.out.println("에러 명: " + request.getExceptionName());
        System.out.println("에러 발생 메세지: " + request.getMessage());
        System.out.println("에러 발생 위치 : " + request.getOriginModule());
        System.out.println("에러 발생 메소드: " + request.getOriginMethod());
        System.out.println("스레드명: " + request.getThreadName());
        System.out.println();
    }
}
