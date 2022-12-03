package hospital.Staff;

import database.DBConnectors.SqlInsertUpdateConnection;
import database.DBConnectors.getConnection;
import database.DBFetchers.getReportInfo;
import database.FileWriter.ReportGenerator;
import hospital.Admissions.NewAdmission;
import hospital.Patient.Patient;
import hospital.Patient.PatientReport;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.sql.*;

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
        String query="INSERT INTO hospital.patient_reports (`patient_id`, `staff_id`, `department_id`, `startdate`) VALUES (?,?,?,?)";
        PreparedStatement ps=getConnection.getStatement(query);
        assert ps != null;
        ps.setLong(1,report.patient.getPatient_id());
        ps.setLong(2, report.getStaff_id());
        ps.setLong(3,report.getDepartment_id());
        ps.setDate(4,report.getStart_date());
        SqlInsertUpdateConnection.execute(ps);
        long report_id = getReportInfo.findReportID(report.getPatient().getPatient_id(),report.getStart_date());
        createReportFile(report_id,report.getPatient(),report.getStart_date());
        return true;
    }

    private static void createReportFile(long report_id, Patient patient,Date start_date) throws IOException {
        ReportGenerator.create(report_id);
        long millis = System.currentTimeMillis();
        Time time = new  Time(millis);
        String text = "Report ID: "+report_id+
                "\nPatient ID: "+patient.getPatient_id()
                +"\nPatient Name: "+patient.getFname()+" "+patient.getLname()
                + "\n--------------------------------------"
                +"\n"+start_date+"~"+time.toString()+"~Report Created~-";
        ReportGenerator.append(report_id,text);
    }

    public static boolean createNewAdmission(NewAdmission admission) throws SQLException {
        String query = "INSERT INTO `hospital`.`admission` (`patient_id`, `report_id`, `staff_id`, `bed_id`, `admission_date`) VALUES (?,?,?,?,?)";
        PreparedStatement ps = getConnection.getStatement(query);
        ps.setLong(1,admission.getPatient_id());
        ps.setLong(2,admission.getReport_id());
        ps.setLong(3,admission.getDoctor_id());
        ps.setLong(4,admission.getBed_id());
        ps.setDate(5,admission.getDate());
        try{
            SqlInsertUpdateConnection.execute(ps);
        }
        catch (SQLException e) {
            return false;
        }
        query = "UPDATE `hospital`.`patient` SET `stat` = 'IPD' WHERE (`patient_id` = ? )";
        ps = getConnection.getStatement(query);
        ps.setLong(1,admission.getPatient_id());
        SqlInsertUpdateConnection.execute(ps);
        return true;
    }



}
