package ru.balovin.spring.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LocalFileNameProvider implements FileNameProvider {
    private final String localFileName;

    public LocalFileNameProvider(@Value("${parser.filename:questions_ru_RU.csv}") String fileName,
                                 @Value("${application.locale:en}") String locale) {
        this.localFileName = fileName.replace(".", "_" + locale + ".");
    }

    @Override
    public String getLocalFileName() {
        return localFileName;
    }
}
