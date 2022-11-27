package ru.otus.spring.service;

import ru.otus.spring.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    long count();

    List<Book> getAll();

    Optional<Book> getById(long id);

    Book insert(String name, String author, String genre);

    void deleteById(long id);
}
