package currentsession;

import hospital.Staff.Doctor;
import hospital.Staff.LabTech;
import hospital.Staff.Nurse;
import hospital.Staff.Staff;

import java.sql.Date;

public class CurrentUserInfo {

    private static Staff staff;
    private static Nurse nurse;
    private static Doctor doctor;
    private static LabTech labTech;

    public CurrentUserInfo(Staff db_staff) {
        staff=db_staff;
    }

    public static Staff getStaff() {
        return staff;
    }

    public static void setStaff(Staff staff1) {
        staff = staff1;
    }
}
