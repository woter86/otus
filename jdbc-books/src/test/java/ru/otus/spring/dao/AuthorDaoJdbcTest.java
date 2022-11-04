package ru.otus.spring.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import ru.otus.spring.domain.Author;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Dao для работы с пёрсонами должно")
@JdbcTest
@Import(AuthorDaoJdbc.class)
//@Transactional(propagation = Propagation.NOT_SUPPORTED)
class AuthorDaoJdbcTest {

    private static final int EXPECTED_PERSONS_COUNT = 1;
    private static final int EXISTING_PERSON_ID = 1;
    private static final String EXISTING_PERSON_NAME = "Ivan";

    @Autowired
    private AuthorDaoJdbc personDao;

    @BeforeTransaction
    void beforeTransaction(){
        System.out.println("beforeTransaction");
    }

    @AfterTransaction
    void afterTransaction(){
        System.out.println("afterTransaction");
    }

    @DisplayName("возвращать ожидаемое количество пёрсонов в БД")
    @Test
    void shouldReturnExpectedPersonCount() {
        int actualPersonsCount = personDao.count();
        assertThat(actualPersonsCount).isEqualTo(EXPECTED_PERSONS_COUNT);
    }

    //@Rollback(value = false)
    //@Commit
    @DisplayName("добавлять пёрсона в БД")
    @Test
    void shouldInsertPerson() {
        Author expectedAuthor = new Author(2, "Igor");
        personDao.insert(expectedAuthor);
        Author actualAuthor = personDao.getById(expectedAuthor.getId());
        assertThat(actualAuthor).usingRecursiveComparison().isEqualTo(expectedAuthor);
    }

    @DisplayName("возвращать ожидаемого пёрсона по его id")
    @Test
    void shouldReturnExpectedPersonById() {
        Author expectedAuthor = new Author(EXISTING_PERSON_ID, EXISTING_PERSON_NAME);
        Author actualAuthor = personDao.getById(expectedAuthor.getId());
        assertThat(actualAuthor).usingRecursiveComparison().isEqualTo(expectedAuthor);
    }

    @DisplayName("удалять заданного пёрсона по его id")
    @Test
    void shouldCorrectDeletePersonById() {
        assertThatCode(() -> personDao.getById(EXISTING_PERSON_ID))
                .doesNotThrowAnyException();

        personDao.deleteById(EXISTING_PERSON_ID);

        assertThatThrownBy(() -> personDao.getById(EXISTING_PERSON_ID))
                .isInstanceOf(EmptyResultDataAccessException.class);
    }

    @DisplayName("возвращать ожидаемый список пёрсонов")
    @Test
    void shouldReturnExpectedPersonsList() {
        Author expectedAuthor = new Author(EXISTING_PERSON_ID, EXISTING_PERSON_NAME);
        List<Author> actualAuthorList = personDao.getAll();
        assertThat(actualAuthorList)
                .containsExactlyInAnyOrder(expectedAuthor);
    }
}