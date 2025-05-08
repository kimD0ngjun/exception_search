package org.jun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExceptionSearcherAutoConfiguration {
    @Bean
    public CustomExceptionSearcher customExceptionSearcher() {
        return new CustomExceptionSearcher();
    }
}
