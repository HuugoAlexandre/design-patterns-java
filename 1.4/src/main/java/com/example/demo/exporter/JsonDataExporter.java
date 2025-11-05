package com.example.demo.exporter;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDataExporter implements DataExporter {
    @Override
    public String export(Object data) {
        try {
            return new ObjectMapper().writeValueAsString(data);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao exportar JSON", e);
        }
    }
}
