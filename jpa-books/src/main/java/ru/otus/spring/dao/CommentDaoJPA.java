package ru.otus.spring.dao;

import org.springframework.stereotype.Component;
import ru.otus.spring.domain.Comment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Component
public class CommentDaoJPA implements CommentDao {
    @PersistenceContext
    private final EntityManager em;

    public CommentDaoJPA(EntityManager em) {
        this.em = em;
    }

    @Override
    public long count() {
        TypedQuery<Long> query = em.createQuery("select count(c) from Comment c", Long.class);
        return query.getSingleResult();
    }

    @Override
    public Comment save(Comment comment) {
        if (comment.getId() <= 0) {
            em.persist(comment);
            return comment;
        } else {
            return em.merge(comment);
        }
    }

    @Override
    public Optional<Comment> getById(long id) {
        return Optional.ofNullable(em.find(Comment.class, id));
    }

    @Override
    public List<Comment> getAll() {
        TypedQuery<Comment> query = em.createQuery("select c from Comment c", Comment.class);
        return query.getResultList();
    }

    @Override
    public void deleteById(long id) {
        Comment comment = em.find(Comment.class, id);
        if (comment != null) {
            em.remove(comment);
        }
    }
}
