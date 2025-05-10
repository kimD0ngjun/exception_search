package org.jun.request;

public class ExceptionInfoRequest {
    private String exceptionName;
    private String requestUri;
    private String message;
    private String timestamp;
    private String originClass;
    private String originMethod;
    private String originModule;

    public ExceptionInfoRequest(
            String exceptionName, String requestUri, String message, String timestamp,
            String originClass, String originMethod, String originModule) {
        this.exceptionName = exceptionName;
        this.requestUri = requestUri;
        this.message = message;
        this.timestamp = timestamp;
        this.originClass = originClass;
        this.originMethod = originMethod;
        this.originModule = originModule;
    }
}
