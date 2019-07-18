package com.collabera.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketChatConfig  extends AbstractWebSocketMessageBrokerConfigurer {
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry reg) {
		//reg.addEndpoint("/websocketApp").withSockJS();
		reg.addEndpoint("/chat").setAllowedOrigins("*").withSockJS();
	}
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry reg) {
		reg.setApplicationDestinationPrefixes("http://localhost:8090/app");
		//reg.enableStompBrokerRelay("/topic").setRelayHost("localhost").setRelayPort(61613).setClientLogin("guest").setClientPasscode("guest");
		
		//reg.enableStompBrokerRelay("/channel").setRelayHost("localhost").setRelayPort(61613).setClientLogin("guest").setClientPasscode("guest");
		
		reg.enableSimpleBroker("/channel");
	}

}
