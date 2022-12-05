package hospital.Lab;

public class LabRequest {
    private long record_id;
    private long patient_id;
    private String patient_name;
    private long staff_id;
    private String doctor_name;
    private long report_id;

    private String remarks;

    public LabRequest(long record_id, long patient_id, String patient_name, long staff_id, String doctor_name, long report_id, String remarks) {
        this.record_id = record_id;
        this.patient_id = patient_id;
        this.patient_name = patient_name;
        this.staff_id = staff_id;
        this.doctor_name = doctor_name;
        this.report_id = report_id;
        this.remarks = remarks;
    }


}
