package ru.balovin.spring.service;

import ru.balovin.spring.domain.Question;

import java.util.List;

public interface QuestionService {

    List<Question> getAll();
}
