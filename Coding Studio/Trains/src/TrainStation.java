public class TrainStation {

    private String name;
    private TrainStation next;

    public TrainStation(String name) {
        this.name = name;
        this.next = null;
    }

    public void setNext(TrainStation next) {
        this.next = next;
    }

    public TrainStation getNext() {
        return this.next;
    }

    public String getName() {
        return name;
    }

    public boolean hasNext() {
        return this.next != null;
    }
}
