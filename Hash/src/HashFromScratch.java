/**
 * A basic hash-map class, based on an array of hash-addressed buckets. This class
 * uses module as its hash function. Other possible choices for hash functions
 * include user-specified tables (akin to histogram bins), the m least significant
 * bits of a number's binary representation, etc.
 */
public class HashFromScratch {

    private static final int DEFAULT_CAPACITY = 10;
    /**
     * The class comprises two fields: an underlying array of linked lists built
     * with notes that are defined as an inner class here, and a count of items
     * stored among these lists.
     */
    private HashEntry[] hashMap = new HashEntry[DEFAULT_CAPACITY]; // array of linked lists
    private int size = 0; // number of items stored among the linked lists.

    class HashEntry{ // The linked list class used here
        private int data; // We are working with integer values
        private HashEntry next; // pointer to next "node"
        public HashEntry(int data) { // simple constructor
            this.data = data;
            this.next = null;
        }
        public HashEntry(int data, HashEntry next) { // full constructor
            this.data = data;
            this.next = next;
        }
    } // class HashEntry

    /**
     * The hash function: we use % for simplicity
     * @param value Value to map
     * @return map output
     */
    private int hashFunction(int value) {
        return Math.abs(value) % hashMap.length; // abs ensures non-negative values.
    } // method hashFunction

    /**
     * Method to check if value stored already. Helps to avoid duplicates. Why do
     * we care about duplicates? Hashmaps are, ultimately, collections of key-value
     * pairs. We want to avoid duplicate keys, e.g. in a scenario where we store
     * social security numbers and corresponding names, we may have multiple individuals
     * named John Smith (ie, it's ok to have duplicate values), but each one of them
     * has (or should have) a unique SSN (ie, no duplicate keys). So we need to demonstrate
     * how to avoid duplicate entries with this example. For now we do this using the
     * data / value field of the HashEntry object. Eventually, we'll redesign the object
     * as a key-value class and the contains method will be applied for the key field.
     * @param value Data to check if already exists
     * @return true is already in data structure, false otherwise.
     */
    public boolean contains(int value) {
        boolean found = false;
        int bucket = hashFunction(value);
        HashEntry current = hashMap[bucket];
        while (current != null) {
            if (current.data == value) {
                found = true;
            }
            current = current.next;
        }
        return found;
    } // method contains

    /**
     * Method to insert data in constant time (after we clear the linear time hurdle of
     * the contains method.
     * @param value Data to enter in the structure
     */
    public void insert(int value) {
        if (!contains(value)) { // Contains executes in linear time, everything else O(1)
            int bucket = hashFunction(value);
            hashMap[bucket] = new HashEntry(value, hashMap[bucket]); // LIFO
            size++;
        }
    } // method insert

    /** Quick display method */
    public void displayHash() {
        for (int i = 0; i < hashMap.length; i++) {
            System.out.printf("\nList for element at [%d]: ", i);
            if (hashMap[i] == null) {
                System.out.printf("EMPTY!");
            } else {
                HashEntry current = hashMap[i];
                while (current != null) {
                    System.out.printf("( %d ) ", current.data);
                    current = current.next;
                }
            }
        }
    } // method displayHash

    /** Driver */
    public static void main(String[] args) {
        HashFromScratch demo = new HashFromScratch();
        for (int i = 1; i <=10; i++) {
            demo.insert(i*5);
        }
        demo.displayHash();
    }
}
