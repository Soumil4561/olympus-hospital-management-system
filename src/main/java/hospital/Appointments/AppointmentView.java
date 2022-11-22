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

    public String status;

    public AppointmentView(long appointment_id, String patient_name, String doctor_name, long report_id, Date date, Time time,String status) {
        this.appointment_id = appointment_id;
        this.patient_name = patient_name;
        this.doctor_name = doctor_name;
        this.report_id = report_id;
        this.date = date;
        this.time = time;
        this.status=status;
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
}
