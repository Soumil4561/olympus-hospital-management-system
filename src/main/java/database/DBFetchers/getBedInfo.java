package database.DBFetchers;

import database.DBConnectors.SqlSearchConnection;
import database.DBConnectors.getConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static database.DBFetchers.ResultsetFunctions.size;

public class getBedInfo {
    public static long[] emptyBeds() throws SQLException {
        String query = "SELECT bed_id from hospital.beds where stat=0";
        PreparedStatement ps = getConnection.getStatement(query);
        ResultSet data = SqlSearchConnection.execute(ps);
        long[] bed_ids = new long[size(data)];
        int counter = 0;
        while(data.next()){
            bed_ids[counter++]=data.getLong("bed_id");
        }
        data.close();
        ps.close();
        return bed_ids;
    }
}
