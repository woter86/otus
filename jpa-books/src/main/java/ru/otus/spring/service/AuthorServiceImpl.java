package ru.otus.spring.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.dao.AuthorDao;
import ru.otus.spring.domain.Author;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorDao authorDao;

    public AuthorServiceImpl(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }


    @Override
    public long count() {
        return authorDao.count();
    }

    @Override
    public List<Author> getAll() {
        return authorDao.getAll();
    }

    @Override
    public Author getById(long id) {
        return authorDao.getById(id);
    }

    @Override
    public long insert(String name) {
        return authorDao.insert(new Author(name));
    }

    @Override
    public void deleteById(long id) {
        authorDao.deleteById(id);
    }
}
