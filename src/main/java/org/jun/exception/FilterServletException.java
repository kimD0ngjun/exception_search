package org.jun.exception;

public class FilterServletException extends ContextException {

    private final String requestUri;
    private final Integer httpStatus;

    public FilterServletException(Throwable ex, String requestUri, Integer httpStatus) {
        super(Type.FILTER_SERVLET_EXCEPTION, ex);
        this.requestUri = requestUri;
        this.httpStatus = httpStatus;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public Integer getHttpStatus() {
        return httpStatus;
    }
}
