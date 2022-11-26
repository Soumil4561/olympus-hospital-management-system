package hospital.Patient;

import hospital.Department.Department;
import hospital.Staff.Doctor;
import java.sql.Date;
import java.sql.SQLException;

public class PatientReport {
    public long report_id;
    public Patient patient;
    public long staff_id;
    private long department_id;
    private Date start_date;
    private Date end_date;
    private String remarks;


    public PatientReport(Patient patient, String department_name, long staff_id) throws SQLException {
        this.patient=patient;
        this.department_id= Department.getDepartment_id(department_name);
        this.staff_id=staff_id;
        long millis=System.currentTimeMillis();
        this.start_date=new Date(millis);
    }

    public PatientReport(long report_id, Patient patient, long staff_id) {
        this.report_id = report_id;
        this.patient = patient;
        //this.doctor = getDoctorInfo.searchDoctor;
    }

    public long getDepartment_id() {
        return department_id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public long getReport_id() {
        return report_id;
    }

    public Patient getPatient() {
        return patient;
    }

    public long getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(long staff_id) {
        this.staff_id = staff_id;
    }

    public void setDepartment_id(long department_id) {
        this.department_id = department_id;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
