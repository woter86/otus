package ru.balovin.spring.service;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.balovin.spring.Main;
import ru.balovin.spring.domain.Question;

import java.util.List;

@Component
public class QuestionClassPathFileParserCSV implements QuestionParser{
    private final String csvFileName;

    public QuestionClassPathFileParserCSV(@Value("${csvFilename:questions.csv}") String csvFileName) {
        this.csvFileName = csvFileName;
    }

    @Override
    public List<Question> getAll() {
        try {
            MappingIterator<Question> questionIter = new CsvMapper().readerWithTypedSchemaFor(Question.class).readValues(Main.class.getClassLoader().getResourceAsStream(csvFileName));
            return questionIter.readAll();
        } catch (Exception e) {
            return null;
        }
    }
}
