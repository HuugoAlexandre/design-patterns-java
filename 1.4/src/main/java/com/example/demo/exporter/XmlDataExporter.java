package com.example.demo.exporter;

public class XmlDataExporter implements DataExporter {
    @Override
    public String export(Object data) {
        return "<xml><data>" + data.toString() + "</data></xml>";
    }
}
