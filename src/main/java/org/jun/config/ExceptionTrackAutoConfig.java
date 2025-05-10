package org.jun.config;

import org.jun.listener.ExceptionListener;
import org.jun.publish.FilterServletExceptionPublisher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ExceptionTrackAutoConfig implements AsyncConfigurer {

    private final ApplicationContext applicationContext;

    public ExceptionTrackAutoConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("http://localhost:8080")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    @Bean
    public CustomExceptionSearcher customExceptionSearcher() {
        return new CustomExceptionSearcher();
    }

    @Bean
    public ExceptionListener exceptionListener() {
        return new ExceptionListener(webClient());
    }

    @Bean
    public FilterServletExceptionPublisher filterServletExceptionInfo() {
        return new FilterServletExceptionPublisher(applicationContext);
    }
}
