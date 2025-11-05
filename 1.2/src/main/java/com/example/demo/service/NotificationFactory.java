package com.example.demo.service;

import org.springframework.stereotype.Component;

@Component
public class NotificationFactory {

    private final EmailNotificationService emailService;
    private final SmsNotificationService smsService;
    private final PushNotificationService pushService;

    public NotificationFactory(EmailNotificationService emailService,
                               SmsNotificationService smsService,
                               PushNotificationService pushService) {
        this.emailService = emailService;
        this.smsService = smsService;
        this.pushService = pushService;
    }

    public NotificationService getNotificationService(String type) {
        switch (type.toLowerCase()) {
            case "email":
                return emailService;
            case "sms":
                return smsService;
            case "push":
                return pushService;
            default:
                throw new IllegalArgumentException("Tipo de notificação desconhecido: " + type);
        }
    }
}
