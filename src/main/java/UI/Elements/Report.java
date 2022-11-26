package UI.Elements;

import java.sql.Date;

public class Report {
    private Date date;
    private Long reportid;

    public Report(Date date, Long reportid, String description) {
        this.date = date;
        this.reportid = reportid;
    }

    public Report() {
        this.date = null;
        this.reportid = 0L;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getReportid() {
        return reportid;
    }

    public void setReportid(Long reportid) {
        this.reportid = reportid;
    }
}
