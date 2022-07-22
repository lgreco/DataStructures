/**
 * An illustrative class to demonstrate a hash structure that comprises an
 * array of Nodes. Each element of the array can accommodate an indefinite
 * number of nodes. These nodes form, essentially a linked list that dangles
 * under each array element.
 *
 *      +------+------+------+------+
 *      | null | node | node | node |    <=== array of Nodes; each element
 *      +------+------+------+------+         of the array may be null or a
 *                 |      |      |            Node object. A Node object may
 *               node   node   null           point to another Node object or
 *                 |      |                   to null, thus forming a linked
 *               node   null                  list. These linked lists need no
 *                 |                          designated head Nodes, because
 *               null                         we can find their entry points
 *                                            in the array.If array[i] is null,
 *                                            there is no linked list there.
 *
 *                                            Otherwise, there is a linked list
 *                                            whose "head" nodeis the Node
 *                                            object stored at array[i].
 */
public class DanglingNodes {

    // Class constants ========================================================

    /** Array size for default constructor */
    private static final int DEFAULT_ARRAY_SIZE = 5;

    /** Load factor for default constructor */
    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    /** Rehash factor for default constructor */
    private static final int DEFAULT_RESIZE_FACTOR = 2;


    // Class fields ===========================================================

    /** Array of Nodes. Each element is the beginning node of a linked list. */
    private Node[] bins;

    /** Count of nodes stored in the structure, tells us when to rehash. */
    private int usage;

    /** Utilization threshold that triggers a rehash. */
    private double loadFactor;

    /** Determines how larger the rehashed array will be. */
    private int resizeFactor;


    /** Full constructor */
    public DanglingNodes(int size, double loadFactor, int resizeFactor) {
        this.bins = new Node[size];
        this.usage = 0;
        this.loadFactor = loadFactor;
        this.resizeFactor = resizeFactor;
    }  // full constructor


    /** Default constructor; uses class constants. */
    public DanglingNodes() {
        this(DEFAULT_ARRAY_SIZE, DEFAULT_LOAD_FACTOR, DEFAULT_RESIZE_FACTOR);
    }  // default constructor


    /**
     * Computes the load of the structure. The load is defined as the ratio:
     *
     *    number of nodes present / length of underlying array
     *
     * @return load utilization on of the structure
     */
    public double utilization() {
        return (double) usage / (double) this.bins.length;
    }  // method utilization


    /**
     * Computers an integer value between 0 and bins.length-1. This value
     * determines the array position for a node we wish to store in the
     * structure.
     *
     * @param string String to hash
     *
     * @return int position for array bins
     */
    public int hashFunction(String string) {
        int hash;
        hash = (int) string.charAt(0) % this.bins.length;
        return hash;
    }  // method hashFunction


    /**
     * Adds a node to the structure, checks if utilization exceeds the load
     * factor, and if so, rehashes the structure.
     *
     * @param string String content for new node to be added to the structure.
     */
    public void add(String string) {
        // which position in the array should the string go to?
        int position = this.hashFunction(string);
        // Create new node at position, and append any existing nodes to it.
        this.bins[position] = new Node(string, this.bins[position]);
        // Update usage.
        this.usage++;
        // Is it time to rehash?
        if (this.utilization() > this.loadFactor)
            this.rehash();
    }  // method add


    /**
     * Create a new, larger structure and add the data from the existing
     * structure here, reducing the utilization thanks to the larger size
     * of the new structure's underlying array. The method is private
     * because it needs only be invoked by an object of this class. There is
     * no need to access it from outside this class.
     */
    private void rehash() {
        // double the size of the underlying array and redistribute its data
        DanglingNodes temporary = new DanglingNodes(
                this.bins.length*this.resizeFactor,
                this.loadFactor,
                this.resizeFactor);
        // Place data from current structure to temporary.
        for (int i = 0; i < this.bins.length; i++) {
            // Check if there are any nodes at this position
            if (this.bins[i] != null) {
                // Traverse the nodes in this position
                Node cursor = this.bins[i];
                while (cursor != null) {
                    // Pull the data from the current node
                    String s = cursor.getData();
                    // Add the data to the new (temporary) structure
                    temporary.add(s);
                    // Go to the next node in this bins position.
                    cursor = cursor.getNext();
                }
            }
        }
        // Copy the new structure's bins array to the current structure's.
        this.bins = temporary.bins;
    }  // method rehash


    /**
     * String representation of the structure.
     *
     * @return String with structure's contents
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(
                "\n\n%s Utilization = %.2f %s",
                "#".repeat(35),
                utilization(),
                "#".repeat(35)));
        for (int i = 0; i < this.bins.length; i++) {
            sb.append(String.format("\nbin[%02d]: ",i));
            Node cursor = this.bins[i];
            if (cursor == null) {
                sb.append("-");
            } else {
                while (cursor.hasNext()) {
                    sb.append(String.format("%s --> ", cursor.getData()));
                    cursor = cursor.getNext();
                }
                // Fencepost: last node
                sb.append(String.format("%s", cursor.getData()));
            }
        }
        return sb.toString();
    }  // method toString


    public static void main(String[] args) {
        DanglingNodes demo = new DanglingNodes();
        System.out.println(demo);
        demo.add("Potter");
        System.out.println(demo);
        demo.add("Dumbledore");
        System.out.println(demo);
        demo.add("Hagrid");
        System.out.println(demo);
        demo.add("Malfoy");
        System.out.println(demo);
        demo.add("Weasley");
        System.out.println(demo);
        demo.add("Olivander");
        System.out.println(demo);
        demo.add("Lupin");
        System.out.println(demo);
        demo.add("Snape");
        System.out.println(demo);
        demo.add("Trelawney");
        System.out.println(demo);
        demo.add("Pomfrey");
        System.out.println(demo);
        demo.add("Slughorn");
        System.out.println(demo);
        demo.add("Sprout");
        System.out.println(demo);
        demo.add("Lockhart");
        System.out.println(demo);
    }

}  // class DanglingNodes