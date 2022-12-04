package hospital.Bed;

import hospital.Patient.Patient;

public class Bed {
    private long bed_id;
    private Patient patient;
    private String status;

    private long department_id;

    private String dept_name;


    public Bed(long bed_id, long department_id, String dept_name) {
        this.bed_id = bed_id;
        this.department_id = department_id;
        this.dept_name = dept_name;
    }

    public long getBed_id() {
        return bed_id;
    }

    public void setBed_id(long bed_id) {
        this.bed_id = bed_id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(long department_id) {
        this.department_id = department_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }
}
