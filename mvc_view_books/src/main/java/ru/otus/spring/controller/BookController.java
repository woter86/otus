package ru.otus.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.otus.spring.dao.AuthorDao;
import ru.otus.spring.dao.GenreDao;
import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Genre;
import ru.otus.spring.service.BookService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final AuthorDao authorDao;
    private final GenreDao genreDao;
    @GetMapping("/")
    public String listPage(Model model) {
        List<Book> books = bookService.getAll();
        model.addAttribute("books", books);
        return "list";
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam("id") long id, Model model) {
        bookService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String getBookEdit(@RequestParam("id") long id, Model model) {
        Book book = bookService.getById(id).get();
        List<Author> authors = authorDao.findAll();
        List<Genre> genres = genreDao.findAll();
        model.addAttribute("book", book);
        model.addAttribute("authors", authors);
        model.addAttribute("genres", genres);
        return "edit";
    }


    @PostMapping("/edit")
    public String editBook(@ModelAttribute Book book) {
        bookService.save(book.getName(), book.getAuthor().getName(), book.getGenre().getName());
        return "redirect:/";
    }

    @GetMapping("/add")
    public String addBook(Model model) {
        Book book = new Book("New book", new Author(""), new Genre(""));
        model.addAttribute("book", book);
        List<Author> authors = authorDao.findAll();
        List<Genre> genres = genreDao.findAll();
        model.addAttribute("authors", authors);
        model.addAttribute("genres", genres);
        return "edit";
    }
}
