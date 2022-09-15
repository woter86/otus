package ru.balovin.spring.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.balovin.spring.domain.Question;
import ru.balovin.spring.service.GreetingServiceImpl;
import ru.balovin.spring.service.QuestionParser;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@DisplayName("Класс QuestionDaoSimpleTest")
@ExtendWith(MockitoExtension.class)
class QuestionDaoSimpleTest {
    @Mock
    private QuestionParser questionParser;
    private QuestionDao questionDao;

    @BeforeEach
    void setUp() {
        questionDao = new QuestionDaoSimple(questionParser);
    }

    @DisplayName(" не задан файл csv")
    @Test
    void notSetInputFileGetAll() {
        given(questionParser.getAll()).willReturn(null);
        Assertions.assertEquals(null, questionDao.getAll());
    }

    @DisplayName(" хороший csv файл")
    @Test
    void validCSV() {
    }
}