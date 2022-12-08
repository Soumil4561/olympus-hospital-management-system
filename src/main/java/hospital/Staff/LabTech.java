package hospital.Staff;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import database.DBConnectors.getConnection;
import database.DBFetchers.getLabInfo;
import database.FileWriter.ReportGenerator;
import hospital.Lab.LabRequest;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

public class LabTech extends Staff{

    private long test_id;

    public LabTech(long id, String fname, String lname, String gender, long number, Date DOB, long department, String email, String residential_address, long test_id) {
        super(id, fname, lname, gender, number, DOB, department, email, residential_address);
        this.test_id = test_id;
    }

    public LabTech(long id, String fname, String lname, String gender, long number, Date DOB, long department, String email, String residential_address, String type, long test_id) {
        super(id, fname, lname, gender, number, DOB, department, email, residential_address, type);
        this.test_id = test_id;
    }

    public void addReport(long test_id, long report_id) throws SQLException, JSchException, SftpException, IOException {
        String test_name = getLabInfo.getTestName(test_id);
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        Time time = new Time(millis);
        String type = "LabReport";
        String text= date.toString()+"~"+time.toString()+"~"+type+"~"+test_name+"created and stored.";
        ReportGenerator.append(report_id,text);

        String query = "INSERT INTO `hospital`.`lab_records` (`patient_id`, `test_id`, `staff_id`, `test_date`, `test_time`, `report_id`) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = getConnection.getStatement(query);
        //ps.setLong(1,patient_id);
        ps.setLong(2,test_id);
        ps.setLong(3,staff_id);
        ps.setDate(4,date);
        ps.setTime(5,time);
        ps.setLong(6,report_id);

    }


}
