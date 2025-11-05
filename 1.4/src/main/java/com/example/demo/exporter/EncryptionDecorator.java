package com.example.demo.exporter;

import java.util.Base64;

public class EncryptionDecorator extends DataExporterDecorator {
    public EncryptionDecorator(DataExporter exporter) {
        super(exporter);
    }

    @Override
    public String export(Object data) {
        String exported = super.export(data);
        return Base64.getEncoder().encodeToString(exported.getBytes());
    }
}
