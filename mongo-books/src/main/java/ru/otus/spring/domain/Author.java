package ru.otus.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "authors")
public class Author {
    @Id
    private long id;

    private String name;

    public Author(String name) {
        this.name = name;
    }
}
