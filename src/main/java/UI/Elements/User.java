package UI.Elements;

public class User {
    private String fname;
    private String lname;
    private String status;

    public User(){
        this.fname = null;
        this.lname = null;
        this.uid = 0;
        this.contact_no = 0;
        this.status = null;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public void setContact_no(long contact_no) {
        this.contact_no = contact_no;
    }

    private long uid;
    private long contact_no;


    public User(String fname, String lname, String status, long uid, long contact_no){
        this.fname = fname;
        this.lname = lname;
        this.status = status;
        this.uid = uid;
        this.contact_no = contact_no;
    }

    public String getFname() {
        return this.fname;
    }

    public String getLname() {
        return this.lname;
    }


    public String getStatus() {
        return this.status;
    }

    public long getUid() {
        return this.uid;
    }

    public long getContact_no() {
        return this.contact_no;
    }

}

