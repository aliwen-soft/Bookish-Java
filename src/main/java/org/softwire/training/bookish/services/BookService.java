package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService extends DatabaseService{

    public Book getBook(String isbn) {
        List<Book> books = jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM book WHERE :isbn = (isbn)\"")
                        .bind("isbn",isbn)
                        .mapToBean(Book.class)
                        .list()
        );
        return books.get(0);
    }


}
