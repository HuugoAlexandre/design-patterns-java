package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class SmsNotificationService implements NotificationService {

    @Override
    public void sendNotification(String recipient, String subject, String content) {
        System.out.println("📱 Enviando SMS para " + recipient);
        System.out.println("Mensagem: " + content);
    }
}
