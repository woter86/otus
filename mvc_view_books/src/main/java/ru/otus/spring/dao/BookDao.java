package ru.otus.spring.dao;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.domain.Book;

import java.util.List;

public interface BookDao extends JpaRepository<Book, Long> {

    @EntityGraph(value = "books-author-genre-entity-graph")
    List<Book> findAll();
}
