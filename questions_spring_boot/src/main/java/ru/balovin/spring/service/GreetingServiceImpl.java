package ru.balovin.spring.service;

import org.springframework.stereotype.Service;
import ru.balovin.spring.domain.Student;

@Service
public class GreetingServiceImpl implements GreetingService{
    private final IOService ioService;

    public GreetingServiceImpl(IOService ioService) {
        this.ioService = ioService;
    }

    @Override
    public Student hello() {
        ioService.out("Hello, what is your surname?");
        String surname = ioService.readString();
        ioService.out("And what is your name?");
        String name = ioService.readString();
        return new Student(surname, name);
    }
}
