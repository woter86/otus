package ru.otus.spring.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.spring.service.AuthorService;
import ru.otus.spring.service.BookService;
import ru.otus.spring.service.CommentService;

@ShellComponent
public class BooksShell {
    private final BookService bookService;
    private final AuthorService authorService;

    private final CommentService commentService;

    public BooksShell(BookService bookService, AuthorService authorService, CommentService commentService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.commentService = commentService;
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

    @ShellMethod(value = "Get authors count", key = {"authors-count", "ac"})
    public void authorsCount() {
        System.out.println("Authors count: " + authorService.count());
    }

    @ShellMethod(value = "Get all authors", key = {"get-all-authors"})
    public void getAllAuthors() {
        System.out.println(authorService.getAll());
    }

    @ShellMethod(value = "Get author by id", key = {"get-author-by-id"})
    public void getAuthorById(@ShellOption long id) {
        System.out.println(authorService.getById(id));
    }

    @ShellMethod(value = "Insert author", key = {"insert-author"})
    public void insertAuthor(
            @ShellOption String name) {
        System.out.println("Author inserted " + authorService.save(name));
    }

    @ShellMethod(value = "Delete author by id", key = {"delete-author-by-id"})
    public void deleteAuthorById(@ShellOption long id) {
        authorService.deleteById(id);
    }

    @ShellMethod(value = "Get comments count", key = {"comments-count", "cc"})
    public void commentsCount() {
        System.out.println("Comments count: " + commentService.count());
    }

    @ShellMethod(value = "Delete comment by id", key = {"delete-comment-by-id"})
    public void deleteCommentById(@ShellOption long id) {
        commentService.deleteById(id);
    }

    @ShellMethod(value = "Insert comment", key = {"insert-comment"})
    public void insertComment(
            @ShellOption(value = {"--book-id", "-b"}) long bookId,
            @ShellOption(value = {"--comment", "-c"}) String comment) {
        System.out.println("Comment inserted " + commentService.save(comment, bookId));
    }

    @ShellMethod(value = "Get comment by id", key = {"get-comment-by-id"})
    public void getCommentById(@ShellOption long id) {
        System.out.println(commentService.getById(id));
    }

    @ShellMethod(value = "Get comments by book id", key = {"get-comments-by-books-id"})
    public void getCommentByBooksId(@ShellOption long bookId) {
        System.out.println(commentService.getByBookId(bookId));
    }

    @ShellMethod(value = "Get all comments", key = {"get-all-comments"})
    public void getAllComments() {
        System.out.println(commentService.getAll());
    }

}
