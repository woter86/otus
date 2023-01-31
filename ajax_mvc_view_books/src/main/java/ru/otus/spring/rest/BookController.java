package ru.otus.spring.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.otus.spring.dao.AuthorDao;
import ru.otus.spring.dao.GenreDao;
import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Genre;
import ru.otus.spring.rest.dto.AuthorDto;
import ru.otus.spring.rest.dto.BookDto;
import ru.otus.spring.rest.dto.GenreDto;
import ru.otus.spring.service.BookService;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class BookController {
    private final BookService bookService;
    private final AuthorDao authorDao;
    private final GenreDao genreDao;

    @GetMapping("/api/books")
    public List<BookDto> getAllBooks() {
        return bookService.getAll().stream().map(BookDto::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/api/books/{bookId}")
    public BookDto getBook(@PathVariable Long bookId) {
        if (bookId == 0) {
            return new BookDto(-1, "New book", new Author(""), new Genre(""));
        }
        return bookService.getById(bookId).map(BookDto::toDto).get();
    }

    @DeleteMapping("/api/books/{bookId}")
    public void deleteBook(@PathVariable Long bookId) {
        bookService.deleteById(bookId);
    }

    @PutMapping("/api/books/{bookId}")
    public void updateBook(@PathVariable Long bookId, @RequestBody BookDto bookDto) {
        bookService.save(bookDto.getName(), bookDto.getAuthor().getName(), bookDto.getGenre().getName());
        // return bookService.getById(bookId).map(BookDto::toDto).get();
    }

    @GetMapping("/api/authors")
    public List<AuthorDto> getAllAuthors() {
        return authorDao.findAll().stream().map(AuthorDto::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/api/genres")
    public List<GenreDto> getAllGenres() {
        return genreDao.findAll().stream().map(GenreDto::toDto)
                .collect(Collectors.toList());
    }
}
