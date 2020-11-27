package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.models.database.BookCopy;
import org.softwire.training.bookish.models.page.CopiesPageModel;
import org.softwire.training.bookish.services.CopiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/book-copies")
public class CopiesController {

    private final CopiesService copiesService;

    @Autowired
    public CopiesController(CopiesService copiesService) {
        this.copiesService = copiesService;
    }

    @RequestMapping("")
    ModelAndView copiesPage(@RequestParam String isbn) {

        List<BookCopy> allCopies = copiesService.getAllCopies(isbn);

        CopiesPageModel copiesPageModel = new CopiesPageModel();
        copiesPageModel.setCopies(allCopies);
        copiesPageModel.setBookName(copiesService.getBookName(isbn));

        return new ModelAndView("book-copies", "model", copiesPageModel);
    }
}
