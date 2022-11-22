package database.DBFetchers;

import database.DBConnectors.SqlSearchConnection;
import database.DBConnectors.getConnection;
import hospital.Admissions.AdmissionView;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static database.DBFetchers.ResultsetFunctions.size;

public class getAdmissionInfo {
    public static AdmissionView[] currentAdmissions() throws SQLException {
        String query="SELECT admission_id,CONCAT(patient.fname,' ',patient.lname) as 'Patient Name' , " +
                "CONCAT(staff.fname,' ',staff.lname) as 'Doctor Name', " +
                "report_id , patient.patient_id , bed_id , admission_date " +
                "FROM hospital.admission " +
                "JOIN hospital.staff on admission.staff_id=staff.staff_id " +
                "JOIN hospital.patient on admission.patient_id=patient.patient_id " +
                "where patient.stat='IPD'";
        PreparedStatement ps= getConnection.getStatement(query);
        ResultSet data = SqlSearchConnection.execute(ps);
        int size=size(data);
        AdmissionView[] admissionList=new AdmissionView[size];
        int counter=0;
        while(data.next()){
            long admission_id=data.getLong("admission_id");
            long patient_id=data.getLong("patient_id");
            String patient_name=data.getString("Patient Name");
            String doctor_name=data.getString("Doctor Name");
            long bed_id=data.getLong("bed_id");
            Date admission_date=data.getDate("admission_date");
            admissionList[counter++]=new AdmissionView(admission_id,patient_id,patient_name,doctor_name,bed_id,admission_date);
        }
        return admissionList;
    }
}
