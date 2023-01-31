package ru.otus.spring.pages;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.otus.spring.dao.AuthorDao;
import ru.otus.spring.dao.GenreDao;
import ru.otus.spring.service.BookService;

@Controller
@RequiredArgsConstructor
public class BookPagesController {
    private final BookService bookService;
    private final AuthorDao authorDao;
    private final GenreDao genreDao;

    @GetMapping("/")
    public String listPage() {
        return "list";
    }

    @GetMapping("/edit.html")
    public String editPage() {
        return "edit";
    }
}
