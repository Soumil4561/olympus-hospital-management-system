package hospital.Staff;

import java.sql.Date;

public class ItAdmin extends Staff{


    public ItAdmin(long id, String fname, String lname, String gender, long number, Date DOB, int department, String email, String residential_address) {
        super(id, fname, lname, gender, number, DOB, department, email, residential_address);
    }

    public static void create(Staff staff){

    }
}
