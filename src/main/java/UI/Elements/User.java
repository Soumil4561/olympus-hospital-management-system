package UI.Elements;

public class User {
    private String fname;
    private String lname;
    private String status;
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

