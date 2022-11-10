package ru.otus.spring.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.dao.AuthorDao;
import ru.otus.spring.domain.Author;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorDao authorDao;

    public AuthorServiceImpl(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Transactional(readOnly = true)
    @Override
    public long count() {
        return authorDao.count();
    }
    @Transactional(readOnly = true)
    @Override
    public List<Author> getAll() {
        return authorDao.getAll();
    }
    @Transactional(readOnly = true)
    @Override
    public Optional<Author> getById(long id) {
        return authorDao.getById(id);
    }

    @Transactional
    @Override
    public Author save(String name) {
        return authorDao.save(new Author(name));
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        authorDao.deleteById(id);
    }
}
