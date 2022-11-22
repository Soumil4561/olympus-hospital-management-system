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

    public long getDepartment_id() {
        return department_id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public long getReport_id() {
        return report_id;
    }



}
