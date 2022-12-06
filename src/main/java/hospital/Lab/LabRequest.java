package hospital.Lab;

import database.DBFetchers.getLabInfo;

import java.sql.SQLException;

public class LabRequest {
    private long record_id;
    private long patient_id;
    private String patient_name;
    private long staff_id;
    private String doctor_name;
    private long report_id;

    private String remarks;

    private long test_id;
    private String test_name;

    public LabRequest(long record_id, long patient_id, String patient_name, long staff_id, String doctor_name, long report_id, String remarks,long test_id, String test_name) {
        this.record_id = record_id;
        this.patient_id = patient_id;
        this.patient_name = patient_name;
        this.staff_id = staff_id;
        this.doctor_name = doctor_name;
        this.report_id = report_id;
        this.remarks = remarks;
        this.test_id = test_id;
        this.test_name=test_name;
    }

    public long getRecord_id() {
        return record_id;
    }

    public void setRecord_id(long record_id) {
        this.record_id = record_id;
    }

    public long getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(long patient_id) {
        this.patient_id = patient_id;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public long getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(long staff_id) {
        this.staff_id = staff_id;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public long getReport_id() {
        return report_id;
    }

    public void setReport_id(long report_id) {
        this.report_id = report_id;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public long getTest_id() {
        return test_id;
    }

    public void setTest_id(long test_id) {
        this.test_id = test_id;
    }

    public String getTest_name() {
        return test_name;
    }

    public void setTest_name(String test_name) {
        this.test_name = test_name;
    }
}
