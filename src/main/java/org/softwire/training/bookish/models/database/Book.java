package org.softwire.training.bookish.models.database;

public class Book {
    private String isbn;
    private String name;
    private String description;

    public Book(String isbn, String name, String description) {
        this.isbn = isbn;
        this.name = name;
        this.description = description;
    }


    public void display() {
        System.out.println(isbn + ", " + name + ", " + description);
    }
}
