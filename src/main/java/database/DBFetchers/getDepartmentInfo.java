package database.DBFetchers;

import database.DBConnectors.SqlSearchConnection;
import database.DBConnectors.getConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static database.DBFetchers.ResultsetFunctions.size;

public class getDepartmentInfo {

    public static long searchDeptId(String department_name) throws SQLException {
        String query= "Select department_id from hospital.departments where dept_name=?";
        PreparedStatement ps= getConnection.getStatement(query);
        ps.setString(1,department_name);
        ResultSet data= SqlSearchConnection.execute(ps);
        data.absolute(1);
        long dept_id= data.getLong("department_id");
        data.close();
        ps.close();
        return dept_id;
    }

    public static String[] getDeptNames() throws SQLException {
        String query = "Select dept_name from hospital.departments where department_id<200";
        PreparedStatement ps = getConnection.getStatement(query);
        ResultSet data = SqlSearchConnection.execute(ps);
        String[] dept_names=new String[size(data)];
        int counter=0;
        while(data.next()){
            dept_names[counter++] = data.getString("dept_name");
        }
        data.close();
        ps.close();
        return dept_names;
    }
}
