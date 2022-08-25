package dummy.example.tableexample.editabletable;

public class Employee {
    private int id;
    private String name;
    private double workTime;
    private boolean isPartTime;

    public Employee(int id, String name, double workTime, boolean isPartTime) {
        this.id = id;
        this.name = name;
        this.workTime = workTime;
        this.isPartTime = isPartTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWorkTime() {
        return workTime;
    }

    public void setWorkTime(double workTime) {
        this.workTime = workTime;
    }

    public boolean isPartTime() {
        return isPartTime;
    }

    public void setPartTime(boolean partTime) {
        isPartTime = partTime;
    }
}
