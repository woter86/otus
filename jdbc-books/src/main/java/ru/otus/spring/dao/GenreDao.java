package ru.otus.spring.dao;

import ru.otus.spring.domain.Author;

import java.util.List;

public interface GenreDao {

    int count();

    void insert(Author author);

    Author getById(long id);

    List<Author> getAll();

    void deleteById(long id);
}
