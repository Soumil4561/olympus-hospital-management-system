package hospital.Staff;

import database.DBConnectors.SqlInsertUpdateConnection;
import database.DBConnectors.getConnection;
import database.DBFetchers.CredentialCheck;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Staff {
    protected String fname;
    protected String lname;
    protected long staff_id;
    protected long contact_no;
    protected Date date_of_birth;

    protected String gender;
    protected String email;
    private long department_id;

    protected String residential_address;
    protected String password;

    public Staff(long id,String fname,String lname, String gender,long number,Date DOB,long department,String email, String residential_address){
        this.fname=fname;
        this.lname=lname;
        this.staff_id=id;
        this.contact_no=number;
        this.date_of_birth=DOB;
        this.department_id=department;
        this.gender=gender;
        this.email=email;
        this.residential_address=residential_address;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public long getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(long staff_id) {
        this.staff_id = staff_id;
    }

    public long getContact_no() {
        return contact_no;
    }

    public void setContact_no(long contact_no) {
        this.contact_no = contact_no;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(long department_id) {
        this.department_id = department_id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResidential_address() {
        return residential_address;
    }

    public void setResidential_address(String residential_address) {
        this.residential_address = residential_address;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static String Login(long id, String password) throws SQLException {
        String type = CredentialCheck.loginCredentials(id,password);
        return type;
    }

    public static boolean editAccountDetails(Staff staff) throws SQLException {
        String query="UPDATE `hospital`.`staff` SET `fname` = ?, `lname` = ?, `gender` = ?, `DOB` = ?, `department_id` = ?, `contact_no` = ?, `email` = ?, `residential_address` = ? WHERE (`staff_id` = ?)";
        PreparedStatement ps = getConnection.getStatement(query);
        assert ps != null;
        ps.setString(1,staff.getFname());
        ps.setString(2,staff.getLname());
        ps.setString(3,staff.getGender());
        ps.setDate(4,staff.getDate_of_birth());
        ps.setLong(5,staff.getDepartment_id());
        ps.setLong(6,staff.getContact_no());
        ps.setString(7,staff.getEmail());
        ps.setString(8, staff.getResidential_address());
        ps.setLong(9,staff.getStaff_id());
        return SqlInsertUpdateConnection.execute(ps);
    }

    protected boolean ChangePassword(long staff_id, String password) throws SQLException {
        String query="UPDATE `hospital`.`staffidandpass` SET `password` = MD5(?) WHERE (`staff_id` = ?);";
        PreparedStatement ps=getConnection.getStatement(query);
        ps.setString(1,password);
        ps.setLong(2,staff_id);
        return SqlInsertUpdateConnection.execute(ps);
    }
}
