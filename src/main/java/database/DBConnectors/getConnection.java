package database.DBConnectors;

import ssh.sshConnect;

import java.sql.*;

public class getConnection {
    public static PreparedStatement getStatement(String query) throws SQLException {
        Connection connection=null;
        try{
            sshConnect.listFolderStructure("DELL","Kashyap@123","192.168.1.73",22);
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionSting = "jdbc:mysql://192.168.1.73:3306";
            connection= DriverManager.getConnection(connectionSting, "soumil", "soumil");
            return connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        }
        catch (ClassNotFoundException e) {
            System.out.println("Problem connecting to server! Please try later or contact Admin.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
