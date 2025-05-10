package org.jun.publish;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jun.dto.ExceptionInfoRequest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class PublishHandlerExceptionResolver implements HandlerExceptionResolver {
    private final ApplicationEventPublisher eventPublisher;

    public PublishHandlerExceptionResolver(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        String exceptionName = ex.getClass().getName();
        String requestUrl = request.getRequestURI();
        String message = ex.getMessage();
        String timeStamp = Instant.now().toString();

        StackTraceElement[] stack = ex.getStackTrace();

        String originClass = "UnknownClass";
        String originMethod = "UnknownMethod";
        String originModule = "UnknownModule";

        if (stack.length > 0) {
            originClass = stack[0].getClassName();
            originMethod = stack[0].getMethodName();
            originModule = getRootPackage(stack[0].getClassName());
        }

        List<String> stackTrace = Arrays.stream(stack)
                .map(StackTraceElement::toString)
                .toList();

        ExceptionInfoRequest eventRequest = new ExceptionInfoRequest.Builder()
                .exceptionName(exceptionName)
                .requestUri(requestUrl)
                .message(message)
                .timestamp(timeStamp)
                .originClass(originClass)
                .originMethod(originMethod)
                .originModule(originModule)
                .stackTrace(stackTrace)
                .build();

        eventPublisher.publishEvent(eventRequest);
        return null; // 다음 리졸버로 넘기기 위한 null 반환
    }

    private String getRootPackage(String className) {
        int lastDotIndex = className.lastIndexOf(".");
        return lastDotIndex > 0 ? className.substring(0, lastDotIndex) : "default";
    }
}
