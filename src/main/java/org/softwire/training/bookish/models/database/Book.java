package org.softwire.training.bookish.models.database;

public class Book {
    private String isbn;
    private String Name;
    private String Description;

    public Book(String isbn, String Name, String Description) {
        this.isbn = isbn;
        this.Name = Name;
        this.Description = Description;
    }


    public void display() {
        System.out.println(isbn + ", " + Name + ", " + Description);
    }
}
