package hospital.Patient;

import java.sql.Time;
import java.util.Date;


public class PatientFile {
    class Node {
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

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        private Date date;
        private Time time;
        private String type;
        private String description;
        private String remarks;
    }

    private long report_id;
    private long patient_id;
    private String patient_name;
    private Node node;



}
