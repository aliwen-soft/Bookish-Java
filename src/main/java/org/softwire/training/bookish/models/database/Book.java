package org.softwire.training.bookish.models.database;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import java.beans.ConstructorProperties;


public class Book {
    private final String isbn;
    private final String name;
    private final String description;

    public String getIsbn() {
        return isbn;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

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
