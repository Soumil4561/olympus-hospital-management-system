package currentsession;

import java.sql.Date;

public class CurrentUserInfo {
    private static long staff_id;
    private static String fname;
    private static String lname;
    private static String gender;
    private static Date date;
    private static long contact_no;
    private static String email;
    private static String residential_address;

    public long getStaff_id() {
        return staff_id;
    }

    public static void setStaff_id(long db_staff_id) {
        staff_id = db_staff_id;
    }

    public static String getFname() {
        return fname;
    }

    public static void setFname(String db_fname) {
        fname = db_fname;
    }

    public String getLname() {
        return lname;
    }

    public static void setLname(String db_lname) {
        lname = db_lname;
    }

    public String getGender() {
        return gender;
    }

    public static void setGender(String db_gender) {
        gender = db_gender;
    }

    public Date getDate() {
        return date;
    }

    public static void setDate(Date db_date) {
        date = db_date;
    }

    public long getContact_no() {
        return contact_no;
    }

    public static void setContact_no(long db_contact_no) {
        contact_no = db_contact_no;
    }

    public String getEmail() {
        return email;
    }

    public static void setEmail(String db_email) {
        email = db_email;
    }

    public String getResidential_address() {
        return residential_address;
    }

    public static void setResidential_address(String db_residential_address) {
        residential_address = db_residential_address;
    }


    public CurrentUserInfo(long db_staff_id, String db_fname, String db_lname, String db_gender, Date db_date, long db_contact_no, String db_email, String db_residential_address) {
        staff_id = db_staff_id;
        fname = db_fname;
        lname = db_lname;
        gender = db_gender;
        date = db_date;
        contact_no = db_contact_no;
        email = db_email;
        residential_address = db_residential_address;
    }
}
