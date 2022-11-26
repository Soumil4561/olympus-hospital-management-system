package hospital.Staff;

import database.DBConnectors.SqlInsertUpdateConnection;
import database.DBConnectors.getConnection;
import database.DBFetchers.getReportInfo;
import database.FileWriter.PatientFile;
import hospital.Patient.Patient;
import hospital.Patient.PatientReport;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Reception extends Staff{
    public Reception(long id, String fname, String lname, String gender, long number, Date DOB, int department, String email, String residential_address) {
        super(id, fname, lname, gender, number, DOB, department, email, residential_address);
    }

    public static boolean createNewPatient(Patient patient) throws SQLException {
        String query="INSERT INTO `hospital`.`patient` (`fname`, `lname`, `patient_DOB`, `gender`, `contact_no`, `email`, `stat`) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement ps = getConnection.getStatement(query);
        assert ps != null;
        ps.setString(1,patient.getFname());
        ps.setString(2,patient.getLname());
        ps.setDate(3,patient.getDOB());
        ps.setString(4,patient.getGender());
        ps.setLong(5,patient.getContact_no());
        ps.setString(6,patient.getEmail());
        ps.setString(7,"OPD");
        return SqlInsertUpdateConnection.execute(ps);
    }

    public static boolean editPatientDetails(Patient pat) throws SQLException {
        //String query="UPDATE 'hospital'.'patient' SET 'fname' = ? , 'lname' = ? , 'patient_DOB' = ? , 'contact_no' = ? , 'email' = ? , 'stat' = ? WHERE (patient_id = ?)";
        String query="UPDATE `hospital`.`patient` SET `fname` = ?, `lname` = ?, `patient_DOB` = ?, `gender` = ?, `contact_no` = ?, `email` = ?, `stat` = ? WHERE (`patient_id` = ?)";
        PreparedStatement ps=getConnection.getStatement(query);
        assert  ps!=null;
        ps.setString(1,pat.getFname());
        ps.setString(2,pat.getLname());
        ps.setDate(3,pat.getDOB());
        ps.setString(4,pat.getGender());
        ps.setLong(5,pat.getContact_no());
        ps.setString(6,pat.getEmail());
        ps.setString(7,pat.getStatus());
        ps.setLong(8,pat.getPatient_id());
        return SqlInsertUpdateConnection.execute(ps);
    }

    public static boolean createNewReport(PatientReport report) throws SQLException, IOException {
        String query="INSERT INTO hospital.patient_reports (`patient_id`, `department_id`, `startdate`) VALUES (?,?,?)";
        PreparedStatement ps=getConnection.getStatement(query);
        assert ps != null;
        ps.setLong(1,report.patient.getPatient_id());
        ps.setLong(2,report.getDepartment_id());
        ps.setDate(3,report.getStart_date());
        //SqlInsertUpdateConnection.execute(ps);
        long report_id = getReportInfo.findReportID(report.getPatient().getPatient_id(),report.getStart_date());
        createReportFile(report_id,report.getPatient());
        return true;
    }

    private static void createReportFile(long report_id, Patient patient) throws IOException {
        PatientFile.create(report_id);
        String text = "Report ID: "+report_id;
        PatientFile.append(report_id,text);
        text = "Patient ID: "+patient.getPatient_id();
        PatientFile.append(report_id,text);
        text = "Patient Name: "+patient.getFname()+" "+patient.getLname();
        PatientFile.append(report_id,text);
        text = "--------------------------------------";
        PatientFile.append(report_id,text);
    }



}
