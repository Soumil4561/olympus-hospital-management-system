package database.DBFetchers;

import database.DBConnectors.SqlSearchConnection;
import database.DBConnectors.getConnection;
import hospital.Lab.LabRequest;
import hospital.Lab.LabTests;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static database.DBFetchers.ResultsetFunctions.size;

public class getLabInfo {
    public static String getTestName(long test_id) throws SQLException {
        String query = "SELECT test_name from hospital.lab_test where test_id = ?";
        PreparedStatement ps = getConnection.getStatement(query);
        ps.setLong(1,test_id);
        ResultSet data = SqlSearchConnection.execute(ps);
        data.absolute(1);
        String name = data.getString("test_name");
        data.close();
        ps.close();
        return name;
    }

//    public static LabRequest[] getLabRequests(long test_id) throws SQLException {
//        String query = "Select id, CONCAT(patient.fname,' ',patient.lname) as 'Patient Name', " +
//                "CONCAT(staff.fname,' ',staff.lname) as 'Doctor Name', " +
//                "patient.patient_id, staff.staff.id, lab_requests.report_id " +
//                "from hospital.lab_requests " +
//                "join hospital.patient on patient.patient_id = lab_requests.patient_id " +
//                "join hospital.staff on staff.staff_id = lab_requests.staff_id " +
//                "where test_id=?";
//        PreparedStatement ps = getConnection.getStatement(query);
//        ps.setLong(1,test_id);
//        ResultSet data = SqlSearchConnection.execute(ps);
//        LabRequest[] list = new LabRequest[size(data)];
//        int counter=0;
//        while(data.next()){
//            long record_id = data.getLong("id");
//            long patient_id = data.getLong("patient_id");
//            String patient_name = data.getString("Patient Name");
//            long staff_id = data.getLong("staff_id");
//            String doctor_name = data.getString("Doctor Name");
//            long report_id = data.getLong("report_id");
//            String remarks = data.getString("remarks");
//            list[counter++]= new LabRequest(record_id, patient_id, patient_name,staff_id,doctor_name,report_id,remarks);
//        }
//        data.close();
//        ps.close();
//        return list;
//    }

    public static LabRequest[] getLabRequests() throws SQLException {
        String query = "Select id, CONCAT(patient.fname,' ',patient.lname) as 'Patient Name', " +
                "CONCAT(staff.fname,' ',staff.lname) as 'Doctor Name', " +
                "patient.patient_id, lab_requests.staff_id, lab_requests.report_id , lab_requests.test_id , lab_test.test_name, remarks " +
                "from hospital.lab_requests " +
                "join hospital.patient on patient.patient_id = lab_requests.patient_id " +
                "join hospital.staff on staff.staff_id = lab_requests.staff_id " +
                "join hospital.lab_test on lab_requests.test_id = lab_test.test_id ";
        PreparedStatement ps = getConnection.getStatement(query);
        ResultSet data = SqlSearchConnection.execute(ps);
        LabRequest[] list = new LabRequest[size(data)];
        int counter=0;
        while(data.next()){
            long record_id = data.getLong("id");
            long patient_id = data.getLong("patient_id");
            String patient_name = data.getString("Patient Name");
            long staff_id = data.getLong("staff_id");
            String doctor_name = data.getString("Doctor Name");
            long report_id = data.getLong("report_id");
            String remarks = data.getString("remarks");
            long test_id = data.getLong("test_id");
            String test_name = data.getString("test_name");
            list[counter++]= new LabRequest(record_id, patient_id, patient_name,staff_id,doctor_name,report_id,remarks,test_id,test_name);
        }
        data.close();
        ps.close();
        return list;
    }

    public static LabTests[] getTestList() throws SQLException {
        String query = "Select * from hospital.lab_test";
        PreparedStatement ps = getConnection.getStatement(query);
        ResultSet data = SqlSearchConnection.execute(ps);
        LabTests[] testList = new LabTests[size(data)];
        int counter=0;
        while (data.next()){
            long test_id = data.getLong("test_id");
            String test_name = data.getString("test_name");
            testList[counter++]=new LabTests(test_id,test_name);
        }
        data.close();
        ps.close();
        return testList;
    }


}
