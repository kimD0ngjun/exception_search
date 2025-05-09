package org.jun.publish;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jun.exception.FilterServletExceptionInfo;
import org.jun.wrapper.StatusCaptureResponseWrapper;
import org.springframework.context.ApplicationEventPublisher;

import java.io.IOException;

/**
 * 필터, 서블릿 단계의 예외 포착
 */
public class FilterServletExceptionPublisher implements Filter {

    private final ApplicationEventPublisher publisher;

    public FilterServletExceptionPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain) throws IOException, ServletException {
        StatusCaptureResponseWrapper wrappedResponse =
                new StatusCaptureResponseWrapper((HttpServletResponse) servletResponse);

        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {
            HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
            String requestUri = httpRequest.getRequestURI();

            FilterServletExceptionInfo info =
                    new FilterServletExceptionInfo(e, requestUri, wrappedResponse.getStatusCode());
            publisher.publishEvent(info);
            throw e;
        }
    }
}
