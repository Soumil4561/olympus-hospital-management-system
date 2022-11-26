package database.DBFetchers;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import currentsession.CurrentUserInfo;
import database.DBConnectors.SqlSearchConnection;
import database.DBConnectors.getConnection;
import hospital.Staff.Staff;


import static database.DBFetchers.ResultsetFunctions.size;

public class CredentialCheck {
    public static String loginCredentials(long id, String password) throws SQLException {
        String query="SELECT * from hospital.staffidandpass join hospital.staff on staff.staff_id=staffidandpass.staff_id where staffidandpass.staff_id=? AND password=MD5(?)";
        PreparedStatement ps= getConnection.getStatement(query);
        ps.setLong(1,id);
        ps.setString(2,password);
        ResultSet data=SqlSearchConnection.execute(ps);
        if(size(data)==1) {
            data.absolute(1);
            String typeOfStaff=data.getString("type");
            Long staff_id=data.getLong("staff_id");
            String fname=data.getString("fname");
            String lname=data.getString("lname");
            String gender=data.getString("gender");
            String email=data.getString("email");
            Long department_id=data.getLong("department_id");
            Date date=data.getDate("DOB");
            String address=data.getString("residential_address");
            Long contact_no=data.getLong("contact_no");
            Staff staff=new Staff(staff_id,fname,lname,gender,contact_no,date,department_id,email,address);
            CurrentUserInfo.setStaff(staff);
            data.close();
            ps.close();
            return typeOfStaff;
        }
        data.close();
        return "";
    }
}