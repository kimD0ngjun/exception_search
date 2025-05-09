package org.jun.exception;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class ContextExceptionInfo {

    protected String type;
    protected String exceptionName;
    protected String requestUri;
    protected String message;
    protected String timestamp;
    protected String originClass;
    protected String originMethod;
    protected String originModule;
    protected List<String> stackTrace;

    public ContextExceptionInfo(String type, Throwable ex, String requestUri) {
        this.type = type;
        this.exceptionName = ex.getClass().getName();
        this.requestUri = requestUri;
        this.message = ex.getMessage();
        this.timestamp = Instant.now().toString();

        StackTraceElement[] stack = ex.getStackTrace();
        if (stack.length > 0) {
            this.originClass = stack[0].getClassName();
            this.originMethod = stack[0].getMethodName();
            this.originModule = getRootPackage(stack[0].getClassName());
        } else {
            this.originClass = "UnknownClass";
            this.originMethod = "UnknownMethod";
            this.originModule = "UnknownModule";
        }

        this.stackTrace = Arrays.stream(stack)
                .map(StackTraceElement::toString)
                .toList();
    }

    private String getRootPackage(String className) {
        int lastDotIndex = className.lastIndexOf(".");
        return lastDotIndex > 0 ? className.substring(0, lastDotIndex) : "default";
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
}
