package database.DBFetchers;

import database.DBConnectors.SqlSearchConnection;
import database.DBConnectors.getConnection;
import hospital.Admissions.AdmissionView;
import hospital.Admissions.NewAdmission;

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

    public static long getAdmissionID(NewAdmission admission) throws SQLException {
        String query = "SELECT admission_id from hospital.admission where bed_id = ? AND admission_date =? AND patient_id =?";
        PreparedStatement ps = getConnection.getStatement(query);
        ps.setLong(1,admission.getBed_id());
        ps.setDate(2,admission.getDate());
        ps.setLong(3,admission.getPatient_id());
        ResultSet data = SqlSearchConnection.execute(ps);
        data.absolute(1);
        long admission_id = data.getLong("admission_id");
        data.close();
        ps.close();
        return admission_id;
    }
}
