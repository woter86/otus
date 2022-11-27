package ru.otus.spring.service;

import ru.otus.spring.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    long count();

    List<Author> getAll();

    Optional<Author> getById(long id);

    Author save(String name);

    void deleteById(long id);
}
