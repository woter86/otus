package ru.otus.spring.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.otus.spring.domain.Author;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Dao для работы с авторами должно")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(AuthorDaoJPA.class)
class AuthorDaoJdbcTest {

    private static final long EXPECTED_AUTHORS_COUNT = 2;
    private static final long EXPECTED_AUTHORS_ID = 1;
    private static final int EXISTING_AUTHOR_ID = 1;
    private static final String EXISTING_AUTHOR_NAME = "Marshak";
    public static final String EXISTING_AUTHOR_NAME_2 = "Tolstoy";

    @Autowired
    private AuthorDaoJPA authorDao;

    @Autowired
    private TestEntityManager em;

    @DisplayName("возвращать ожидаемое количество авторов в БД")
    @Test
    void shouldReturnExpectedCount() {
        long actualCount = authorDao.count();
        assertThat(actualCount).isEqualTo(EXPECTED_AUTHORS_COUNT);
    }

    @DisplayName("добавлять автора в БД")
    @Test
    void shouldInsert() {
        Author expectedAuthor = new Author("Igor");
        Author actualAuthor = authorDao.save(expectedAuthor);
        assertThat(actualAuthor).usingRecursiveComparison().isEqualTo(expectedAuthor);
    }

    @DisplayName("возвращать ожидаемого автора по его id")
    @Test
    void shouldReturnExpectedAuthorById() {
        Author actualAuthor = authorDao.getById(EXPECTED_AUTHORS_ID).get();
        assertThat(actualAuthor).extracting(Author::getName).isEqualTo(EXISTING_AUTHOR_NAME);
    }

    @DisplayName("удалять заданного автора по id")
    @Test
    void shouldCorrectDeleteAuthorById() {
        authorDao.deleteById(EXISTING_AUTHOR_ID);
        assertThat(authorDao.getById(EXISTING_AUTHOR_ID)).isEmpty();
    }

    @DisplayName("возвращать ожидаемый список авторов")
    @Test
    void shouldReturnExpectedAuthorsList() {
        List<Author> actualAuthorList = authorDao.getAll();
        assertThat(actualAuthorList).extracting(Author::getName)
                .containsExactlyInAnyOrder(EXISTING_AUTHOR_NAME, EXISTING_AUTHOR_NAME_2);
    }

}