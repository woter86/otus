package ru.balovin.spring.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.balovin.spring.domain.Question;
import ru.balovin.spring.domain.Student;

import java.util.List;

@Service
public class StudentExaminator implements Examinator {
    private final QuestionService questionService;

    private final int threshold;

    private final Asker asker;

    private final GreetingService greetingService;

    private final IOService ioService;

    public StudentExaminator(QuestionService questionService, @Value("${examinator.threshold:3}") int threshold, Asker asker, GreetingService greetingService, IOService ioService) {
        this.questionService = questionService;
        this.threshold = threshold;
        this.asker = asker;
        this.greetingService = greetingService;
        this.ioService = ioService;
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
            ioService.out("Sorry, but you did not pass exam, dear " + student.getSurname());
            ioService.out("Your ball is " + validAnswer + ", but threshold is " + threshold);
        } else {
            ioService.out("Yahoo, you pass exam, dear " + student.getName());
        }
    }
}
