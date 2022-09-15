package ru.balovin.spring.service;

import org.springframework.stereotype.Service;
import ru.balovin.spring.domain.Question;

import java.util.List;

@Service
public class AskerSimple implements Asker{
    private final IOService ioService;

    public AskerSimple(IOService ioService) {
        this.ioService = ioService;
    }

    @Override
    public int askQuestion(Question question) {
        ioService.out(question.getText());
        List<String> answerVariants = question.getAns();
        if (!answerVariants.isEmpty()) {
            ioService.out("Variants:");
            answerVariants.forEach(ioService::out);
        }

        String answer = ioService.readString();
        if (question.getCorrect() == -1 || answerVariants.indexOf(answer) == question.getCorrect()) {
            return 1;
        }

        return 0;
    }
}
