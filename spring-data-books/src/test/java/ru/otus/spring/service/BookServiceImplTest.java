package ru.otus.spring.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.otus.spring.dao.AuthorDao;
import ru.otus.spring.dao.BookDao;
import ru.otus.spring.dao.GenreDao;
import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Genre;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@DisplayName("Сервис хранения книг должен ")
@SpringBootTest(classes = BookServiceImpl.class)
class BookServiceImplTest {


    private static final long EXPECTED_BOOKS_COUNT = 2;
    private static final long EXISTING_BOOK_ID = 1;
    private static final Book EXPECTED_BOOK = new Book(1L, "Rasskaz o neizvestnom geroe",
            new Author(1, "Marshak"),
            new Genre(1, "Poem"), null);
    @MockBean
    private BookDao bookDao;
    @MockBean
    private AuthorDao authorDao;
    @MockBean
    private GenreDao genreDao;

    @Autowired
    private BookService bookService;


    @Test
    void count() {
        given(bookDao.count()).willReturn(EXPECTED_BOOKS_COUNT);
        Assertions.assertThat(bookService.count()).isEqualTo(EXPECTED_BOOKS_COUNT);
    }

    @Test
    void getAll() {
        List<Book> expected_books = List.of(
                new Book(1L, "Rasskaz o neizvestnom geroe", new Author(1, "Marshak"), new Genre(1, "Poem"), null),
                new Book(2L, "Otcy i deti", new Author(2, "Tolstoy"), new Genre(2, "Roman"), null));
        given(bookDao.findAll()).willReturn(expected_books);
        Assertions.assertThat(bookService.getAll()).isEqualTo(expected_books);
    }

    @Test
    void getById() {
        given(bookDao.findById(EXISTING_BOOK_ID)).willReturn(Optional.of(EXPECTED_BOOK));
        Assertions.assertThat(bookService.getById(EXISTING_BOOK_ID)).isEqualTo(Optional.of(EXPECTED_BOOK));
    }

    @Test
    void save() {
        Author author = new Author(1, "Marshak");
        Genre genre = new Genre(1, "Poem");
        given(authorDao.findByName(author.getName()))
                .willReturn(author);
        given(genreDao.findByName(genre.getName()))
                .willReturn(genre);


        given(bookDao.save(any(Book.class))).willReturn(EXPECTED_BOOK);

        Assertions.assertThat(bookService.save(
                        EXPECTED_BOOK.getName(),
                        EXPECTED_BOOK.getAuthor().getName(),
                        EXPECTED_BOOK.getGenre().getName()))
                .isEqualTo(EXPECTED_BOOK);
    }

    @Test
    void deleteById() {
        bookService.deleteById(EXISTING_BOOK_ID);
        given(bookDao.findById(EXISTING_BOOK_ID)).willReturn(Optional.ofNullable(null));
        Assertions.assertThat(bookService.getById(EXISTING_BOOK_ID)).isEqualTo(Optional.ofNullable(null));
    }
}