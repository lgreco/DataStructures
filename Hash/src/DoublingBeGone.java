import java.util.Random;
import java.util.RandomAccess;

/**
 * A basic hash-map class, based on an array of hash-addressed buckets. This
 * class uses module as its hash function. Other possible choices for hash
 * functions include user-specified tables (akin to histogram bins), the m least
 * significant bits of a number's binary representation, etc.
 */
public class DoublingBeGone {

    private static final int DEFAULT_CAPACITY = 4;

    // User-defined resize factor (not a magic number)
    private final static int resizeFactor = 2;

    // Rehash limit
    private final static double rehashAt = 0.75;

    /**
     * The class comprises two fields: an underlying array of linked lists built
     * with notes that are defined as an inner class here, and a count of items
     * stored among these lists.
     */
    private HashEntry[] hashMap = new HashEntry[DEFAULT_CAPACITY]; // array of linked lists
    private int size = 0; // number of items stored among the linked lists.

    private int steps = 0;

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
        System.out.printf("\nAttempting to insert %d",value);
        if (!contains(value)) { // Contains executes in linear time, everything else O(1)
            System.out.printf("\n\tValue %d not found; can be added", value);
            int bucket = hashFunction(value);
            System.out.printf("\n\tAssigned bucket %d, for length %d", bucket, hashMap.length);
            hashMap[bucket] = new HashEntry(value, hashMap[bucket]); // LIFO
            size++;
        }

        // Rehash if >= 75% capacity
        int keyAmount = 0;
        for (int i = 0; i < hashMap.length; i++) {
            if (hashMap[i] != null) {
                keyAmount++;
            }
        }
        double saturation = (double)keyAmount / hashMap.length;
        if (saturation >= rehashAt) {
            System.out.printf("\n\t** Saturation is %.2f for length %d", saturation, hashMap.length);
            hashMap = rehash(hashMap);
            System.out.printf("\n\tNew length is adjusted to %d", hashMap.length);
        }
    } // method insert

    /** Quick display method */
    public void displayHash() {
        for (int i = 0; i < hashMap.length; i++) {
            System.out.printf("\n\t\tList for element at [%d]: ", i);
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

        System.out.printf("\nCapacity: %d", hashMap.length);
        System.out.printf("\nSize/Occupancy: %d", size);
    } // method displayHash

    public HashEntry[] rehash(HashEntry[] arr) {

        steps = 0;

        HashEntry[] resizedArr = new HashEntry[arr.length * resizeFactor];
        System.out.printf("\n\tConfirming new length to %d", resizedArr.length);
        steps++;

        //System.out.println("    ~ Original array");
        //hashMap.displayHash();

        for (int i = 0; i < arr.length; i++) {
            if ( arr[i] != null) {
                HashEntry current = arr[i];
                while (current.next != null) {
                    int newBucket = hashFunction(current.data);
                    resizedArr[newBucket] = new HashEntry(current.data, resizedArr[newBucket]);
                    current = current.next;
                }
            }
        }

        return resizedArr;
    }

    /** Driver */
    public static void main(String[] args) {
        DoublingBeGone demo = new DoublingBeGone();
        Random r = new Random();
        for (int i = 10; i >2; i--) {
            demo.insert(r.nextInt(20));
        }
        demo.displayHash();
    }
}