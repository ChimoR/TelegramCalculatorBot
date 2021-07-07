package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {
    Connection connection = null;
    String url = "jdbc:sqlite:calculator_logs.sqlite";

    String createQuery = "CREATE TABLE IF NOT EXISTS calculator_logs (date, userId , user, request_string, response_string)";

    public Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url);
                Statement statement = connection.createStatement();
                statement.execute(createQuery);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return connection;
    }
}
