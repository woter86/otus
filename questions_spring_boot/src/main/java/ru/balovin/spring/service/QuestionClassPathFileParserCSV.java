package ru.balovin.spring.service;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.balovin.spring.dao.FileNameProvider;
import ru.balovin.spring.domain.Question;

import java.util.List;

@Service
public class QuestionClassPathFileParserCSV implements QuestionParser {

    private final String csvFileName;
    private final ResourceService resourceService;

    public QuestionClassPathFileParserCSV(FileNameProvider provider, ResourceService resourceService) {
        this.csvFileName = provider.getLocalFileName();
        this.resourceService = resourceService;
    }

    @Override
    public List<Question> getAll() {
        try {
            MappingIterator<Question> questionIter = new CsvMapper().readerWithTypedSchemaFor(Question.class).readValues(resourceService.getResourceAsStream(csvFileName));
            return questionIter.readAll();
        } catch (Exception e) {
            return null;
        }
    }
}
