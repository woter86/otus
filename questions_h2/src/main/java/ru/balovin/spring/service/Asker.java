package ru.balovin.spring.service;

import ru.balovin.spring.domain.Question;

public interface Asker {
    int askQuestion(Question question);
}
