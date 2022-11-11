import java.util.ArrayList;

public class SuperStructure implements OurSuperStructure<String> {

    private ArrayList<String> bag;
    private int counter;

    public SuperStructure() {
        this.bag = new ArrayList<>();
        this.counter = 0;
    }


    public boolean contains(String s) {
        return false;
    }

    public String delete() {
        String deleted = null;
        if (this.size() > 0) {
            deleted = this.bag.remove(0);
        }
        return deleted;
    }

    public int size() {
        return this.counter;
    }
}
