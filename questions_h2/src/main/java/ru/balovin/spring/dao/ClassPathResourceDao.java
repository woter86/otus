package ru.balovin.spring.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class ClassPathResourceDao implements ResourceDao {
    private final Class clazz;

    public ClassPathResourceDao(@Value("#{T(ru.balovin.spring.Main)}") Class clazz) {
        this.clazz = clazz;
    }

    @Override
    public InputStream getResourceAsStream(String name) {
        return clazz.getClassLoader().getResourceAsStream(name);
    }
}
