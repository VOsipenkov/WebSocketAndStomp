package com.example.mysocket.service;

import com.example.mysocket.dto.AbstractMessage;
import com.example.mysocket.dto.Customer;
import com.example.mysocket.dto.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Slf4j
@Component
@RequiredArgsConstructor
public class WsHandler extends TextWebSocketHandler {
    private static int responseCounter = 0;
    private final ObjectMapper objectMapper;
    private final UserService userService;
    private final CustomerService customerService;

    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        AbstractMessage data = null;
        try {
            data = objectMapper.readValue(message.getPayload(), AbstractMessage.class);
        } catch (Exception e) {
            log.error("Can't parse input message {}", message);
            session.sendMessage(new TextMessage("Exception {}" + e.getMessage()));
        }
        log.info("Received socket message {}", message);

        if (data instanceof User) {
            userService.process((User) data);
        } else if (data instanceof Customer) {
            customerService.process((Customer) data);
        }

        session.sendMessage(new TextMessage("Response ok number " + ++responseCounter));
    }

}
