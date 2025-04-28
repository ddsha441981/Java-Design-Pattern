package com.cwc.template.pattern.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface FileService {
    void processFileOperation(MultipartFile file);
}
