import java.util.Random;

/**
 * A basic hash-map class, based on an array of hash-addressed buckets. This class
 * uses module as its hash function. Other possible choices for hash functions
 * include user-specified tables (akin to histogram bins), the m least significant
 * bits of a number's binary representation, etc.
 */
public class HashFromScratch {

    private static final int DEFAULT_CAPACITY = 10;
    private static final double REHASH_FACTOR = 2; // Multiplicative factor for new size of underlying array
    private static final double REHASH_THRESHOLD = 0.75; // Rehash once past this threshold
    /**
     * The class comprises three fields: an underlying array of linked lists built
     * with nodes that are defined as an inner class here, and a count of items
     * stored among these lists that is essentially the size of our structure. A second count
     * called occupancy indicates how many elements of the underlying array are occupied.
     */
    private HashEntry[] hashMap = new HashEntry[DEFAULT_CAPACITY]; // array of linked lists
    private int size = 0; // number of items stored among the linked lists.
    private int occupancy = 0; // number of occupied elements in underlying array

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
        /*
        Alternatively we can call hashFunction(value,hashMap.length) from within
        this method, to preserve code integrity.
         */
    } // method hashFunction

    /**
     * Overloaded hash Function; original one uses the class's hashMap
     * array as denominator, but this one uses a custom denominator int base
     * @param value
     * @param base
     * @return
     */
    private int hashFunction(int value, int base) {
        return Math.abs(value) % base;
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
     * Saturation level is a silly moniker for the fraction between the
     * number of occupied elements in an array, and the length of the array.
     * @param underlyingArray The array of interest
     * @param occupancy How many of its elements have been assigned a value
     * @return occupancy/array.length
     */
    private double saturationLevel(HashEntry[] underlyingArray, int occupancy) {
        return ((double) occupancy) / ((double) underlyingArray.length);
    } // method saturationLevel

    /**
     * Method to insert data in constant time (after we clear the linear time hurdle of
     * the contains method.
     * @param value Data to enter in the structure
     */
    public void insert(int value) {
        if (!contains(value)) { // Contains executes in linear time, everything else O(1)
            int bucket = hashFunction(value);
            if (hashMap[bucket] == null) {
                occupancy++;  // We are using this element for the first time, so let's update the occupancy count
            }
            hashMap[bucket] = new HashEntry(value, hashMap[bucket]); // LIFO
            size++; // update the size of the data structure
            if ( saturationLevel(hashMap,occupancy) > REHASH_THRESHOLD ) { // time to resize and rehash
                hashMap = rehash(hashMap);
            }
        }
    } // method insert

    /**
     * Resizes and rehashes an array. Resizing is control by REHASH_FACTOR
     * @param underlyingArray Array to resize and rehash
     * @return Resized array with all its objects rehashed accordingly
     */
    private HashEntry[] rehash(HashEntry[] underlyingArray) {
        int newLength = (int) (underlyingArray.length * REHASH_FACTOR); // size of new array
        HashEntry[] newArray = new HashEntry[newLength]; // initialize new array
        occupancy = 0; // reset count for occupied positions since we are dealing with a new array
        for (int i = 0; i < underlyingArray.length; i++) { // scan old array to transfer items to new array
            /////////////////////////////////////////////////////////////////////
            //                                                                 //
            //        REDUNDANT CODE AHEAD ... CAN WE AVOID IT?  HOW?          //
            //                                                                 //
            /////////////////////////////////////////////////////////////////////
            if (underlyingArray[i] != null) { // for every non-null linked list in old array
                HashEntry current = underlyingArray[i]; // start from the head node
                while (current != null) { // traverse the list
                    int newBucket = hashFunction(current.data, newLength); // map value to new bucket
                    if (newArray[newBucket]==null) {
                        occupancy++; // if bucket is used for the first time, increase occupancy count
                    }
                    newArray[newBucket] = new HashEntry(current.data,newArray[newBucket]); // store new node in linked list
                    current = current.next;
                }
            }
        }
        return newArray;
    } // method rehash

    /** Quick display method */
    public void displayHash() {
        System.out.printf("\n\nThe following hash map has %d buckets of which %d are occupied (%.2f), and %d values\n", hashMap.length, occupancy, ((double) occupancy)/ ((double) hashMap.length), size);
        for (int i = 0; i < hashMap.length; i++) {
            System.out.printf("\nList at position [%d]: ", i);
            if (hashMap[i] == null) {
                System.out.printf("EMPTY!");
            } else {
                HashEntry current = hashMap[i];
                while (current != null) {
                    System.out.printf("( %d )  ", current.data);
                    current = current.next;
                }
            }
        }
    } // method displayHash

    /** Driver */
    public static void main(String[] args) {
        HashFromScratch demo = new HashFromScratch();
        Random r = new Random();
        int numberOfElementsToAdd = 50;
        for (int i = 1; i <=numberOfElementsToAdd; i++) {
            demo.insert(r.nextInt(2*numberOfElementsToAdd));
        }
        demo.displayHash();
    }
}
