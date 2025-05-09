package org.jun.publish;

import jakarta.servlet.*;
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
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {
            publisher.publishEvent(e);
            throw e;
        }
    }
}
