package ru.balovin.spring.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.balovin.spring.domain.Question;

import java.util.List;

import static org.mockito.BDDMockito.given;

@DisplayName("Класс AskerSimpleTest")
@ExtendWith(MockitoExtension.class)
public class AskerSimpleTest {
    @Mock
    private IOService ioService;

    private Asker askerSimple;

    @BeforeEach
    void setUp() {
        askerSimple = new AskerSimple(ioService);
    }

    @DisplayName(" дан правильный ответ")
    @Test
    void testValidAnswer() {
        Question question = new Question("Who am i?", List.of("student"), 0);
        given(ioService.readString()).willReturn("student");
        Assertions.assertEquals(1, askerSimple.askQuestion(question));
    }

    @DisplayName(" дан НЕ правильный ответ")
    @Test
    void testNotValidAnswer() {
        Question question = new Question("Who am i?", List.of("student"), 0);
        given(ioService.readString()).willReturn("teacher");
        Assertions.assertEquals(0, askerSimple.askQuestion(question));
    }

    @DisplayName(" вопрос с произвольным ответом")
    @Test
    void testSomeAnswer() {
        Question question = new Question("Who am i?", List.of(), -1);
        given(ioService.readString()).willReturn("botan");
        Assertions.assertEquals(1, askerSimple.askQuestion(question));
    }
}
