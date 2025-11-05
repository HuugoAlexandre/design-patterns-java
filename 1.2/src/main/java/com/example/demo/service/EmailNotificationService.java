package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService implements NotificationService {

    @Override
    public void sendNotification(String recipient, String subject, String content) {
        System.out.println("📧 Enviando EMAIL para " + recipient);
        System.out.println("Assunto: " + subject);
        System.out.println("Conteúdo: " + content);
    }
}
