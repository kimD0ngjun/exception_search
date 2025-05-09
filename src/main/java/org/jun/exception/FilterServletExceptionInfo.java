package org.jun.exception;

public class FilterServletExceptionInfo extends ContextExceptionInfo {

    private final Integer httpStatus;

    public FilterServletExceptionInfo(Throwable ex, String requestUri, Integer httpStatus) {
        super(Type.FILTER_SERVLET_EXCEPTION, ex, requestUri);
        this.httpStatus = httpStatus;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public Integer getHttpStatus() {
        return httpStatus;
    }
}
