package database.DBFetchers;

import database.DBConnectors.SqlSearchConnection;
import database.DBConnectors.getConnection;
import hospital.Patient.PatientReport;
import hospital.Patient.PatientReportView;

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

    public static PatientReportView[] searchPatientReports(long patient_id) throws SQLException {
        String query="Select report_id, staff.staff_id, Concat(staff.fname,' ', staff.lname) as doctor_name, "+
                "dept_name, startdate from hospital.patient_reports " +
                "join hospital.staff on patient_reports.staff_id = staff.staff_id " +
                "join hospital.departments on patient_reports.department_id = departments.department_id " +
                "where patient_reports.patient_id = ? and end_date IS NULL";
        PreparedStatement ps = getConnection.getStatement(query);
        ps.setLong(1,patient_id);
        ResultSet data = SqlSearchConnection.execute(ps);
        assert data!=null;
        PatientReportView[] reports = new PatientReportView[size(data)];
        int counter=0;
        while(data.next()){
            long report_id = data.getLong("report_id");
            String doctor_name = data.getString("doctor_name");
            String department_name = data.getString("dept_name");
            Date date = data.getDate("startdate");
            long staff_id = data.getLong("staff_id");
            reports[counter++] = new PatientReportView(report_id,doctor_name,department_name,date,staff_id);
        }
        data.close();
        ps.close();
        return reports;
    }
}
