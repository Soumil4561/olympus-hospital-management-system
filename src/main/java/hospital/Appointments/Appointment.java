package hospital.Appointments;

import database.DBConnectors.SqlInsertUpdateConnection;
import database.DBConnectors.getConnection;
import hospital.Patient.Patient;
import hospital.Patient.PatientReport;
import hospital.Staff.Doctor;
import database.DBFetchers.getAppointmentInfo;

import java.sql.*;

public class Appointment {
    private long appointment_id;
    private Date appointment_date;
    private Time appointment_time;
    private Patient patient;
    private Doctor doctor;
    private PatientReport report;
    private String Diagnosis;
    private String Remarks;

    public Appointment(Patient pat,Date appointment_date,Time appointment_time,PatientReport report){
        this.patient=pat;
        this.appointment_date=appointment_date;
        this.appointment_time=appointment_time;
        this.report=report;
    }

    public boolean createNewAppointment() throws SQLException {
        String query="INSERT INTO hospital.appointments (`patient_id`, `staff_id`, `report_id`, `appointment_date`, `appointment_time`) VALUES (?,?,?,?,?)";
        PreparedStatement ps = getConnection.getStatement(query);
        ps.setLong(1,patient.getPatient_id());
        ps.setLong(2,51163);
        ps.setLong(3,report.getReport_id());
        ps.setDate(4,appointment_date);
        ps.setTime(5,appointment_time);
        return SqlInsertUpdateConnection.execute(ps);
    }
}
