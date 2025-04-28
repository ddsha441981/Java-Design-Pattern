package com.cwc.template.pattern.utils;

import com.cwc.template.pattern.template.FileProcessorTemplate;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class ExcelFileProcessor extends FileProcessorTemplate {
    //TODO: EXCEL Implementations
    @Override
    protected void processContent(String content) {

    }

    @Override
    protected String readContent(File file) {
        return "";
    }
}
