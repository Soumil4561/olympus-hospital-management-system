package hospital.Lab;

public class LabRequest {
    private int record_id;
    private int patient_id;
    private String patient_name;
    private int staff_id;
    private String doctor_name;
    private int report_id;

    public LabRequest(int record_id, int patient_id, String patient_name, int staff_id, String doctor_name, int report_id) {
        this.record_id = record_id;
        this.patient_id = patient_id;
        this.patient_name = patient_name;
        this.staff_id = staff_id;
        this.doctor_name = doctor_name;
        this.report_id = report_id;
    }


}
