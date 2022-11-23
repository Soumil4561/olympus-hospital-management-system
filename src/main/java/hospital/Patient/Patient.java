package hospital.Patient;

import database.DBConnectors.SqlInsertUpdateConnection;
import database.DBConnectors.getConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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

    /*
    Used when retrieving patients from DB.
     */
        public Patient(long patient_id, String fname, String lname, Date DOB, String gender, long contact_no, String email, String status) {
        this.patient_id = patient_id;
        this.fname = fname;
        this.lname = lname;
        this.DOB = DOB;
        this.gender = gender;
        this.contact_no = contact_no;
        this.email = email;
        this.status = status;
    }

    /*
        for creating new Patient
         */
    public Patient(String fname,String lname,Date DOB,String gender,long contact_no,String email){
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

}
