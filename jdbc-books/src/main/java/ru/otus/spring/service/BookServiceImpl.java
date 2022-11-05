package ru.otus.spring.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.dao.AuthorDao;
import ru.otus.spring.dao.BookDao;
import ru.otus.spring.dao.GenreDao;
import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Genre;

import java.util.List;

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
        return bookDao.getAll();
    }

    @Override
    public Book getById(long id) {
        return bookDao.getById(id);
    }

    @Override
    public long insert(String name, String author, String genre) {
        long author_id = authorDao.insert(new Author(author));
        long genre_id = genreDao.insert(new Genre(genre));
        return bookDao.insert(new Book(name, authorDao.getById(author_id), genreDao.getById(genre_id)));
    }

    @Override
    public void deleteById(long id) {
        bookDao.deleteById(id);
    }
}
