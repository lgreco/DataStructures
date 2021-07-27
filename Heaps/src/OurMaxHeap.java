public class OurMaxHeap {

    /** The underlying array */
    int heap[];

    /** The capacity of the array, in terms of number of levels in the emulated tree */
    int levels;

    /** The size of the heap, ie, how many elements it actually contains */
    int size;

    /** Basic constructor, uses number of levels */
    public OurMaxHeap(int levels) {
       heap = new int[(((int)Math.pow(2,levels))-1)];
       size = 0;
    } // basic constructor


    /**
     * Swaps two elements in an array
     * @param positionA one of the two elements
     * @param positionB the other of the two elements
     */
    private void swap(int positionA, int positionB) {
        int temporary = heap[positionA];
        heap[positionA] = heap[positionB];
        heap[positionB] = temporary;
    } // method swap


    /**
     * Method to add a new value in the heap array.
     * @param value new value to add to the array
     * @return true is there was room for this value to be added; false otherwise.
     */
    public boolean addValue(int value) {
        boolean thereIsRoom = ( size < heap.length );
        if (thereIsRoom) {
            int currentPosition = size;
            heap[currentPosition] = value;
            heapifyUpwards(currentPosition);
            size++;
        }
        return thereIsRoom;
    } // method addValue


    /**
     * Ensures max-heap property from bottom up, after a new addition to the array
     * @param fromPosition positio of newly added element.
     */
    private void heapifyUpwards(int fromPosition) {
        //     as long as we are not            value of child is greater
        //     at the root node, ie    and      than the value at its
        //     array index [0]                  parent node
        //
        while (hasParent(fromPosition) && heap[fromPosition] > heap[parentOf(fromPosition)]) {
            swap(fromPosition, parentOf(fromPosition));
            fromPosition = parentOf(fromPosition);
        }
    } // method heapifyUpwards


    public void displayHeap() {
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.printf("%d | ", heap[i]);
        }
        System.out.println();
    }

    /**
     * Finds the parent of a node
     * @param position node seeking its parent
     * @return the index position of the parent
     */
    private int parentOf(int position) {
        return (position-1)/2;
    }

    /**
     * Determines if node at given position has a parent node, recognizing that every node has
     * one except for the parent
     * @param position position asking if it has parent
     * @return true if position is not root node, ie index [0]
     */
    private boolean hasParent(int position) {
        return position > 0;
    }


    public static void main(String[] args) {
        OurMaxHeap h = new OurMaxHeap(4);
        h.addValue(10);
        h.displayHeap();
        h.addValue(15);
        h.displayHeap();
        h.addValue(120);
        h.displayHeap();
        h.addValue(138);
        h.displayHeap();
        h.addValue(27);
        h.addValue(42);
        h.addValue(40);
        h.addValue(23);
        h.addValue(72);
        h.addValue(51);
        h.displayHeap();
    }
}
