package org.softwire.training.bookish.models.database;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import java.beans.ConstructorProperties;


public class Book {
    private String isbn;
    private String name;
    private String description;

    public String getIsbn() {
        return isbn;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void display() {
        System.out.println(isbn + ", " + name + ", " + description);
    }
}
