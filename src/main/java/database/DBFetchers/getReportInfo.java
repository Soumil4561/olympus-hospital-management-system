package database.DBFetchers;

import database.DBConnectors.SqlSearchConnection;
import database.DBConnectors.getConnection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static database.DBFetchers.ResultsetFunctions.size;

public class getReportInfo {
    public static long findReportID(long patient_id, Date start_date) throws SQLException {
        String query="SELECT report_id FROM hospital.patient_reports where  patient_id = ? AND startdate = ? AND end_date IS NULL";
        PreparedStatement ps = getConnection.getStatement(query);
        ps.setLong(1,patient_id);
        ps.setDate(2,start_date);
        ResultSet data = SqlSearchConnection.execute(ps);
        assert data != null;
        data.absolute(1);
        long report_id=data.getLong("report_id");
        data.close();
        return report_id;
    }
}
