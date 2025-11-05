package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class PushNotificationService implements NotificationService {

    @Override
    public void sendNotification(String recipient, String subject, String content) {
        System.out.println("🔔 Enviando PUSH notification para " + recipient);
        System.out.println("Título: " + subject);
        System.out.println("Mensagem: " + content);
    }
}
