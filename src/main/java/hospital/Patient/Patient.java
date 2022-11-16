package hospital.Patient;

import database.DBConnectors.SqlInsertUpdateConnection;

import java.sql.Date;
import java.sql.SQLException;

public class Patient {
    private long patient_id;
    private String fname;
    private String lname;
    private Date DOB;
    private String gender;
    private long contact_no;
    private String email;
    private String status;


    public Patient(long id, String fname,String lname,Date DOB,String gender,long contact_no,String email){
        this.patient_id=id;
        this.fname=fname;
        this.lname=lname;
        this.DOB=DOB;
        this.gender=gender;
        this.contact_no=contact_no;
        this.email=email;
    }

    public long getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(long patient_id) {
        this.patient_id = patient_id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getContact_no() {
        return contact_no;
    }

    public void setContact_no(long contact_no) {
        this.contact_no = contact_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean createNewPatient() throws SQLException {
        String query="INSERT INTO patient VALUES ('"+getPatient_id()+"','"+getFname()+"','"+getLname()+"','"+getDOB()+"','"+getGender()+"','"+getContact_no()+"','"+getEmail()+"','opd')";
        System.out.println(query);
        return SqlInsertUpdateConnection.connect(query);
    }

    public boolean editPatientDetails(Patient pat) throws SQLException {
        String query="UPDATE patient SET fname='"+pat.getFname()+"',lname='"+pat.getLname()+"',patient_DOB='"+pat.getDOB()+"',contact_no='"+pat.getContact_no()+"',email='"+pat.getEmail()+"',stat='"+getStatus()+"' WHERE (patient_id='"+pat.getPatient_id()+"')";
        return SqlInsertUpdateConnection.connect(query);
    }

}
