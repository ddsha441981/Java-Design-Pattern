package com.cwc.template.pattern.utils;

import com.cwc.template.pattern.template.FileProcessorTemplate;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class XMLFileProcessor extends FileProcessorTemplate {
    @Override
    protected String processContent(String content) {
        return "";
    }

    @Override
    protected String readContent(File file) {
        return "";
    }
}
