package UI.Elements;

import java.sql.Date;

public class Report {
    private Date date;
    private Long reportid;
    private String dic;
    private String deptname;

    public Report(Date date, Long reportid, String docname, String departname) {
        this.date = date;
        this.reportid = reportid;
        this.dic = docname;
        this.deptname = departname;
    }

    public Report() {
        this.date = null;
        this.reportid = 0L;
        this.dic = null;
        this.deptname = null;
    }

    public String getDic() {
        return dic;
    }

    public void setDic(String docname) {
        this.dic = docname;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String departname) {
        this.deptname = departname;
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
