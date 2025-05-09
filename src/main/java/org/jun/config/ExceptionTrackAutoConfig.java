package org.jun.config;

import org.jun.listener.ExceptionListener;
import org.jun.publish.FilterServletExceptionPublisher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;

import java.net.http.HttpClient;

@Configuration
public class ExceptionTrackAutoConfig implements AsyncConfigurer {

    private final ApplicationContext applicationContext;

    public ExceptionTrackAutoConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public HttpClient httpClient() {
        return HttpClient.newHttpClient();
    }

    @Bean
    public CustomExceptionSearcher customExceptionSearcher() {
        return new CustomExceptionSearcher();
    }

    @Bean
    public ExceptionListener exceptionListener() {
        return new ExceptionListener(httpClient());
    }

    @Bean
    public FilterServletExceptionPublisher filterServletExceptionInfo() {
        return new FilterServletExceptionPublisher(applicationContext);
    }
}
