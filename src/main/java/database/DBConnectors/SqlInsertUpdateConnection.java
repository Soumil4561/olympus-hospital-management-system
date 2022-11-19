package database.DBConnectors;

import java.sql.*;

public class SqlInsertUpdateConnection {
    public static boolean execute(PreparedStatement ps) throws SQLException{
        try {
            ps.execute();
            ps.close();
            return true;
        }
        catch ( SQLException e) {
            e.printStackTrace();
            System.out.println("Can't update database.Logging error. Please try again.");
        }
        return false;
    }
}
