package ru.otus.spring.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Author {
    private final long id;
    private final String name;

    public Author(String name) {
        this.id = -1; // only for insert
        this.name = name;
    }
}
