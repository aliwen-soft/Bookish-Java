package org.softwire.training.bookish.models.database;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Author {
    private int id;
    private String name;

    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }
}
