package UI.Elements;

public class AdmBed {
    private String department;
    private long bedID;

    public AdmBed(String department, long bedID) {
        this.department = department;
        this.bedID = bedID;
    }

    public AdmBed() {
        this.department = null;
        this.bedID = 0L;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public long getBedID() {
        return bedID;
    }

    public void setBedID(long bedID) {
        this.bedID = bedID;
    }
}
