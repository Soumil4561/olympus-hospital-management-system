package UI.Elements;

import java.sql.Date;

public class Admission {
    private String name,DIC;
    private long admissionID,patientID,bedID,reportID;
    private Date date;

    public Admission(){
        this.admissionID=0L;
        this.bedID=0L;
        this.patientID=0L;
        this.name=null;
        this.DIC=null;
        this.date=null;
        this.reportID=0L;
    }

    public Admission(String name, String DIC, long admissionID, long reportID, long patientID, long bedID, Date date){
        this.admissionID=admissionID;
        this.bedID=bedID;
        this.patientID=patientID;
        this.name=name;
        this.DIC=DIC;
        this.date=date;
        this.reportID=reportID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDIC() {
        return DIC;
    }

    public void setDIC(String DIC) {
        this.DIC = DIC;
    }

    public long getAdmissionID() {
        return admissionID;
    }

    public void setAdmissionID(long admissionID) {
        this.admissionID = admissionID;
    }

    public long getPatientID() {
        return patientID;
    }

    public void setPatientID(long patientID) {
        this.patientID = patientID;
    }

    public long getBedID() {
        return bedID;
    }

    public void setBedID(long bedID) {
        this.bedID = bedID;
    }

    public long getReportID() {
        return reportID;
    }

    public void setReportID(long reportID) {
        this.reportID = reportID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
