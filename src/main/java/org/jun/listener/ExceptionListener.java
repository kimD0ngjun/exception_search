package org.jun.listener;

import org.springframework.context.event.EventListener;
import org.springframework.web.reactive.function.client.WebClient;

public class ExceptionListener {

    private final WebClient webClient;

    public ExceptionListener(WebClient webClient) {
        this.webClient = webClient;
    }

    @EventListener
    public void listenException() {}
}
