package ru.otus.spring.dao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Genre;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Dao для работы с книгами должно")
@JdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(BookDaoJdbc.class)
class BookDaoJdbcTest {

    private static final int EXPECTED_BOOKS_COUNT = 2;
    private static final int EXISTING_BOOK_ID = 1;

    @Autowired
    private BookDaoJdbc bookDaoJdbc;

    @DisplayName("возвращать ожидаемое количество книг в БД")
    @Test
    void shouldReturnExpectedBookCount() {
        int actualPersonsCount = bookDaoJdbc.count();
        assertThat(actualPersonsCount).isEqualTo(EXPECTED_BOOKS_COUNT);
    }

    @DisplayName("добавлять книгу в БД")
    @Test
    void shouldInsert() {
        Book book = new Book(3L, "Brara", new Author(1, "Marshak"), new Genre(2, "Roman"));
        long id = bookDaoJdbc.insert(book);
        Book actualBook = bookDaoJdbc.getById(id);
        Assertions.assertThat(actualBook).isEqualTo(book);
    }

    @DisplayName("возвращать ожидаемую книгу по id")
    @Test
    void getById() {
        Book book = new Book(EXISTING_BOOK_ID, "Rasskaz o neizvestnom geroe", new Author(1, "Marshak"),
                new Genre(1, "Poem"));
        Book actualBook = bookDaoJdbc.getById(EXISTING_BOOK_ID);
        Assertions.assertThat(actualBook).isEqualTo(book);
    }

    @DisplayName("возвращать ожидаемый список книг")
    @Test
    void getAll() {
        Book book1 = new Book(1, "Rasskaz o neizvestnom geroe", new Author(1, "Marshak"), new Genre(1, "Poem"));
        Book book2 = new Book(2, "Otcy i deti", new Author(2, "Tolstoy"), new Genre(2, "Roman"));
        List<Book> expectedBooks = Arrays.asList(book1, book2);
        List<Book> actualBooks = bookDaoJdbc.getAll();
        Assertions.assertThat(actualBooks).isEqualTo(expectedBooks);
    }

    @DisplayName("удалять заданную книгу по id")
    @Test
    void deleteById() {
        bookDaoJdbc.deleteById(EXISTING_BOOK_ID);

        Assertions.assertThatThrownBy(() -> bookDaoJdbc.getById(EXISTING_BOOK_ID)).isInstanceOf(EmptyResultDataAccessException.class)
                .hasMessageContaining("Incorrect result size: expected 1, actual 0");
    }
}