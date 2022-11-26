package hospital.Admissions;

import hospital.Bed.Bed;
import hospital.Patient.Patient;
import hospital.Staff.Doctor;

import java.sql.Date;

public class NewAdmission {
    public long patient_id;
    public long doctor_id;
    public long report_id;
    public long bed_id;
    public Date date;

    public long getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(long patient_id) {
        this.patient_id = patient_id;
    }

    public long getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(long doctor_id) {
        this.doctor_id = doctor_id;
    }

    public long getReport_id() {
        return report_id;
    }

    public void setReport_id(long report_id) {
        this.report_id = report_id;
    }

    public long getBed_id() {
        return bed_id;
    }

    public void setBed_id(long bed_id) {
        this.bed_id = bed_id;
    }

    public NewAdmission(long patient_id, long doctor_id, long report_id, long bed_id, Date date) {
        this.patient_id = patient_id;
        this.doctor_id = doctor_id;
        this.report_id = report_id;
        this.bed_id = bed_id;
        this.date=date;
    }

    public NewAdmission(long patient_id, long doctor_id, long report_id, long bed_id) {
        this.patient_id = patient_id;
        this.doctor_id = doctor_id;
        this.report_id = report_id;
        this.bed_id = bed_id;
        long millis=System.currentTimeMillis();
        this.date=new Date(millis);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
