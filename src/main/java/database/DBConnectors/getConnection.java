package database.DBConnectors;

import java.sql.*;

public class getConnection {
    public static PreparedStatement getStatement(String query) throws SQLException {
        Connection connection=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionSting = "jdbc:mysql://localhost:3306";
            connection= DriverManager.getConnection(connectionSting, "root", "Preretcon$%4561");
            return connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        }
        catch (ClassNotFoundException e) {
            System.out.println("Problem connecting to server! Please try later or contact Admin.");
        }
        return null;
    }
}
