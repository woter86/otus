package ru.otus.spring.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.dao.AuthorDao;
import ru.otus.spring.dao.BookDao;
import ru.otus.spring.dao.GenreDao;
import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Genre;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookDao bookDao;
    private final AuthorDao authorDao;
    private final GenreDao genreDao;

    public BookServiceImpl(BookDao bookDao, AuthorDao authorDao, GenreDao genreDao) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
        this.genreDao = genreDao;
    }

    @Override
    public long count() {
        return bookDao.count();
    }

    @Override
    public List<Book> getAll() {
        return bookDao.findAll();
    }

    @Override
    public Optional<Book> getById(long id) {
        return bookDao.findById(id);
    }

    @Transactional
    @Override
    public Book save(String name, String authorName, String genreName) {
        Author author = authorDao.findByName(authorName);
        if (author == null) {
            author = new Author(authorName);
        }
        Genre genre = genreDao.findByName(genreName);
        if (genre == null) {
            genre = new Genre(genreName);
        }
        return bookDao.save(new Book(name, author, genre));
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        bookDao.deleteById(id);
    }
}
