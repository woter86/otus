package ru.balovin.spring.service;

import ru.balovin.spring.dao.QuestionDao;
import ru.balovin.spring.domain.Question;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao dao;

    public QuestionServiceImpl(QuestionDao dao) {
        this.dao = dao;
    }

    public List<Question> getAll() {
        return dao.getAll();
    }
}
