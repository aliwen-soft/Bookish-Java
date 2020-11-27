package org.softwire.training.bookish.models.page;

import lombok.Getter;
import org.softwire.training.bookish.models.database.Author;
import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.Genre;

import java.util.List;

@Getter
public class SelectedBookPageModel {
    private final Book selectedBook;
    private final List<Author> authors;
    private final List<Genre> genres;
    private final int bookCopies;

    public SelectedBookPageModel(Book selected, List<Author> authors,List<Genre> genres, int copys) {
        this.selectedBook = selected;
        this.authors = authors;
        this.genres = genres;
        this.bookCopies = copys;
    }
}
