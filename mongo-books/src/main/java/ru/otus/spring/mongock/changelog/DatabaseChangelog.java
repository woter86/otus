package ru.otus.spring.mongock.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoDatabase;
import ru.otus.spring.dao.AuthorDao;
import ru.otus.spring.dao.BookDao;
import ru.otus.spring.dao.GenreDao;
import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Comment;
import ru.otus.spring.domain.Genre;

import java.util.ArrayList;

@ChangeLog
public class DatabaseChangelog {

    @ChangeSet(order = "001", id = "dropDb", author = "balovin", runAlways = true)
    public void dropDb(MongoDatabase db) {
        db.drop();
    }

    @ChangeSet(order = "002", id = "insertMarshak", author = "balovin")
    public void insertMarshak(AuthorDao repository) {
        repository.save(new Author(0, "Marshak"));
    }

    @ChangeSet(order = "003", id = "insertTolstoy", author = "balovin")
    public void insertTolstoy(AuthorDao repository) {
        repository.save(new Author(1, "Tolstoy"));
    }

    @ChangeSet(order = "004", id = "insertPoem", author = "balovin")
    public void insertPoem(GenreDao repository) {
        repository.save(new Genre(0,"Poem"));
    }

    @ChangeSet(order = "005", id = "insertRoman", author = "balovin")
    public void insertRoman(GenreDao repository) {
        repository.save(new Genre(1, "Roman"));
    }

    @ChangeSet(order = "006", id = "insertBookRasskaz", author = "balovin")
    public void insertBookM(BookDao repository) {
        repository.save(new Book(0, "Rasskaz o neizvestnom geroe", new Author(0, "Marshak"), new Genre(0, "Poem")));
    }

    @ChangeSet(order = "007", id = "insertBook", author = "balovin")
    public void insertBook(BookDao repository) {
        repository.save(new Book(1, "Rasskaz o neizvestnom geroe", new Author(1, "Tolstoy"), new Genre(1, "Roman")));
    }

}
