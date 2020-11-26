package org.softwire.training.bookish;

import org.jdbi.v3.core.Jdbi;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        String hostname = "localhost:3306";
        String database = "Bookish";
        String user = "root";
        String password = "Isobel";
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

        // TODO: print out the details of all the books (using JDBI)
        // See this page for details: http://jdbi.org
        // Use the "Book" class that we've created for you (in the models.database folder)

        Jdbi jdbi = Jdbi.create(connectionString);



    }
}
