package ru.balovin.spring.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.balovin.spring.domain.Question;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Класс QuestionDaoSimpleTest")
class QuestionDaoSimpleTest {

    @DisplayName(" не задан файл csv")
    @Test
    void notSetInputFileGetAll() {
        Assertions.assertEquals(null, new QuestionDaoSimple().getAll());
    }

    @DisplayName(" хороший csv файл")
    @Test
    void validCSV() {
        QuestionDaoSimple questionDaoSimple = new QuestionDaoSimple();
        questionDaoSimple.setCsvFileName("questions.csv");
        Assertions.assertTrue(questionDaoSimple.getAll().size() > 0);
    }
}