public class Patient {

    private String name;
    private int severity;
    private long arrivalTime;

    public long getArrivalTime() {
        return arrivalTime;
    }

    public Patient(String name, int severity, long arrivalTime) {
        this.name = name;
        this.severity = severity;
        this.arrivalTime = arrivalTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }
}
