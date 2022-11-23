package UI.Elements;

import java.sql.Date;
import java.sql.Time;

public class Appointment {

    private Long ID;
    private String fname;
    private String lname;
    private Date appDate;
    private Time appTime;
    private String status;

    public Appointment(Long ID, String fname, String lname, Date appDate, Time appTime, String status) {
        this.ID = ID;
        this.fname = fname;
        this.lname = lname;
        this.appDate = appDate;
        this.appTime = appTime;
        this.status = status;
    }

    public Appointment() {
        this.ID = 0L ;
        this.fname = null;
        this.lname = null;
        this.appDate = null;
        this.appTime = null;
        this.status = null;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
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

    public Date getAppDate() {
        return appDate;
    }

    public void setAppDate(Date appDate) {
        this.appDate = appDate;
    }

    public Time getAppTime() {
        return appTime;
    }

    public void setAppTime(Time appTime) {
        this.appTime = appTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
