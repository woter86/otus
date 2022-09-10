package ru.balovin.spring.dao;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import ru.balovin.spring.Main;
import ru.balovin.spring.domain.Question;

import java.util.List;

public class QuestionDaoSimple implements QuestionDao {
    private String csvFileName;

    public List<Question> getAll() {
        try {
            MappingIterator<Question> questionIter = new CsvMapper().readerWithTypedSchemaFor(Question.class).readValues(Main.class.getClassLoader().getResourceAsStream(csvFileName));
            return questionIter.readAll();
        } catch (Exception e) {
            return null;
        }
    }

    public void setCsvFileName(String csvFileName) {
        this.csvFileName = csvFileName;
    }

    public String getCsvFileName() {
        return csvFileName;
    }
}
