package com.cwc.template.pattern.services.impl;

import com.cwc.template.pattern.factory.FileProcessorFactory;
import com.cwc.template.pattern.services.FileService;
import com.cwc.template.pattern.template.FileProcessorTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileServiceImpl implements FileService {

    FileProcessorTemplate fileProcessorTemplate;

    @Override
    public void processFileOperation(MultipartFile multipartFile) {

        //Convert MultipartFile into file to process
        File file = convertToFile(multipartFile);
        //Factory
        fileProcessorTemplate = FileProcessorFactory.getFileProcessorTemplate(file);
        fileProcessorTemplate.processFile(file);
    }

    protected File convertToFile(MultipartFile multipartFile) {
        try {
            File convFile = File.createTempFile("upload", multipartFile.getOriginalFilename());
            multipartFile.transferTo(convFile);
            return convFile;
        } catch (IOException e) {
            throw new RuntimeException("Failed to convert MultipartFile to File", e);
        }
    }
}
