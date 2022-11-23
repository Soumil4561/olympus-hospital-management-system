package currentsession;

import hospital.Staff.Staff;

import java.sql.Date;

public class CurrentUserInfo {

    private static Staff staff;

    public CurrentUserInfo(Staff db_staff) {
        staff=db_staff;
    }

    public static Staff getStaff() {
        return staff;
    }

    public static void setStaff(Staff staff) {
        CurrentUserInfo.staff = staff;
    }
}
