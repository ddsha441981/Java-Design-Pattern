package com.cwc.template.pattern.template;

import java.io.File;

public abstract class FileProcessorTemplate {
    //Template Method
    public final void processFile(String path) {
        File file = openFile(path);
        String content = readContent(file);
        processContent(content);
        closeFile(file);
        notifyCompletion(path);
    }

    // Common implementation
    protected File openFile(String path) {
        System.out.println("Opening file: " + path);
        return new File(path);
    }

    // Common implementation
    protected void closeFile(File file) {
        System.out.println("Closing file");
    }

    // Common implementation
    protected void notifyCompletion(String path) {
        System.out.println("Processing completed for: " + path);
    }

    protected abstract String processContent(String content);
    protected abstract String  readContent(File file);
}
