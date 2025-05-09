package org.jun.listener;

import org.jun.dto.ExceptionInfoRequest;
import org.jun.exception.AsyncExceptionInfo;
import org.jun.exception.ContextExceptionInfo;
import org.jun.exception.FilterServletExceptionInfo;
import org.springframework.context.event.EventListener;

import java.net.http.HttpClient;

public class ExceptionListener {

    private final HttpClient httpClient;

    public ExceptionListener(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @EventListener
    public void listenContextException(ContextExceptionInfo info) {
        ExceptionInfoRequest request = ExceptionInfoRequest.from(info);
        System.out.println("컨텍스트 범위 익셉션 발생");
    }

    @EventListener
    public void listenFilterServletException(FilterServletExceptionInfo info) {
        ExceptionInfoRequest request = ExceptionInfoRequest.from(info);
        System.out.println("필터, 서블릿 범위 익셉션 발생");
    }

    @EventListener
    public void listenAsyncException(AsyncExceptionInfo info) {
        ExceptionInfoRequest request = ExceptionInfoRequest.from(info);
        System.out.println("비동기 익셉션 발생");
    }
}
