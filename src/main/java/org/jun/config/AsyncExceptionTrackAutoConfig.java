package org.jun.config;

import org.jun.publish.AsyncExceptionPublisher;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@Configuration
public class AsyncExceptionTrackAutoConfig implements AsyncConfigurer {

    private final ApplicationContext applicationContext;

    public AsyncExceptionTrackAutoConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public AsyncExceptionPublisher asyncExceptionPublisher() {
        return new AsyncExceptionPublisher(applicationContext);
    }

    @Bean
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return asyncExceptionPublisher();
    }
}
