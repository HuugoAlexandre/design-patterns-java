package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.NotificationRequest;
import com.example.demo.service.NotificationFactory;
import com.example.demo.service.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationFactory factory;

    public NotificationController(NotificationFactory factory) {
        this.factory = factory;
    }

    @PostMapping
    public String sendNotification(@RequestBody NotificationRequest request) {
        NotificationService service = factory.getNotificationService(request.getType());
        service.sendNotification(request.getRecipient(), request.getSubject(), request.getContent());
        return "Notificação enviada com sucesso via " + request.getType().toUpperCase() + "!";
    }
}
