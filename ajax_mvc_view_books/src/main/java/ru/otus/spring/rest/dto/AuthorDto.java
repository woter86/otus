package ru.otus.spring.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Book;

@Data
@AllArgsConstructor
public class AuthorDto {
    private long id = -1;
    private String name;

    public static AuthorDto toDto(Author author) {
        return new AuthorDto(author.getId(), author.getName());
    }
}
