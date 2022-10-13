package ru.balovin.spring.service;

import java.io.InputStream;

public interface ResourceService {
    InputStream getResourceAsStream(String name);
}