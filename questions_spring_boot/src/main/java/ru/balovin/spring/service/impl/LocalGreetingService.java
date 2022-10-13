package ru.balovin.spring.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.balovin.spring.domain.Student;
import ru.balovin.spring.service.GreetingService;
import ru.balovin.spring.service.IOService;

import java.util.Locale;

@Service
public class LocalGreetingService implements GreetingService {
    private final IOService ioService;
    private final MessageSource messageSource;
    private final Locale locale;

    public LocalGreetingService(IOService ioService, MessageSource messageSource, @Value("${application.locale}") Locale locale) {
        this.ioService = ioService;
        this.messageSource = messageSource;
        this.locale = locale;
    }

    @Override
    public Student hello() {
        ioService.out(messageSource.getMessage("greeting.surname", null, locale));
        String surname = ioService.readString();
        ioService.out(messageSource.getMessage("greeting.name", null, locale));
        String name = ioService.readString();
        return new Student(surname, name);
    }
}
