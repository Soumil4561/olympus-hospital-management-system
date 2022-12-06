package hospital.Staff;

import database.DBFetchers.getLabInfo;
import hospital.Lab.LabRequest;

import java.sql.Date;
import java.sql.SQLException;

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

//    public static LabRequest[] PendingLabRequests(long test_id) throws SQLException {
//        return getLabInfo.getLabRequests(test_id);
//    }


}
