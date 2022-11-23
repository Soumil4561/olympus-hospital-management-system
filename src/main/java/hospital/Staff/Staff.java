package hospital.Staff;

import database.DBFetchers.CredentialCheck;

import java.sql.SQLException;

public class Staff {
    protected String fname;
    protected String lname;
    protected long staff_id;
    protected long contact_no;
    protected int date_of_birth;
    private int department_id;
    protected String password;

    public Staff(String fname,String lname,int id,long number,int DOB,int department){
        this.fname=fname;
        this.lname=lname;
        this.staff_id=id;
        contact_no=number;
        date_of_birth=DOB;
        department_id=department;
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

    public int getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(int date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static String Login(long id, String password) throws SQLException {
        String type = CredentialCheck.loginCredentials(id,password);
        return type;
    }

    public static void editAccountDetails(Staff staff){

    }
}
