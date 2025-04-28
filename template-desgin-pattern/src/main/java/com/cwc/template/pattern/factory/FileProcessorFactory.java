package com.cwc.template.pattern.factory;

import com.cwc.template.pattern.template.FileProcessorTemplate;
import com.cwc.template.pattern.utils.*;

import java.io.File;

public class FileProcessorFactory {
    public static FileProcessorTemplate getFileProcessorTemplate(File file) {
        String fileName = file.getName();
        if (fileName.endsWith(".txt")) {
            return new TextFileProcessor();
        } else if (fileName.endsWith(".csv")) {
            return new CSVFileProcessor();
        } else if (fileName.endsWith(".xls") || fileName.endsWith(".xlsx")) {
            return new ExcelFileProcessor();
        } else if (fileName.endsWith(".json")) {
            return new JsonFileProcessor();
        } else if (fileName.endsWith(".xml")) {
            return new XMLFileProcessor();
        } else if (fileName.endsWith(".pdf")) {
            return new PdfFileProcessor();
        }
        throw new IllegalArgumentException("Unsupported file type: " + fileName);
    }
}
