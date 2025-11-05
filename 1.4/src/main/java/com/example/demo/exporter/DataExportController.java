package com.example.demo.exporter;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/export")
public class DataExportController {

    @PostMapping
    public String exportData(
            @RequestParam String format,
            @RequestParam(required = false) boolean encrypt,
            @RequestParam(required = false) boolean compress,
            @RequestParam(required = false) boolean validate,
            @RequestBody Map<String, Object> data) {

        DataExporter exporter;

        switch (format.toLowerCase()) {
            case "xml": exporter = new XmlDataExporter(); break;
            case "csv": exporter = new CsvDataExporter(); break;
            default: exporter = new JsonDataExporter(); break;
        }

        if (validate) exporter = new ValidationDecorator(exporter);
        if (compress) exporter = new CompressionDecorator(exporter);
        if (encrypt) exporter = new EncryptionDecorator(exporter);

        return exporter.export(data);
    }
}
