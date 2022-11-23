package UI.Elements;

import java.sql.Date;

public class User {
    private String fname;
    private String lname;
    private String status;
    private long uid;
    private long contact_no;
    private String email;
    private Date DOB;
    private String gender;


    public User(){
        this.fname = null;
        this.lname = null;
        this.uid = 0;
        this.contact_no = 0;
        this.email = null;
        this.DOB = null;
        this.gender = null;
        this.status = null;
    }

    public User(String fname, String lname, String status, long uid, long contact_no, String email, Date DOB, String gender) {
        this.fname = fname;
        this.lname = lname;
        this.status = status;
        this.uid = uid;
        this.contact_no = contact_no;
        this.email = email;
        this.DOB = DOB;
        this.gender = gender;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public void setContact_no(long contact_no) {
        this.contact_no = contact_no;
    }

    public String getFname() {
        return this.fname;
    }

    public String getLname() {
        return this.lname;
    }


    public String getStatus() {
        return this.status;
    }

    public long getUid() {
        return this.uid;
    }

    public long getContact_no() {
        return this.contact_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}

