package database.DBFetchers;

import database.DBConnectors.SqlSearchConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class getDepartmentInfo {

    public static long searchDeptId(String department_name) throws SQLException {
        String query= "Select department_id from departments where dept_name='"+department_name+"'";
        ResultSet data= SqlSearchConnection.connect(query);
        data.absolute(1);
        long dept_id= data.getLong("department_id");
        data.close();
        return dept_id;
    }
}
