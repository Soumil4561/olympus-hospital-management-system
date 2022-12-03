package UI.Elements;

import java.sql.Date;
import java.sql.Time;

public class Appointment {

    private Long ID;
    private String name;
    private Long reportID;
    private Date appDate;
    private Time appTime;
    private String status;

    public Appointment(Long ID, String name, Long reportID, Date appDate, Time appTime, String status) {
        this.ID = ID;
        this.name = name;
        this.reportID = reportID;
        this.appDate = appDate;
        this.appTime = appTime;
        this.status = status;
    }

    public Appointment() {
        this.ID = 0L ;
        this.name = null;
        this.reportID = 0L;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getReportID() {
        return reportID;
    }

    public void setReportID(Long reportID) {
        this.reportID = reportID;
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
