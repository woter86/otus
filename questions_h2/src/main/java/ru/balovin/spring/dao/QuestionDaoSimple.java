package ru.balovin.spring.dao;

import org.springframework.stereotype.Component;
import ru.balovin.spring.domain.Question;
import ru.balovin.spring.service.QuestionParser;

import java.util.List;

@Component
public class QuestionDaoSimple implements QuestionDao {

    private final QuestionParser questionParser;

    public QuestionDaoSimple(QuestionParser questionParser) {
        this.questionParser = questionParser;
    }

    public List<Question> getAll() {
        return questionParser.getAll();
    }
}
