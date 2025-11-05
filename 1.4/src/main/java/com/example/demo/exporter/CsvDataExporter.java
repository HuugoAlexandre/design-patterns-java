package com.example.demo.exporter;

public class CsvDataExporter implements DataExporter {
    @Override
    public String export(Object data) {
        return "dados," + data.toString();
    }
}
