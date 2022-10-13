package ru.balovin.spring.dao;

import java.io.InputStream;

public interface ResourceDao {
    InputStream getResourceAsStream(String name);
}
