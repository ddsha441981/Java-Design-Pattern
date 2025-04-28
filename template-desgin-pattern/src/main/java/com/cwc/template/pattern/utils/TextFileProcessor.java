package com.cwc.template.pattern.utils;

import com.cwc.template.pattern.template.FileProcessorTemplate;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class TextFileProcessor extends FileProcessorTemplate {
    @Override
    protected void processContent(String content) {
        System.out.println("Processing Text File Content...");
        System.out.println("Content Preview:");
        System.out.println(content.substring(0, Math.min(content.length(), 500)));
    }

    @Override
    protected String readContent(File file) {
        try {
            String content  = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
            return content;
        } catch (IOException e) {
            throw new RuntimeException("Failed to read text file: " + file.getAbsolutePath(), e);
        }
    }
}
