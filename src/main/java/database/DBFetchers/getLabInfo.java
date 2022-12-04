package database.DBFetchers;

import database.DBConnectors.SqlSearchConnection;
import database.DBConnectors.getConnection;
import hospital.Lab.LabRequest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class getLabInfo {
    public static int getTestID(String test_name) throws SQLException {
        String query = "SELECT test_id from hospital.lab_test where test_name = ?";
        PreparedStatement ps = getConnection.getStatement(query);
        ps.setString(1,test_name);
        ResultSet data = SqlSearchConnection.execute(ps);
        data.absolute(1);
        int test_id = data.getInt("test_id");
        data.close();
        ps.close();
        return test_id;
    }

//    public static LabRequest[] getLabRequests(String Specialization){
//        //String query = ""
//    }


}
