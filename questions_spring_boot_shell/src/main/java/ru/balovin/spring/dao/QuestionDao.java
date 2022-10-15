package ru.balovin.spring.dao;

import ru.balovin.spring.domain.Question;

import java.util.List;

public interface QuestionDao {

    List<Question> getAll();
}
