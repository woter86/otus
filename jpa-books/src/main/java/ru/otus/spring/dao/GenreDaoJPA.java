package ru.otus.spring.dao;

import org.springframework.stereotype.Component;
import ru.otus.spring.domain.Genre;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Component
public class GenreDaoJPA implements GenreDao {
    @PersistenceContext
    private final EntityManager em;

    public GenreDaoJPA(EntityManager em) {
        this.em = em;
    }

    @Override
    public long count() {
        TypedQuery<Long> query = em.createQuery("select count(g) from Genre g", Long.class);
        return query.getSingleResult();
    }

    @Override
    public Genre save(Genre genre) {
        if (genre.getId() <= 0) {
            em.persist(genre);
            return genre;
        } else {
            return em.merge(genre);
        }
    }

    @Override
    public Optional<Genre> getById(long id) {
        return Optional.ofNullable(em.find(Genre.class, id));
    }

    @Override
    public List<Genre> getAll() {
        TypedQuery<Genre> query = em.createQuery("select g from Genre g", Genre.class);
        return query.getResultList();
    }

    @Override
    public void deleteById(long id) {
        Query query = em.createQuery("delete " + "from Genre g " + "where g.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public Genre findByName(String name) {
        try {
            TypedQuery<Genre> query = em.createQuery("select a from Genre a where a.name=:name", Genre.class);
            query.setParameter("name", name);
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

}
