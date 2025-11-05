package com.example.demo.exporter;

public class ValidationDecorator extends DataExporterDecorator {
    public ValidationDecorator(DataExporter exporter) {
        super(exporter);
    }

    @Override
    public String export(Object data) {
        if (data == null || data.toString().isEmpty()) {
            throw new IllegalArgumentException("Dados inválidos para exportação");
        }
        return super.export(data);
    }
}
