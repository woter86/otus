package ru.balovin.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.balovin.spring.domain.Question;
import ru.balovin.spring.service.QuestionService;

import java.util.List;
@ComponentScan
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        QuestionService service = context.getBean(QuestionService.class);
        List<Question> ql = service.getAll();
        ql.forEach(q -> System.out.println("Question: " + q.getText() + "\nAnswers: " + q.getAns()));

        // Данная операция, в принципе не нужна.
        // Мы не работаем пока что с БД, а Spring Boot сделает закрытие за нас
        // Подробности - через пару занятий
        context.close();
    }
}
