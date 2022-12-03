package hospital.Appointments;

import java.sql.Date;
import java.sql.Time;

public class AppointmentView {
    public long appointment_id;
    public String patient_name;
    public String doctor_name;
    public long report_id;
    public Date date;
    public Time time;
    public long patient_id;

    public String status;

    public AppointmentView(long appointment_id, String patient_name, String doctor_name, long report_id, Date date, Time time,String status,long patient_id) {
        this.appointment_id = appointment_id;
        this.patient_name = patient_name;
        this.doctor_name = doctor_name;
        this.report_id = report_id;
        this.date = date;
        this.time = time;
        this.status=status;
        this.patient_id=patient_id;
    }

    public long getAppointment_id() {
        return appointment_id;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public long getReport_id() {
        return report_id;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public void setAppointment_id(long appointment_id) {
        this.appointment_id = appointment_id;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public void setReport_id(long report_id) {
        this.report_id = report_id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public long getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(long patient_id) {
        this.patient_id = patient_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
