package database.DBFetchers;

import database.DBConnectors.getConnection;
import hospital.Patient.Patient;
import database.DBConnectors.SqlSearchConnection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Returns the patients info as per the requests using different methods
 */
public class getPatientInfo{

    /**
     *
     * @param patient_id: patient id of the required patients
     * @return  list of patient objects
     * @throws SQLException
     */
    public static Patient[] searchPatients(long patient_id) throws SQLException {
        String id=String.valueOf(patient_id);
        String query;
        query="select * from patient where patient_id Regexp '?'";
        PreparedStatement ps= getConnection.getStatement(query);
        ps.setLong(1,patient_id);
        ResultSet data= SqlSearchConnection.execute(ps);
        int size=ResultsetFunctions.size(data);
        Patient[] plist=new Patient[size];
        dataToArray(data,plist);
        return plist;
    }

    public static Patient[] searchPatients(String patient_name) throws SQLException {
        String query;
        query = "select * from hospital.patient where fname OR lname Regexp '^"+patient_name+"'";
        PreparedStatement ps = getConnection.getStatement(query);
        ResultSet data = SqlSearchConnection.execute(ps);
        int size = ResultsetFunctions.size(data);
        Patient[] plist = new Patient[size];
        dataToArray(data, plist);
        return plist;
    }

    private static void dataToArray(ResultSet data, Patient[] plist) throws SQLException {
        int counter=0;
        while(data.next()){
            int p_id= data.getInt("patient_id");
            String p_fname=data.getString("fname");
            String p_lname=data.getString("lname");
            Date p_DOB=data.getDate("patient_DOB");
            String gender=data.getString("gender");
            long contact=data.getLong("contact_no");
            String email= data.getString("email");
            String status=data.getString("stat");
            plist[counter]=new Patient(p_id,p_fname,p_lname,p_DOB,gender,contact,email);
            plist[counter].setStatus(status);
            counter++;
        }
        data.close();
    }
}


