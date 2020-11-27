package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.BookCopy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CopiesService extends DatabaseService {

    public List<BookCopy> getAllCopies(String isbn) {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT bookcopy.id, isbn, dueDate, status FROM bookcopy LEFT " +
                        "JOIN book ON book.isbn = bookcopy.bookisbn LEFT JOIN loan ON loan.copyid = " +
                        "bookcopy.id WHERE bookisbn = :isbn")
                        .bind("isbn", isbn)
                        .mapToBean(BookCopy.class)
                        .list()
        );
    }

    public String getBookName(String isbn) {
        Book book = jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM book WHERE book.isbn = :isbn;")
                        .bind("isbn", isbn)
                        .mapToBean(Book.class)
                        .list()
                        .get(0)
        );
        return book.getName();
    }

}
