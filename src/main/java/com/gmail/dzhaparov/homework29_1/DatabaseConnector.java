package com.gmail.dzhaparov.homework29_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnector {

    private Connection connection;

    public void initializeDatabase() {
        try (Statement statement = connection.createStatement()) {

            String createUserTable = "CREATE TABLE IF NOT EXISTS employees (" +
                    "id SERIAL PRIMARY KEY, " +
                    "name VARCHAR(100) NOT NULL, " +
                    "age INTEGER NOT NULL, " +
                    "position VARCHAR(64) NOT NULL, " +
                    "salary FLOAT8 NOT NULL );";

            statement.executeUpdate(createUserTable);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void connectDatabase() {
        try {
            connection = DriverManager.getConnection(DBPropetries.URL, DBPropetries.USER, DBPropetries.PASSWORD);
            System.out.println("Connected to database");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void disconnectDatabase()  {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public Connection getConnection() {
        return connection;
    }
}
