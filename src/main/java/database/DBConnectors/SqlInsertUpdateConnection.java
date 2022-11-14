package database.DBConnectors;

import java.sql.*;

public class SqlInsertUpdateConnection {
    public static boolean connect(String query) throws SQLException{
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionSting = "jdbc:mysql://localhost:3306/hospital";
            connection = DriverManager.getConnection(connectionSting, "root", "Preretcon$%4561");
            Statement statement = connection.createStatement();
            statement.execute(query);
            return true;
        }
        catch (SQLException | ClassNotFoundException e) {
            System.out.println("Can't update database.Logging error. Please try again.");
        }
        return false;
    }
}
