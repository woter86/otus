package ru.otus.spring.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Genre;

@Data
@AllArgsConstructor
public class BookDto {
    private long id = -1;
    private String name;
    private Author author;
    private Genre genre;

    public static BookDto toDto(Book book) {
        return new BookDto(book.getId(), book.getName(), book.getAuthor(), book.getGenre());
    }
}
