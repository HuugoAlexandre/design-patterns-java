package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LogEntry;
import com.example.demo.service.LogService;

@RestController
public class LogController {

    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    // 1. Endpoint para consultar os logs mais recentes
    @GetMapping("/logs")
    public List<LogEntry> getLogs() {
        return logService.getRecentLogs();
    }

    // 2. Endpoint para registrar log INFO
    @PostMapping("/logs/info")
    public String logInfo(@RequestParam String message) {
        logService.info(message);
        return "Log INFO registrado: " + message;
    }

    // 3. Endpoint para registrar log WARN
    @PostMapping("/logs/warn")
    public String logWarn(@RequestParam String message) {
        logService.warn(message);
        return "Log WARN registrado: " + message;
    }

    // 4. Endpoint para registrar log ERROR
    @PostMapping("/logs/error")
    public String logError(@RequestParam String message) {
        logService.error(message);
        return "Log ERROR registrado: " + message;
    }
}
