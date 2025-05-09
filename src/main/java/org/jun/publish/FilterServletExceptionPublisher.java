package org.jun.publish;

import jakarta.servlet.*;
import org.springframework.context.ApplicationEventPublisher;

import java.io.IOException;

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
