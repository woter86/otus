package ru.otus.spring.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.dao.BookDao;
import ru.otus.spring.dao.CommentDao;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Comment;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentDao commentDao;
    private final BookDao bookDao;

    public CommentServiceImpl(CommentDao commentDao, BookDao bookDao) {
        this.commentDao = commentDao;
        this.bookDao = bookDao;
    }

    @Transactional(readOnly = true)
    @Override
    public long count() {
        return commentDao.count();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Comment> getAll() {
        return commentDao.getAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Comment> getById(long id) {
        return commentDao.getById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Comment> getByBookId(long bookId) {
        return commentDao.getByBookId(bookId);
    }

    @Transactional
    @Override
    public Comment save(String comment, long bookId) {
        Optional<Book> book = bookDao.getById(bookId);
        if (book.isPresent()) {
            return commentDao.save(new Comment(book.get(), comment));
        }
        return null;
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        commentDao.deleteById(id);
    }
}
