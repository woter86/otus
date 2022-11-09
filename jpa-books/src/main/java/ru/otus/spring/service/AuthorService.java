package ru.otus.spring.service;

import ru.otus.spring.domain.Author;

import java.util.List;

public interface AuthorService {
    long count();

    List<Author> getAll();

    Author getById(long id);

    long insert(String name);

    void deleteById(long id);
}
