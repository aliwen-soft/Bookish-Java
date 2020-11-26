package org.softwire.training.bookish;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.reflect.ConstructorMapper;
import org.softwire.training.bookish.models.database.Book;

import java.sql.*;
import java.util.Map;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;



public class Main {

    public static String getPW(){
        Map<String, String> env = System.getenv();
        String pw = env.get("SQLPW");
        return pw;
    }

    public static void main(String[] args) throws SQLException {
        String hostname = "localhost:3306";
        String database = "bookish";
        String user = "root";
        String password = getPW();

        String connectionString = "jdbc:mysql://" + hostname + "/" + database + "?user=" + user + "&password=" + password + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT&useSSL=false";

        jdbcMethod(connectionString);
        jdbiMethod(connectionString);
    }

    private static void jdbcMethod(String connectionString) throws SQLException {
        System.out.println("JDBC method...");
        Connection connection = DriverManager.getConnection(connectionString);

        String query = "SELECT * FROM BOOK";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String isbn = rs.getString("isbn");
                String bookName = rs.getString("Name");
                String description = rs.getString("Description");
                System.out.println(isbn + ", " + bookName) ;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private static void jdbiMethod(String connectionString) {
        System.out.println("\nJDBI method...");

        Jdbi jdbi = Jdbi.create(connectionString);
        Handle handle = jdbi.open();
        handle.registerRowMapper(ConstructorMapper.factory(Book.class));
        List<Book> books = handle.createQuery("SELECT * FROM book")
                        .mapTo(Book.class)
                        .list();
        display(books);
    }

    private static void display(List<Book> books) {
        for (Book book: books) {
            book.display();
        }
    }
}
