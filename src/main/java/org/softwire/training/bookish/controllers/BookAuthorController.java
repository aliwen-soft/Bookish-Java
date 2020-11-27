package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.page.BookAuthorPageModel;
import org.softwire.training.bookish.services.BookAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/author-books")
public class BookAuthorController {

    private final BookAuthorService bookAuthorService;

    @Autowired
    public BookAuthorController(BookAuthorService bookAuthorService) {
        this.bookAuthorService = bookAuthorService;
    }

    @RequestMapping("")
    ModelAndView bookAuthors(@RequestParam int authorId) {

        List<Book> allAuthorsBooks = bookAuthorService.getAllAuthorsBooks(authorId);

        BookAuthorPageModel bookAuthorPageModel = new BookAuthorPageModel();
        bookAuthorPageModel.setBooks(allAuthorsBooks);
        bookAuthorPageModel.setAuthor(bookAuthorService.getAuthorsName(authorId));

        return new ModelAndView("author-books", "model", bookAuthorPageModel);
    }
}
