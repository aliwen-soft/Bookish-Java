package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService extends DatabaseService{

    public List<Book> getAllBooks() {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM book")
                        .mapToBean(Book.class)
                        .list()
        );
    }

    public void addBook(Book book) {
        jdbi.useHandle(handle ->
                handle.createUpdate("INSERT INTO book (isbn ,name, description) VALUES (:isbn, :name, :description)")
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

    public void addCopy(String isbn) {
        jdbi.useHandle(handle ->
                handle.createUpdate("INSERT INTO bookcopy (bookisbn) VALUES (:bookisbn)")
                        .bind("bookisbn", isbn)
                        .execute()
        );
    }

    public void linkAuthor(String isbn, String authorid) {
        jdbi.useHandle(handle ->
                handle.createUpdate("INSERT INTO bookauthor (authorId, bookIsbn) VALUES (:authorId, :bookIsbn)")
                        .bind("bookIsbn", isbn)
                        .bind("authorId", authorid)
                        .execute()
        );
    }
}
