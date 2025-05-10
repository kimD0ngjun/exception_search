package org.jun.config;

import org.jun.listener.ExceptionListener;
import org.jun.publish.PublishHandlerExceptionResolver;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableConfigurationProperties(HttpRequestProperties.class)
public class ExceptionSearchAutoConfig implements AsyncConfigurer {

    private final ApplicationContext applicationContext;
    private final HttpRequestProperties requestProperties;

    public ExceptionSearchAutoConfig(
            ApplicationContext applicationContext,
            HttpRequestProperties requestProperties) {
        this.applicationContext = applicationContext;
        this.requestProperties = requestProperties;
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("http://localhost:8080")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    @Bean
    public ExceptionListener exceptionListener() {
        return new ExceptionListener(webClient());
    }

    @Bean
    public PublishHandlerExceptionResolver publishHandlerExceptionResolver() {
        return new PublishHandlerExceptionResolver(applicationContext);
    }
}
