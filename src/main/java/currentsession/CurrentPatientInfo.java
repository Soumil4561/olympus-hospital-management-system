package currentsession;

import hospital.Patient.Patient;

public class CurrentPatientInfo {
    private static Patient patient;

    public CurrentPatientInfo(Patient db_patient){
        patient=db_patient;
    }

    public static Patient getPatient() {
        return patient;
    }

    public static void setPatient(Patient patient) {
        CurrentPatientInfo.patient = patient;
    }
}
