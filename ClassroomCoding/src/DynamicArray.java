 public class DynamicArray {

    private int size;
    private String[] data;
    private int position;

    private static final int DEFAULT_SIZE = 4;
    private static final int GROWTH_FACTOR = 2;

    public DynamicArray(int size) {
        this.size = size;
        this.data = new String[this.size];
        this.position = 0;
    }

    public DynamicArray() {
        this(DEFAULT_SIZE);
    }

    public void add(String string) {
        if (this.position == this.size) {
            this.resize();
        }
        this.data[this.position] = string;
        this.position++;
    }

    public void resize(int growthFactor) {
        this.size = growthFactor*this.size;
        String[] temp = new String[this.size];
        for (int i = 0; i < this.data.length; i++) {
            temp[i] = this.data[i];
        }
        this.data = temp;
    }

    public void resize() {
        resize(GROWTH_FACTOR);
    }

    public String toString() {
        System.out.printf("\nSize = %d\n[", this.size);
        for (String s:this.data){
            System.out.printf("%s ",s);
        }
        System.out.printf("]\n");
    }

    // test code
    public static void main(String[] args) {
        DynamicArray da = new DynamicArray();
        System.out.println(da);
    }
}