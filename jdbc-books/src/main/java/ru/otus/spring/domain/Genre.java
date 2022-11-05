package ru.otus.spring.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Genre {
    private final long id;
    private final String name;

    public Genre(String name) {
        this.id = -1; // only for insert
        this.name = name;
    }
}
