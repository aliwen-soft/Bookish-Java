package org.softwire.training.bookish;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.reflect.ConstructorMapper;
import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.Technology;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

/**
 * Entry point to the Bookish Application
 */
@SpringBootApplication
public class BookishWeb {
    public static void main(String[] args) {
        SpringApplication.run(BookishWeb.class, args);
    }

}