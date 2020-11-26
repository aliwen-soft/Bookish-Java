package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.Technology;

import java.util.List;

public class BookService extends DatabaseService{

    public List<Book> getAllBooks() {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM book")
                        .mapToBean(Book.class)
                        .list()
        );
    }

    public void addBook(Book book) {
        jdbi.useHandle(handle ->
                handle.createUpdate("INSERT INTO book (isbn ,name, author) VALUES (:isbn, :name, :description)")
                        .bind("isbn", book.getIsbn())
                        .bind("name", book.getName())
                        .bind("description", book.getDescription())
                        .execute()
        );
    }

    public void deleteBook(String isbn) {
        jdbi.useHandle(handle ->
                handle.createUpdate("DELETE FROM book WHERE isbn = :isbn")
                        .bind("isbn", isbn)
                        .execute()
        );
    }
}