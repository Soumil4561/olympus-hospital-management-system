package hospital.Department;

import database.DBFetchers.getDepartmentInfo;

import java.sql.SQLException;

public class Department {
    public long department_id;
    public String department_name;

    public Department(long department_id,String department_name){
        this.department_id=department_id;
        this.department_name=department_name;
    }

    public long getDepartment_id() {
        return department_id;
    }

    public static long getDepartment_id(String department_name) throws SQLException {
        return getDepartmentInfo.searchDeptId(department_name);
    }

    public void setDepartment_id(long department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }


    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }
}
