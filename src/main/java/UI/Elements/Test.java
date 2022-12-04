package UI.Elements;

public class Test {
    private String name;
    private long testID;

    public Test(String name, long testID) {
        this.name = name;
        this.testID = testID;
    }

    public Test(){
        this.name= null;
        this.testID = 0L;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTestID() {
        return testID;
    }

    public void setTestID(long testID) {
        this.testID = testID;
    }
}
