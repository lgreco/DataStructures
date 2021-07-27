public class MaxHeapArray {

    int heap[];
    int capacity;
    int size;

    MaxHeapArray(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    boolean addValue(int value) {
        boolean thereIsRoom = size < capacity;
        if(thereIsRoom) {
            heap[size] = value;
            displayHeap();
            ensureHeapProperty(size);
            displayHeap();
            System.out.println();
            size = size+1;
        }
        return thereIsRoom;
    }

    void displayHeap() {
        System.out.printf("\n");
        for (int i = 0; i < capacity; i++) {
            System.out.printf("%d | ", heap[i]);
        }
        //System.out.printf("\n");
    }

    void ensureHeapProperty(int position) {
        while (hasParent(position) && heap[position] > heap[parentOf(position)]) {
            swap(position, parentOf(position));
            position = parentOf(position);
        }
    }

    void swap(int a, int b) {
        int temporary = heap[a];
        heap[a] = heap[b];
        heap[b] = temporary;
    }

    boolean hasParent(int position) {
        return position > 0;
    }
    int parentOf(int position) {
        return (position-1)/2;
    }

    public static void main(String[] args) {
        MaxHeapArray h = new MaxHeapArray(15);
        h.addValue(10);
        h.addValue(5);
        h.addValue(15);
        h.addValue(10);
        h.addValue(10);
        h.addValue(1);
        h.addValue(20);
        h.addValue(31);
        h.addValue(32);
        h.addValue(33);
        h.addValue(34);
        h.addValue(35);
        h.addValue(36);
        h.addValue(37);
        h.addValue(138);
    }
}
