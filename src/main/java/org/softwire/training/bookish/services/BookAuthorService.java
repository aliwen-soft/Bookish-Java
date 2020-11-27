package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Author;
import org.softwire.training.bookish.models.database.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookAuthorService extends DatabaseService {

    public List<Book> getAllAuthorsBooks(int authorId) {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT isbn, name, description FROM book LEFT JOIN bookauthor ON " +
                        "bookauthor.bookIsbn = book.isbn WHERE authorId = :authorId;")
                        .bind("authorId", authorId)
                        .mapToBean(Book.class)
                        .list()
        );
    }

    public String getAuthorsName(int authorId) {
        Author author = jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM author WHERE author.id = :authorId;")
                        .bind("authorId", authorId)
                        .mapToBean(Author.class)
                        .list()
                        .get(0)
        );
        return author.getName();
    }

}
