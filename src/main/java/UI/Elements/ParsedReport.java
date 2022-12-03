package UI.Elements;

import java.sql.Date;
import java.sql.Time;

public class ParsedReport {
    Date date;
    Time time;
    String type;
    String description;

    public ParsedReport(Date date, Time time, String type, String description) {
        this.date = date;
        this.time = time;
        this.type = type;
        this.description = description;
    }

    public ParsedReport() {
        this.date = null;
        this.time = null;
        this.type = null;
        this.description = null;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
