package ru.otus.spring.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.spring.service.BookService;

@ShellComponent
public class BooksShell {
    private final BookService bookService;

    public BooksShell(BookService bookService) {
        this.bookService = bookService;
    }

    @ShellMethod(value = "Get books count", key = {"books-count", "count"})
    public void booksCount() {
        System.out.println("Books count: " + bookService.count());
    }

    @ShellMethod(value = "Get all books", key = {"get-all-books"})
    public void getAllBooks() {
        System.out.println(bookService.getAll());
    }

    @ShellMethod(value = "Get book by id", key = {"get-book-by-id"})
    public void getBookById(@ShellOption long id) {
        System.out.println(bookService.getById(id));
    }

    @ShellMethod(value = "Insert book", key = {"insert-book"})
    public void insertBook(
            @ShellOption(value = {"-name", "-n"}) String name,
            @ShellOption(value = {"-author", "-a"}) String author,
            @ShellOption(value = {"-genre", "-g"}) String genre) {
        System.out.println("Book inserted with id = " + bookService.insert(name, author, genre));
    }

    @ShellMethod(value = "Delete book by id", key = {"delete-book-by-id"})
    public void deleteBookById(@ShellOption long id) {
        bookService.deleteById(id);
    }
}
