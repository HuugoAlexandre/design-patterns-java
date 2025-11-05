package com.example.demo.service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.LogEntry;

@Service // 🔹 Singleton gerenciado pelo Spring
public class LogService {

    private static final int MAX_LOGS = 100;
    private final LinkedList<LogEntry> logs = new LinkedList<>();

    private void addLog(String level, String message) {
        if (logs.size() >= MAX_LOGS) {
            logs.removeFirst(); // remove o log mais antigo
        }
        logs.add(new LogEntry(level, message));
    }

    public void info(String message) {
        addLog("INFO", message);
    }

    public void warn(String message) {
        addLog("WARN", message);
    }

    public void error(String message) {
        addLog("ERROR", message);
    }

    public List<LogEntry> getRecentLogs() {
        return Collections.unmodifiableList(logs);
    }
}
