package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Author;
import org.softwire.training.bookish.models.database.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelectedBookService extends DatabaseService{

    public Book getBook(String isbn) {
        List<Book> books = jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM book WHERE :isbn = (isbn)\"")
                        .bind("isbn",isbn)
                        .mapToBean(Book.class)
                        .list()
        );
        return books.get(0);
    }

    public List<Author> getAuthors(String isbn) {
        List<Author> author = jdbi.withHandle(handle ->
                handle.createQuery("select id , name from author left join bookauthor on bookauthor.authorId = author.id Where :bookisbn = (bookisbn) ;")
                        .bind("bookisbn", isbn)
                        .mapToBean(Author.class)
                        .list()
        );
        return author;
    }
}
