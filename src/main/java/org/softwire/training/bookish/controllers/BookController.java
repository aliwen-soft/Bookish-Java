package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.page.BookPageModel;
import org.softwire.training.bookish.models.page.BooksPageModel;
import org.softwire.training.bookish.services.BookService;
import org.softwire.training.bookish.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("")
    ModelAndView bookPage( @RequestParam("isbn") String isbn ) {

        Book selected = bookService.getBook(isbn);

        BookPageModel bookPageModel = new BookPageModel();
        bookPageModel.setSelectedBook(selected);

        return new ModelAndView("book", "model", bookPageModel);
    }

}
