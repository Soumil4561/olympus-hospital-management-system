package database.DBFetchers;

import database.DBConnectors.SqlSearchConnection;
import database.DBConnectors.getConnection;
import hospital.Bed.Bed;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static database.DBFetchers.ResultsetFunctions.size;

public class getBedInfo {
    public static Bed[] emptyBeds() throws SQLException {
        String query = "SELECT bed_id, beds.department_id ,dept_name from hospital.beds " +
                "join hospital.departments on departments.department_id =beds.department_id " +
                "where stat=0";
        PreparedStatement ps = getConnection.getStatement(query);
        ResultSet data = SqlSearchConnection.execute(ps);
        Bed[] emptyBeds = new Bed[size(data)];
        int counter = 0;
        while(data.next()){
            long bed_id = data.getLong("bed_id");
            long department_id = data.getLong("department_id");
            String dept_name = data.getString("dept_name");
            emptyBeds[counter++]=new Bed(bed_id,department_id,dept_name);
        }
        data.close();
        ps.close();
        return emptyBeds;
    }
}
