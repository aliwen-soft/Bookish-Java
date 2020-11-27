package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Author;
import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.Genre;
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

    public List<Genre> getGenre(String isbn) {
        List<Genre> genres = jdbi.withHandle(handle ->
                handle.createQuery("select id , name ,ageGroup from genre left join bookgenre on bookgenre.genreId = genre.id Where :bookisbn = (bookisbn) ;")
                        .bind("bookisbn", isbn)
                        .mapToBean(Genre.class)
                        .list()
        );
        return genres;
    }
}
