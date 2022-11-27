package ru.otus.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "genres")
public class Genre {
    @Id
    private long id;
    private String name;

    public Genre(String name) {
        this.name = name;
    }
}
