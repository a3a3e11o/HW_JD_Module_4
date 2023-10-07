package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {
    public static void main(String[] args) {
        Connection conn = Database.getInstance().getConnection();

        if (conn != null) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader("sql/init_db.sql"));
                String line;
                StringBuilder sqlStatement = new StringBuilder();

                Statement statement = conn.createStatement();

                while ((line = reader.readLine()) != null) {
                    sqlStatement.append(line);

                    if (line.trim().endsWith(";")) {
                        statement.execute(sqlStatement.toString());
                        sqlStatement.setLength(0);
                    }
                }

                reader.close();
                statement.close();
                conn.close();
                System.out.println("Database successfully initialized!");
            } catch (IOException | SQLException e) {
                System.out.printf("Database initialization error. Reason: %s%n", e.getMessage());
                throw new RuntimeException("Database initialization error.");
            }
        } else {
            System.out.println("Database connection error.");
        }
    }
}