package org.softwire.training.bookish.models.database;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class BookCopy {
    private int id;
    private String bookisbn;
    private int status;
    private Date dueDate;
}
