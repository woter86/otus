package ru.otus.spring.dao;

import ru.otus.spring.domain.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentDao {
    long count();

    Comment save(Comment comment);

    Optional<Comment> getById(long id);

    List<Comment> getAll();

    List<Comment> getByBookId(long bookId);

    void deleteById(long id);
}
