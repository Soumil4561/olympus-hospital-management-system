package hospital.Appointments;

import database.DBConnectors.SqlInsertUpdateConnection;
import database.DBConnectors.getConnection;
import hospital.Patient.Patient;

import java.sql.*;

public class NewAppointment {
    private Date appointment_date;
    private Time appointment_time;
    private Patient patient;
    private long report_id;
    private long staff_id;

    public NewAppointment(Patient pat, Date appointment_date, Time appointment_time, long report_id, long staff_id){
        this.patient=pat;
        this.appointment_date=appointment_date;
        this.appointment_time=appointment_time;
        this.report_id=report_id;
        this.staff_id = staff_id;
    }

    public boolean createNewAppointment() throws SQLException {
        String query="INSERT INTO hospital.appointments (`patient_id`, `staff_id`, `report_id`, `appointment_date`, `appointment_time`, `status`) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = getConnection.getStatement(query);
        ps.setLong(1,patient.getPatient_id());
        ps.setLong(2,staff_id);
        ps.setLong(3,report_id);
        ps.setDate(4,appointment_date);
        ps.setTime(5,appointment_time);
        ps.setString(6,"");
        return SqlInsertUpdateConnection.execute(ps);
    }
}
