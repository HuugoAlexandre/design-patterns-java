package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.model.LogEntry;
import com.example.demo.service.LogService;

public class LogServiceTest {

    private LogService logService;

    @BeforeEach
    void setUp() {
        logService = new LogService();
    }

    @Test
    void deveRegistrarLogsCorretamente() {
        logService.info("Teste info");
        logService.warn("Teste warn");
        logService.error("Teste error");

        List<LogEntry> logs = logService.getRecentLogs();
        assertEquals(3, logs.size());
        assertEquals("INFO", logs.get(0).getLevel());
    }

    @Test
    void deveLimitarA100Logs() {
        for (int i = 0; i < 120; i++) {
            logService.info("Log " + i);
        }
        assertEquals(100, logService.getRecentLogs().size());
    }
}
