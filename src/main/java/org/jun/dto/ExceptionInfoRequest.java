package org.jun.dto;

import java.util.List;

public class ExceptionInfoRequest {

    private final String exceptionName;
    private final String requestUri;
    private final String message;
    private final String timestamp;
    private final String originClass;
    private final String originMethod;
    private final String originModule;
    private final List<String> stackTrace;

    private ExceptionInfoRequest(Builder builder) {
        this.exceptionName = builder.exceptionName;
        this.requestUri = builder.requestUri;
        this.message = builder.message;
        this.timestamp = builder.timestamp;
        this.originClass = builder.originClass;
        this.originMethod = builder.originMethod;
        this.originModule = builder.originModule;
        this.stackTrace = builder.stackTrace;
    }

    public static class Builder {
        private String exceptionName;
        private String requestUri;
        private String message;
        private String timestamp;
        private String originClass;
        private String originMethod;
        private String originModule;
        private List<String> stackTrace;

        public Builder exceptionName(String exceptionName) {
            this.exceptionName = exceptionName;
            return this;
        }

        public Builder requestUri(String requestUri) {
            this.requestUri = requestUri;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder timestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder originClass(String originClass) {
            this.originClass = originClass;
            return this;
        }

        public Builder originMethod(String originMethod) {
            this.originMethod = originMethod;
            return this;
        }

        public Builder originModule(String originModule) {
            this.originModule = originModule;
            return this;
        }

        public Builder stackTrace(List<String> stackTrace) {
            this.stackTrace = stackTrace;
            return this;
        }

        public ExceptionInfoRequest build() {
            return new ExceptionInfoRequest(this);
        }
    }

    public String getExceptionName() {
        return exceptionName;
    }

    public String getRequestUri() {
        return requestUri;
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
