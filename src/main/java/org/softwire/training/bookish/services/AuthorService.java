package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService extends DatabaseService {

    public List<Author> getAllAuthors() {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM author")
                        .mapToBean(Author.class)
                        .list()
        );
    }

    public void addAuthor(Author author) {
        jdbi.useHandle(handle ->
                handle.createUpdate("INSERT INTO author (name) VALUES (:name)")
                        .bind("name", author.getName())
                        .execute()
        );
    }

    public void deleteAuthor(int authorId) {
        jdbi.useHandle(handle ->
                handle.createUpdate("DELETE FROM author WHERE id = :id")
                        .bind("id", authorId)
                        .execute()
        );
    }
}
