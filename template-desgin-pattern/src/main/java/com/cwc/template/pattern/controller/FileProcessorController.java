package com.cwc.template.pattern.controller;

import com.cwc.template.pattern.services.FileService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/file/operation")
public class FileProcessorController {

    private final FileService fileService;

    public FileProcessorController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping
    public ResponseEntity<?> processFileOperation(@PathParam("file") MultipartFile file) {
       try{
           if (file.isEmpty()) {
               return ResponseEntity.badRequest().body("File is empty");
           }
          //Now Process file
           this.fileService.processFileOperation(file);
           return ResponseEntity.ok("File processed successfully: " + file.getOriginalFilename());
       } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
       }
    }
}
