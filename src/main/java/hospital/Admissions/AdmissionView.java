package hospital.Admissions;

import java.sql.Date;

public class AdmissionView {
    private long admission_id;
    private long patient_id;
    private String patient_name;
    private String doctor_name;
    private long bed_id;
    private Date admission_date;

    private long report_id;

    public AdmissionView(long admission_id, long patient_id, String patient_name, String doctor_name, long bed_id, Date admission_date, long report_id) {
        this.admission_id = admission_id;
        this.patient_id = patient_id;
        this.patient_name = patient_name;
        this.doctor_name = doctor_name;
        this.bed_id = bed_id;
        this.admission_date = admission_date;
        this.report_id = report_id;
    }

    public long getAdmission_id() {
        return admission_id;
    }

    public long getPatient_id() {
        return patient_id;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public long getBed_id() {
        return bed_id;
    }

    public Date getAdmission_date() {
        return admission_date;
    }

    public long getReport_id() {
        return report_id;
    }
}


