package org.jun.dto;

import org.jun.exception.AsyncExceptionInfo;
import org.jun.exception.ContextExceptionInfo;
import org.jun.exception.FilterServletExceptionInfo;

import java.util.List;

public class ExceptionInfoRequest {

    private final String type;
    private final String exceptionName;
    private final String message;
    private final String timestamp;
    private final String originClass;
    private final String originMethod;
    private final String originModule;
    private final List<String> stackTrace;
    private final String threadName;
    private final String requestUri;
    private final Integer httpStatus;

    public ExceptionInfoRequest(
            String type,
            String exceptionName,
            String message,
            String timestamp,
            String originClass,
            String originMethod,
            String originModule,
            List<String> stackTrace,
            String threadName,
            String requestUri,
            Integer httpStatus
    ) {
        this.type = type;
        this.exceptionName = exceptionName;
        this.message = message;
        this.timestamp = timestamp;
        this.originClass = originClass;
        this.originMethod = originMethod;
        this.originModule = originModule;
        this.stackTrace = stackTrace;
        this.threadName = threadName;
        this.requestUri = requestUri;
        this.httpStatus = httpStatus;
    }

    public static ExceptionInfoRequest from(ContextExceptionInfo dto) {
        return new ExceptionInfoRequest(
                dto.getType(),
                dto.getExceptionName(),
                dto.getMessage(),
                dto.getTimestamp(),
                dto.getOriginClass(),
                dto.getOriginMethod(),
                dto.getOriginModule(),
                dto.getStackTrace(),
                null,
                null,
                null
        );
    }

    public static ExceptionInfoRequest from(FilterServletExceptionInfo dto) {
        return new ExceptionInfoRequest(
                dto.getType(),
                dto.getExceptionName(),
                dto.getMessage(),
                dto.getTimestamp(),
                dto.getOriginClass(),
                dto.getOriginMethod(),
                dto.getOriginModule(),
                dto.getStackTrace(),
                null,
                dto.getRequestUri(),
                dto.getHttpStatus()
        );
    }

    public static ExceptionInfoRequest from(AsyncExceptionInfo dto) {
        return new ExceptionInfoRequest(
                dto.getType(),
                dto.getExceptionName(),
                dto.getMessage(),
                dto.getTimestamp(),
                dto.getOriginClass(),
                dto.getOriginMethod(),
                dto.getOriginModule(),
                dto.getStackTrace(),
                dto.getThreadName(),
                null,
                null
        );
    }

    public String getType() {
        return type;
    }

    public String getExceptionName() {
        return exceptionName;
    }

    public String getMessage() {
        return message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getOriginClass() {
        return originClass;
    }

    public String getOriginMethod() {
        return originMethod;
    }

    public String getOriginModule() {
        return originModule;
    }

    public List<String> getStackTrace() {
        return stackTrace;
    }

    public String getThreadName() {
        return threadName;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public Integer getHttpStatus() {
        return httpStatus;
    }
}
