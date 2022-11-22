package hospital.Staff;

import database.DBConnectors.SqlInsertUpdateConnection;
import database.DBConnectors.getConnection;
import hospital.Patient.Patient;
import hospital.Patient.PatientReport;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Reception extends Staff{
    public Reception(String fname, String lname,int id, long number, int DOB, int department) {
        super(fname,lname, id, number, DOB,department);
    }

    public boolean createNewPatient(Patient patient) throws SQLException {
        String query="INSERT INTO 'hospital'.'patient' (`fname`, `lname`, `patient_DOB`, `gender`, `contact_no`, `email`, `stat`) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement ps = getConnection.getStatement(query);
        assert ps != null;
        ps.setString(1,patient.getFname());
        ps.setString(2,patient.getLname());
        ps.setDate(3,patient.getDOB());
        ps.setString(4,patient.getGender());
        ps.setLong(5,patient.getContact_no());
        ps.setString(6,patient.getEmail());
        ps.setString(7,"opd");
        return SqlInsertUpdateConnection.execute(ps);
    }

    public boolean editPatientDetails(Patient pat) throws SQLException {
        String query="UPDATE hospital.patient SET fname=? ,lname=? ,patient_DOB=? ,contact_no=? ,email=? ,stat=? WHERE (patient_id=?)";
        PreparedStatement ps=getConnection.getStatement(query);
        assert  ps!=null;
        ps.setString(1,pat.getFname());
        ps.setString(2,pat.getLname());
        ps.setDate(3,pat.getDOB());
        ps.setLong(4,pat.getContact_no());
        ps.setString(5,pat.getEmail());
        ps.setString(6,pat.getStatus());
        ps.setLong(7,pat.getPatient_id());
        return SqlInsertUpdateConnection.execute(ps);
    }

    public boolean createNewReport(PatientReport report) throws SQLException {
        String query="INSERT INTO reports.patient_reports (`patient_id`, `department_id`, `startdate`) VALUES (?,?,?)";
        PreparedStatement ps=getConnection.getStatement(query);
        ps.setLong(1,report.patient.getPatient_id());
        ps.setLong(2,report.getDepartment_id());
        ps.setDate(3,report.getStart_date());
        return SqlInsertUpdateConnection.execute(ps);
    }

}
