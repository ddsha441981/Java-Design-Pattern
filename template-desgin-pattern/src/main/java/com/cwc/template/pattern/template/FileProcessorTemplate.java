package com.cwc.template.pattern.template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class FileProcessorTemplate {

    private static final Logger logger = LoggerFactory.getLogger(FileProcessorTemplate.class);
    //Template Method
    public final void processFile(File file) {
        File files = openFile(file);
        String content = readContent(files);
        processContent(content);
        closeFile(file);
        notifyCompletion(files);
    }

    // Common implementation
    private File openFile(File file) {
        if (file == null || !file.exists()) {
            logger.error("File not found: {}", (file != null ? file.getAbsolutePath() : "null"));
            throw new RuntimeException("File not found.");
        }
        if (!file.canRead()) {
            logger.error("Cannot read file: {}", file.getAbsolutePath());
            throw new RuntimeException("Cannot read file: " + file.getAbsolutePath());
        }
        logger.info("Opening file: {}", file.getAbsolutePath());
        return file;
    }

    // Common implementation
    protected void closeFile(File file) {
        if (file != null && file.exists()) {
            logger.info("Closing file: {}", file.getAbsolutePath());
        }
    }

    // Common implementation
    protected void notifyCompletion(File file) {
        if (file != null && file.exists()) {
            long fileSizeInBytes = file.length();
            long fileSizeInKB = fileSizeInBytes / 1024;
            long fileSizeInMB = fileSizeInKB / 1024;

            Date lastModifiedDate = new Date(file.lastModified());
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

            logger.info("============================================");
            logger.info("✅ File Processing Completed Successfully!");
            logger.info("📄 File Path: {}", file.getAbsolutePath());
            logger.info("📦 File Size: {} bytes ({} KB, {} MB)", fileSizeInBytes, fileSizeInKB, fileSizeInMB);
            logger.info("🕒 Last Modified: {}", formatter.format(lastModifiedDate));
            logger.info("=============================================");
        } else {
            logger.warn("⚠️ File processing completed, but file does not exist or was null.");
        }
    }

    protected abstract void processContent(String content);
    protected abstract String  readContent(File file);
}
