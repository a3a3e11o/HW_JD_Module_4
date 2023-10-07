package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String url = "jdbc:postgresql://localhost:5432/megasoft";
    private static final String user = "postgres";
    private static final String password = "123";
    private static final Database INSTANCE = new Database();
    private static Connection connection;

    private Database() {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch(SQLException e) {
            System.out.printf("Can't create connection. Reason: %s%n", e.getMessage());
            throw new RuntimeException("Can't create connection.");
        }
    }

    public static Database getInstance() {
        return INSTANCE;
    }

    public static Connection getConnection() {
        return connection;
    }
}
