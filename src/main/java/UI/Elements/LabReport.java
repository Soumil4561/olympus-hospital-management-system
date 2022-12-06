package UI.Elements;

import database.DBFetchers.getLabInfo;

import java.sql.SQLException;

public class LabReport {
    private String remarks, test;
    private long patientID, reportID, staffID, testID;

    public LabReport(String remarks, String test, long patientID, long reportID, long staffID, long testID) {
        this.remarks = remarks;
        this.test = test;
        this.patientID = patientID;
        this.reportID = reportID;
        this.staffID = staffID;
        this.testID = testID;
    }

    public LabReport() {
        this.remarks = null;
        this.test = null;
        this.patientID = 0L;
        this.reportID = 0L;
        this.staffID = 0L;
        this.testID = 0L;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public long getPatientID() {
        return patientID;
    }

    public void setPatientID(long patientID) {
        this.patientID = patientID;
    }

    public long getReportID() {
        return reportID;
    }

    public void setReportID(long reportID) {
        this.reportID = reportID;
    }

    public long getStaffID() {
        return staffID;
    }

    public void setStaffID(long staffID) {
        this.staffID = staffID;
    }

    public long getTestID() {
        return testID;
    }

    public void setTestID(long testID) {
        this.testID = testID;
    }

}
