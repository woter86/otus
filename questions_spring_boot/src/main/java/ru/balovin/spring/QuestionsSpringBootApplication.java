package ru.balovin.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.balovin.spring.service.LocalStudentExaminator;

@SpringBootApplication
public class QuestionsSpringBootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(QuestionsSpringBootApplication.class, args);
        LocalStudentExaminator service = context.getBean(LocalStudentExaminator.class);
        service.run();
    }

}
