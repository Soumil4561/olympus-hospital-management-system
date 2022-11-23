package hospital.Staff;

import java.sql.Date;

public class Nurse extends Staff{


    public Nurse(long id, String fname, String lname, String gender, long number, Date DOB, int department, String email, String residential_address) {
        super(id, fname, lname, gender, number, DOB, department, email, residential_address);
    }
}
