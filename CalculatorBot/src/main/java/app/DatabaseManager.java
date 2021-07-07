package app;

import java.sql.*;

public class DatabaseManager {
    private static final String insertQuery = "INSERT INTO calculator_logs(date, userId, user, request_string, response_string) VALUES (?, ?, ?, ?, ?)";
    private static final String selectQuery = "SELECT * FROM calculator_logs";

    private static final DatabaseInitializer initializer = new DatabaseInitializer();
    private static final Connection connection = initializer.getConnection();

    public static void insertData(String date, long userId, String username, String request, String response) {
        try {
            PreparedStatement statement = connection.prepareStatement(insertQuery);
            statement.setString(1, date);
            statement.setLong(2, userId);
            statement.setString(3, username);
            statement.setString(4, request);
            statement.setString(5, response);

            statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void getAllData() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()) {
                System.out.println(String.format("%s   %d   %s   %s   %s",
                        resultSet.getString(1),
                        resultSet.getInt(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
