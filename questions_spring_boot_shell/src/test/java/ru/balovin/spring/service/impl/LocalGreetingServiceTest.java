package ru.balovin.spring.service.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.MessageSource;
import ru.balovin.spring.service.IOService;

import java.util.Locale;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest(classes = {LocalGreetingService.class, IOService.class, MessageSource.class})
@DisplayName("Test LocalGreetingService")
@ImportAutoConfiguration(MessageSourceAutoConfiguration.class)
class LocalGreetingServiceTest {

    @MockBean
    private IOService ioService;
    @MockBean
    private MessageSource messageSource;

    @Autowired
    private LocalGreetingService localGreetingService;

    @Test
    @DisplayName("Correct say hello")
    void sayHello() {
        given(messageSource.getMessage(anyString(), eq(null), any(Locale.class))).willReturn("hello");
        given(ioService.readString()).willReturn("hello");
        localGreetingService.hello();
        verify(messageSource, times(2)).getMessage(anyString(), eq(null), any(Locale.class));
        verify(ioService, times(2)).readString();
        verify(ioService, times(2)).out(eq("hello"));
    }
}