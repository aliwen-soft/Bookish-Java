package org.softwire.training.bookish.services;

import org.jdbi.v3.core.Jdbi;

public abstract class DatabaseService {

    private final String hostname = System.getenv("SQLHOST");
    private final String database = "bookish";
    private final String user = System.getenv("SQLUSER");
    private final String password = System.getenv("SQLPW");
    private final String connectionString = "jdbc:mysql://" + hostname + "/" + database + "?user=" + user + "&password=" + password + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT&useSSL=false";

    protected final Jdbi jdbi = Jdbi.create(connectionString);
}
