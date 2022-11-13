package database.DBConnectors;

import java.sql.*;

public class SqlSearchConnection {
    public static ResultSet connect(String query) throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionSting = "jdbc:mysql://localhost:3306/hospital";
            connection = DriverManager.getConnection(connectionSting, "root", "Preretcon$%4561");
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet data = statement.executeQuery(query);
            return data;
        }
        catch (ClassNotFoundException e) {
            System.out.println("Uh-oh! Something happened! logging error");
        }
        return null;
    }
}
