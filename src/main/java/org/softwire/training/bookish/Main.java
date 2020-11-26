package org.softwire.training.bookish;

import org.jdbi.v3.core.Jdbi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


public class Main {

    public static void main(String[] args) throws SQLException {
        String hostname = "localhost:3306";
        String database = "bookish";
        String user = "root";
        String password = System.getenv("SQLPW");
        String connectionString = "jdbc:mysql://" + hostname + "/" + database + "?user=" + user + "&password=" + password + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT&useSSL=false";

//        jdbcMethod(connectionString);
        jdbiMethod(connectionString);
    }

    private static void jdbcMethod(String connectionString) throws SQLException {
        System.out.println("JDBC method...");

        // TODO: print out the details of all the books (using JDBC)
        // See this page for details: https://docs.oracle.com/javase/tutorial/jdbc/basics/processingsqlstatements.html

        Connection connection = DriverManager.getConnection(connectionString);



    }

    private static void jdbiMethod(String connectionString) {
        System.out.println("\nJDBI method...");

        Jdbi jdbi = Jdbi.create(connectionString);

        List<String> names = jdbi.withHandle(handle ->
                handle.createQuery("select Name from book")
                        .mapTo(String.class)
                        .list());
        System.out.println(names);
    }
}
