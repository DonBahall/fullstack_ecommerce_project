package com.project.ecommerce.service;

import com.project.ecommerce.entity.Task;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class ChatWebSocketHandler extends TextWebSocketHandler {

    private final Set<WebSocketSession> sessions = Collections.synchronizedSet(new HashSet<>());
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session); // Add session to active connections
        System.out.println("New connection: " + session.getId());
        scheduler.scheduleAtFixedRate(() -> sendDeadlineNotification(), 0, 1, TimeUnit.MINUTES);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload(); // Message received from client
        System.out.println("Message received: " + payload);

        // Broadcast the message to all connected clients
        for (WebSocketSession s : sessions) {
            if (s.isOpen()) {
                s.sendMessage(new TextMessage(payload));
            }
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session); // Remove session on disconnect
        System.out.println("Connection closed: " + session.getId());
    }

    public void sendDeadlineNotification() {
        String message = "Deadline on nearest task: " + generateTaskContent();
        System.out.println("Sending message: " + message);

        synchronized (sessions) {
            System.out.println("Active sessions before send: " + sessions.size());

            for (WebSocketSession session : sessions) {
                if (session.isOpen()) {
                    try {
                        session.sendMessage(new TextMessage(message));
                        System.out.println("Message sent to session: " + session.getId());
                    } catch (Exception e) {
                        System.err.println("Error sending message: " + e.getMessage());
                    }
                }
            }
        }
    }
    @Getter
    List<com.project.ecommerce.entity.Task> tasks = new ArrayList<>() {{
        add(new com.project.ecommerce.entity.Task(1L, "Learn Vue.js",true, new Date()));
        add(new Task(2L, "Build a TODO App", false, new Date()));
    }};
    private String generateTaskContent() {
        Date now = tasks.get(0).getDeadline();
        return now.toString();
    }
}
