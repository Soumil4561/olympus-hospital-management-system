package hospital.Patient;

import java.sql.Date;

public class PatientReportView {
    private long report_id;
    private String doctor_name;
    private String department_name;
    private Date start_date;
    private long staff_id;

    public PatientReportView(long report_id, String doctor_name, String department_name, Date start_date, long staff_id) {
        this.report_id = report_id;
        this.doctor_name = doctor_name;
        this.department_name = department_name;
        this.start_date = start_date;
        this.staff_id = staff_id;
    }

    public PatientReportView(long report_id, String doctor_name, String department_name, Date start_date) {
        this.report_id = report_id;
        this.doctor_name = doctor_name;
        this.department_name = department_name;
        this.start_date = start_date;
    }

    public long getReport_id() {
        return report_id;
    }

    public void setReport_id(long report_id) {
        this.report_id = report_id;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public long getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(long staff_id) {
        this.staff_id = staff_id;
    }
}
