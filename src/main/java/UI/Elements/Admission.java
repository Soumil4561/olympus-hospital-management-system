package UI.Elements;

import java.sql.Date;

public class Admission {
    private String patientName,DIC;
    private Long admissionID,patientID,bedID;
    private Date date;

    public Admission(){
        this.admissionID=0L;
        this.bedID=0L;
        this.patientID=0L;
        this.patientName=null;
        this.DIC=null;
        this.date=null;
    }

    public Admission(String patientName, String DIC, Long admissionID, Long patientID, Long bedID, Date date){
        this.admissionID=admissionID;
        this.bedID=bedID;
        this.patientID=patientID;
        this.patientName=patientName;
        this.DIC=DIC;
        this.date=date;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDIC() {
        return DIC;
    }

    public void setDIC(String DIC) {
        this.DIC = DIC;
    }

    public Long getAdmissionID() {
        return admissionID;
    }

    public void setAdmissionID(Long admissionID) {
        this.admissionID = admissionID;
    }

    public Long getPatientID() {
        return patientID;
    }

    public void setPatientID(Long patientID) {
        this.patientID = patientID;
    }

    public Long getBedID() {
        return bedID;
    }

    public void setBedID(Long bedID) {
        this.bedID = bedID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
