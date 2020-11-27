package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.models.database.Author;
import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.page.SelectedBookPageModel;
import org.softwire.training.bookish.services.SelectedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/selectedBook")
public class SelectedBookController {

    private final SelectedBookService selectedBookService;

    @Autowired
    public SelectedBookController(SelectedBookService selectedBookService) {
        this.selectedBookService = selectedBookService;
    }

    @RequestMapping("")
    ModelAndView bookPage( @RequestParam("isbn") String isbn ) {

        Book selected = selectedBookService.getBook(isbn);
        List<Author> authors = selectedBookService.getAuthors(isbn);

        SelectedBookPageModel selectedBookPageModel = new SelectedBookPageModel(selected,authors);

        return new ModelAndView("selectedBook", "model", selectedBookPageModel);
    }

}
