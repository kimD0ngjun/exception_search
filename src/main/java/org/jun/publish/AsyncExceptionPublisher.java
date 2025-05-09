package org.jun.publish;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.ApplicationEventPublisher;

import java.lang.reflect.Method;

/**
 * 비동기 멀티스레드 예외 포착
 */
public class AsyncExceptionPublisher implements AsyncUncaughtExceptionHandler {

    private final ApplicationEventPublisher publisher;

    public AsyncExceptionPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... params) {
        publisher.publishEvent(ex);
    }
}
