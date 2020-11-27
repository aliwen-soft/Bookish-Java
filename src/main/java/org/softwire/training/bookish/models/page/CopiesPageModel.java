package org.softwire.training.bookish.models.page;

import lombok.Getter;
import lombok.Setter;
import org.softwire.training.bookish.models.database.BookCopy;

import java.util.List;

@Getter
@Setter
public class CopiesPageModel {
    private List<BookCopy> copies;
    private String bookName;
}
