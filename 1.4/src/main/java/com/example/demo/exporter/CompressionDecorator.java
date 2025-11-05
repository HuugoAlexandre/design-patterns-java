package com.example.demo.exporter;

public class CompressionDecorator extends DataExporterDecorator {
    public CompressionDecorator(DataExporter exporter) {
        super(exporter);
    }

    @Override
    public String export(Object data) {
        String exported = super.export(data);
        return "[COMPRESSED]" + exported + "[/COMPRESSED]";
    }
}
