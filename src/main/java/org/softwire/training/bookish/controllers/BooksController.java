package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.page.BooksPageModel;
import org.softwire.training.bookish.services.AuthorService;
import org.softwire.training.bookish.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BooksController {

    private final BooksService booksService;

    @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @RequestMapping("")
    ModelAndView booksPage() {

        List<Book> allBooks = booksService.getAllBooks();

        BooksPageModel booksPageModel = new BooksPageModel();
        booksPageModel.setBooks(allBooks);

        return new ModelAndView("books", "model", booksPageModel);
    }

    @RequestMapping("/add-book")
    RedirectView addBook(@RequestParam String isbn, @RequestParam String name, @RequestParam String description, @RequestParam String authors, @RequestParam String genres) {

        String[] authorlist = authors.split(",");
        String[] genreList = genres.split(",");

        Book book = new Book(isbn,name,description);
        booksService.addBook(book);

        for(String id :authorlist){
            booksService.linkAuthor(isbn,id);
        }

        for(String id :genreList){
            booksService.linkGenre(isbn,id);
        }

        return new RedirectView("/books");
    }

    @RequestMapping("/delete-book")
    RedirectView deleteBook(@RequestParam String isbn) {

        booksService.deleteBook(isbn);

        return new RedirectView("/books");
    }

    @RequestMapping("/add-copy")
    RedirectView addCopy(@RequestParam String isbn ) {

        booksService.addCopy(isbn);

        return new RedirectView("/books");
    }
}
