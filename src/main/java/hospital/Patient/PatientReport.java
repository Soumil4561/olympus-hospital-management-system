package hospital.Patient;

import database.DBConnectors.SqlInsertUpdateConnection;
import database.DBConnectors.getConnection;
import hospital.Department.Department;
import hospital.Staff.Doctor;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PatientReport {
    public long report_id;
    public Patient patient;
    public Doctor doctor;
    private long department_id;
    private Date start_date;
    private Date end_date;
    private String remarks;

    public PatientReport(Patient patient, String department_name) throws SQLException {
        this.patient=patient;
        this.department_id= Department.getDepartment_id(department_name);
        long millis=System.currentTimeMillis();
        this.start_date=new Date(millis);
    }

    public long getReport_id() {
        return report_id;
    }

    public boolean createNewReport() throws SQLException {
        String query="INSERT INTO reports.patient_reports (`patient_id`, `department_id`, `startdate`) VALUES (?,?,?)";
        //'"+patient.getPatient_id()+"','"+department_id+"','"+start_date+"'
        PreparedStatement ps=getConnection.getStatement(query);
        ps.setLong(1,patient.getPatient_id());
        ps.setLong(2,department_id);
        ps.setDate(3,start_date);
        return SqlInsertUpdateConnection.execute(ps);
    }

}
