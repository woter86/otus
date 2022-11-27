package ru.otus.spring.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.spring.domain.Book;

import java.util.List;

public interface BookDao extends MongoRepository<Book, Long> {

    List<Book> findAll();
}
