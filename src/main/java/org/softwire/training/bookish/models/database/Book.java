package org.softwire.training.bookish.models.database;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    private String isbn;
    private String name;
    private String description;

    public void display() {
        System.out.println(isbn + ", " + name + ", " + description);
    }
}
