package hospital.Staff;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import database.DBConnectors.SqlInsertUpdateConnection;
import database.DBConnectors.SqlSearchConnection;
import database.DBConnectors.getConnection;
import database.DBFetchers.getPrescriptionInfo;
import database.DBFetchers.getLabInfo;
import database.FileWriter.ReportGenerator;
import hospital.Patient.PatientFile;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;



public class Doctor extends Staff{

    public Doctor(long id, String fname, String lname, String gender, long number, Date DOB, int department, String email, String residential_address) {
        super(id, fname, lname, gender, number, DOB, department, email, residential_address);
    }

    public static boolean updateReport(long report_id, PatientFile.Node node) throws IOException {
        String text = node.getDate()+"~"+node.getTime()+"~"+node.getType()+"~"+node.getDescription();
        try{
            ReportGenerator.append(report_id,text);
        }
        catch (IOException e){
            UI.Elements.PopUpBox.displayAlert("Error","Cannot update Report. Please try again later.");
        } catch (JSchException e) {
            throw new RuntimeException(e);
        } catch (SftpException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    public static boolean createPrescription(String prescription,long patient_id,long staff_id, long report_id) throws IOException, SQLException {
        long millis = System.currentTimeMillis();
        Time time = new  Time(millis);
        Date date= new Date(millis);
        String query = "INSERT INTO `hospital`.`prescription` (`patient_id`, `staff_id`, `report_id`, `date_issued`, `prescription`)" +
                " VALUES (?,?,?,?,?)";
        PreparedStatement ps = getConnection.getStatement(query);
        ps.setLong(1,patient_id);
        ps.setLong(2,staff_id);
        ps.setLong(3,report_id);
        ps.setDate(4,date);
        ps.setString(5,prescription);
        SqlInsertUpdateConnection.execute(ps);

        query = "UPDATE `hospital`.`patient_reports` SET `prescription` = ? WHERE (`report_id` = ?)";
        ps=getConnection.getStatement(query);
        ps.setString(1,prescription);
        ps.setLong(2,report_id);
        SqlInsertUpdateConnection.execute(ps);
        ps.close();

        long prescription_id = getPrescriptionInfo.findPrescriptionID(patient_id,prescription);
        String text = date.toString()+"~"+time.toString()+"~"+"Prescription ID:"+ prescription_id+"~"+prescription;
        try{
            return ReportGenerator.append(report_id,text);
        }
        catch (IOException | JSchException | SftpException e){
            UI.Elements.PopUpBox.displayAlert("Error","Cannot update Report. Please try again later.");
        }
        return false;
    }


    public static boolean createLabRequest(long patient_id, long test_id, long staff_id, long report_id, String remarks) throws SQLException {
        String query = "INSERT INTO `hospital`.`lab_requests` (`patient_id`, `test_id`, `staff_id`, `report_id`,`remarks`) VALUES (?,?,?,?,?)";
        PreparedStatement ps = getConnection.getStatement(query);
        ps.setLong(1,patient_id);
        ps.setLong(2,test_id);
        ps.setLong(3,staff_id);
        ps.setLong(4,report_id);
        ps.setString(5,remarks);
        return SqlInsertUpdateConnection.execute(ps);
    }



}
