package hospital.Appointments;

import database.DBConnectors.SqlInsertUpdateConnection;
import hospital.Patient.Patient;
import hospital.Patient.PatientReport;
import hospital.Staff.Doctor;
import database.DBFetchers.getAppointmentInfo;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

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
        String query="INSERT INTO appointments (`patient_id`, `staff_id`, `report_id`, `appointment_date`, `appointment_time`) VALUES " +
                "('"+patient.getPatient_id()+"','"+doctor.getStaff_id()+"','"+report.getReport_id()+"','"+appointment_date+"','"+appointment_time+"')";
        SqlInsertUpdateConnection.connect(query);
        return true;
    }
}
