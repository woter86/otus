package ru.balovin.spring.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.balovin.spring.domain.Question;
import ru.balovin.spring.domain.Student;

import java.util.List;
import java.util.Locale;

@Service
public class LocalStudentExaminator implements Examinator {
    private final QuestionService questionService;

    private final int threshold;

    private final Asker asker;

    private final GreetingService greetingService;

    private final IOService ioService;
    private final MessageSource messageSource;
private final Locale locale;

    public LocalStudentExaminator(QuestionService questionService, @Value("${examinator.threshold:3}") int threshold, Asker asker, GreetingService greetingService, IOService ioService, MessageSource messageSource, @Value("${application.locale}") Locale locale) {
        this.questionService = questionService;
        this.threshold = threshold;
        this.asker = asker;
        this.greetingService = greetingService;
        this.ioService = ioService;
        this.messageSource = messageSource;
        this.locale = locale;
    }

    @Override
    public void run() {
        Student student = greetingService.hello();

        int validAnswer = 0;
        List<Question> questionList = questionService.getAll();
        for(Question question: questionList) {
            validAnswer += asker.askQuestion(question);
        }

        if (validAnswer < threshold) {
            ioService.out( messageSource.getMessage("result.bad", new String[]{student.getSurname()}, locale));
            ioService.out(messageSource.getMessage("result.ball", new String[]{String.valueOf(validAnswer), String.valueOf(threshold)}, locale));
        } else {
            ioService.out( messageSource.getMessage("result.good", new String[]{student.getName()}, locale));
        }
    }
}
