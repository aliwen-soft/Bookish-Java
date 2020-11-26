package org.softwire.training.bookish.models.database;

import java.beans.ConstructorProperties;

public class Book {
    private final String isbn;
    private final String name;
    private final String description;

    @ConstructorProperties({"isbn", "name", "description"})
    public Book(String isbn, String name, String description) {
        this.isbn = isbn;
        this.name = name;
        this.description = description;
    }

    public void display() {
        System.out.println(isbn + ", " + name + ", " + description);
    }
}
