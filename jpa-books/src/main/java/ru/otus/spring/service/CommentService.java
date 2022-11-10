package ru.otus.spring.service;

import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    long count();

    List<Comment> getAll();

    Optional<Comment> getById(long id);

    List<Comment> getByBookId(long bookId);

    Comment save(String Comment, long bookId);

    void deleteById(long id);
}
