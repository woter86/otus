package ru.otus.spring.service;

import ru.otus.spring.domain.Book;

import java.util.List;

public interface BookService {
    long count();

    List<Book> getAll();

    Book getById(long id);

    long insert(String name, String author, String genre);

    void deleteById(long id);
}
