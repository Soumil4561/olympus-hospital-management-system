package hospital.Pateint;

import database.DBConnectors.SqlInsertConnection;
import hospital.Department.Department;
import hospital.Staff.Doctor;

import java.sql.Date;
import java.sql.SQLException;

public class PatientReport {
    public long report_id;
    public Patient patient;
    public Doctor doctor;
    public long department_id;
    public Date start_date;
    public Date end_date;
    public String remarks;

    public PatientReport(Patient patient, String department_name) throws SQLException {
        this.patient=patient;
        this.department_id= Department.getDepartment_id(department_name);
        long millis=System.currentTimeMillis();
        this.start_date=new Date(millis);
    }

    public boolean createNewReport() throws SQLException {
        String query="INSERT INTO patient_reports (`patient_id`, `department_id`, `startdate`) VALUES ('"+patient.getPatient_id()+"','"+department_id+"','"+start_date+"')";
        return SqlInsertConnection.connect(query);
    }

}
