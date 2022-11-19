package database.DBFetchers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.x.protobuf.MysqlxPrepare;
import database.DBConnectors.SqlSearchConnection;
import database.DBConnectors.getConnection;

import static database.DBFetchers.ResultsetFunctions.size;

public class CredentialCheck {
    public static String loginCredentials(long id, String password) throws SQLException {
        String query="SELECT type from hospital.staffidandpass join hospital.staff on staff.staff_id=staffidandpass.staff_id where staffidandpass.staff_id=? AND password=MD5(?)";
        PreparedStatement ps= getConnection.getStatement(query);
        ps.setLong(1,id);
        ps.setString(2,password);
        ResultSet data=SqlSearchConnection.execute(ps);
        if(size(data)==1) {
            data.absolute(1);
            String typeOfStaff=data.getString("type");
            data.close();
            ps.close();
            return typeOfStaff;
        }
        data.close();
        return "";
    }
}