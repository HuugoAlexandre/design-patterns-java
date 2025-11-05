package com.example.demo.exporter;

public abstract class DataExporterDecorator implements DataExporter {
    protected final DataExporter wrappedExporter;

    protected DataExporterDecorator(DataExporter exporter) {
        this.wrappedExporter = exporter;
    }

    @Override
    public String export(Object data) {
        return wrappedExporter.export(data);
    }
}
