package com.Chart.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    // 1. Configure the broker (where messages are routed)
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // simple in-memory broker for topics
        registry.enableSimpleBroker("/topic");
        // prefix for messages bound for @MessageMapping
        registry.setApplicationDestinationPrefixes("/app");
    }

    // 2. Register the STOMP/WebSocket endpoint that clients will hit
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat")
                .setAllowedOrigins("http://localhost:8080")
                .withSockJS();
    }
}
