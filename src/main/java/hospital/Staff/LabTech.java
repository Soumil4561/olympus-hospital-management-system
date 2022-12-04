package hospital.Staff;

import java.sql.Date;

public class LabTech extends Staff{

    private long test_id;

    public LabTech(long id, String fname, String lname, String gender, long number, Date DOB, long department, String email, String residential_address, long test_id) {
        super(id, fname, lname, gender, number, DOB, department, email, residential_address);
        this.test_id = test_id;
    }

    public LabTech(long id, String fname, String lname, String gender, long number, Date DOB, long department, String email, String residential_address, String type, long test_id) {
        super(id, fname, lname, gender, number, DOB, department, email, residential_address, type);
        this.test_id = test_id;
    }

    public static void PendingLabRequests(){

    }


}
