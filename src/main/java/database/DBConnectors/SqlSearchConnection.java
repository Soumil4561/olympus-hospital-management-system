package database.DBConnectors;

import java.sql.*;

public class SqlSearchConnection {
    public static ResultSet execute(PreparedStatement ps) throws SQLException {
        Connection connection = null;
        try {
            ResultSet data=ps.executeQuery();
            return data;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
