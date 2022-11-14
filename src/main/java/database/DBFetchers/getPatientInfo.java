package database.DBFetchers;

import hospital.Pateint.Patient;
import database.DBConnectors.SqlSearchConnection;

import java.sql.Date;
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
    public static Patient[] searchPatients(int patient_id) throws SQLException {
        String id=String.valueOf(patient_id);
        String query;
        query="select * from patient where patient_id Regexp '^"+id+"'";
        ResultSet data= SqlSearchConnection.connect(query);
        int size=ResultsetFunctions.size(data);
        Patient[] plist=new Patient[size];
        dataToArray(data,plist);
        return plist;
    }

    public static Patient[] searchPatients(String patient_name) throws SQLException{
        String query;
        query="select * from patient where fname Regexp '^"+patient_name+"'";
        ResultSet data= SqlSearchConnection.connect(query);
        int size=ResultsetFunctions.size(data);
        Patient[] plist=new Patient[size];
        dataToArray(data,plist);
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
            plist[counter]=new Patient(p_id,p_fname,p_lname,p_DOB,gender,contact,email);
            counter++;
        }
        data.close();
    }
}


