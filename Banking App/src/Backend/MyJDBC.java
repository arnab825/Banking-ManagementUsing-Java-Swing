package Backend;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class MyJDBC {
    // database configurations
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/bankingapplication_schema";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "1234";

    // if valid return an object with the user's information
    public static User validateLogin(String username, String password) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users WHERE username = ?"
            );
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Validate password
                String storedPassword = resultSet.getString("password");
                if (password.equals(storedPassword)) {
                    int userId = resultSet.getInt("id");
                    BigDecimal currentBalance = resultSet.getBigDecimal("current_balance");
                    return new User(userId, username, storedPassword, currentBalance);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error connecting to the database: " + e.getMessage());
        }




        return null;
    }
}
