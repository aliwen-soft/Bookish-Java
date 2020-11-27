package org.softwire.training.bookish.models.page;

import lombok.Getter;
import lombok.Setter;
import org.softwire.training.bookish.models.database.Author;
import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.Genre;

import java.util.List;

@Getter
public class SelectedBookPageModel {
    private final Book selectedBook;
    private final List<Author> authors;
    private final List<Genre> genres;

    public SelectedBookPageModel(Book selected, List<Author> authors,List<Genre> genres) {
        this.selectedBook = selected;
        this.authors = authors;
        this.genres = genres;
    }
}
