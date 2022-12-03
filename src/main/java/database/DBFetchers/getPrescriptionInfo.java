package database.DBFetchers;

import database.DBConnectors.SqlSearchConnection;
import database.DBConnectors.getConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class getPrescriptionInfo {
    public static long findPrescriptionID(long patient_id, String prescription) throws SQLException {
        String query = "Select `prescription_id` from hospital.prescription where patient_id = ? and prescription = ?";
        PreparedStatement ps= getConnection.getStatement(query);
        ps.setLong(1,patient_id);
        ps.setString(2,prescription);
        ResultSet data = SqlSearchConnection.execute(ps);
        data.absolute(1);
        long prescription_id = data.getLong("prescription_id");
        data.close();
        ps.close();
        return prescription_id;
    }
}
