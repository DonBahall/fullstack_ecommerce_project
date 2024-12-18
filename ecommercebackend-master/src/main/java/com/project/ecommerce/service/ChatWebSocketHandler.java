package com.project.ecommerce.service;

import com.project.ecommerce.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class ChatWebSocketHandler extends TextWebSocketHandler {
    @Autowired
    private TaskService taskService;
    public ChatWebSocketHandler(TaskService taskService) {
        this.taskService = taskService;
    }

    private final Set<WebSocketSession> sessions = Collections.synchronizedSet(new HashSet<>());
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        sessions.add(session); // Add session to active connections
        System.out.println("New connection: " + session.getId());
        scheduler.scheduleAtFixedRate(this::sendDeadlineNotification, 0, 10, TimeUnit.SECONDS);
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
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        sessions.remove(session); // Remove session on disconnect
        System.out.println("Connection closed: " + session.getId());
    }

    public void sendDeadlineNotification() {
        String message = generateTaskContent();

        synchronized (sessions) {
            System.out.println("Active sessions before send: " + sessions.size());

            for (WebSocketSession session : sessions) {
                if (session.isOpen()) {
                    try {
                        if(!taskService.getTasks().isEmpty()){
                            session.sendMessage(new TextMessage(message));
                            System.out.println("Message sent to session: " + session.getId());
                        }
                    } catch (Exception e) {
                        System.err.println("Error sending message: " + e.getMessage());
                    }
                }
            }
        }
    }

    private String generateTaskContent() {
        List<Task> tasks = taskService.getTasks();
        if (tasks == null || tasks.isEmpty()) {
            return null;
        }

        Date now = new Date();
        Optional<Task> nearestTask = tasks.stream()
                .filter(task -> !task.getCompleted() && task.getDeadline().after(now))
                .min(Comparator.comparing(Task::getDeadline));

        if (nearestTask.isPresent()) {
            Task task = nearestTask.get();
            return "Deadline on nearest task: Task: " + task.getTitle() + ", Deadline: " + formatDate(task.getDeadline());
        } else {
            return null;
        }
    }

    private String formatDate(Date date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        return localDateTime.format(formatter);
    }
}
