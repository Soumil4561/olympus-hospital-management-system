package hospital.Admissions;

import hospital.Bed.Bed;
import hospital.Patient.Patient;
import hospital.Staff.Doctor;

public class NewAdmission {
    public long admission_id;
    public Patient pat;
    public Doctor doctor;
    public Bed bed;
    public NewAdmission(Patient patient, Doctor doctor, Bed bed){
        this.pat=patient;
        this.doctor=doctor;
        this.bed=bed;
    }
    public void createNewAdmission( ){

    }

}
