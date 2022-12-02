package hospital.Patient;

import java.sql.Time;
import java.util.ArrayList;
import java.sql.Date;


public class PatientFile {
    public static class Node {
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

        private Date date;
        private Time time;
        private String type;
        private String description;
    }

    private long report_id;
    private long patient_id;
    private String patient_name;
    private ArrayList<Node> nodeList = new ArrayList<Node>();

    public ArrayList<Node> getNodeList() {
        return nodeList;
    }

    public long getReport_id() {
        return report_id;
    }

    public void setReport_id(long report_id) {
        this.report_id = report_id;
    }

    public long getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(long patient_id) {
        this.patient_id = patient_id;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public static PatientFile parseFile(ArrayList<String> output){
        PatientFile file = new PatientFile();
        file.setReport_id(Long.parseLong(output.get(0).substring(11)));
        file.setPatient_id(Long.parseLong(output.get(1).substring(12)));
        file.setPatient_name(output.get(2).substring(14));
        for (int i =4;i<output.size();i++){
            Node node = new Node();
            String[] text = output.get(i).split("~");
            node.setDate(Date.valueOf(text[0]));
            node.setTime(Time.valueOf(text[1]));
            node.setType(text[2]);
            node.setDescription(text[3]);
            file.getNodeList().add(node);
        }
        return file;
    }

}
