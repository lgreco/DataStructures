import javax.print.attribute.HashAttributeSet;
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
     * The class comprises two fields: an underlying array of linked lists built
     * with notes that are defined as an inner class here, and a count of items
     * stored among these lists.
     */
    private HashEntry[] hashMap = new HashEntry[DEFAULT_CAPACITY]; // array of linked lists
    private int size = 0; // number of items stored among the linked lists.
    private int occupancy = 0; // number of occupied elements in underlying array
    private int steps = 0; // Naive complexity counter

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
     * Saturation level is a silly moniker for the fraction between the
     * number of occupied elements in an array, and the length of the array.
     * @param underlyingArray The array of interest
     * @param occupancy How many of its elements have been assigned a value
     * @return occupancy/array.length
     */
    private double saturationLevel(HashEntry[] underlyingArray, int occupancy) {
        // return ((double) underlyingArray.length) / ((double) occupancy);
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
            if ( hashMap[bucket] == null) { occupancy++;  } // We are using a new element in the underlying
            // array
            hashMap[bucket] = new HashEntry(value, hashMap[bucket]); // LIFO
            size++;
            if ( saturationLevel(hashMap,occupancy) > REHASH_THRESHOLD ) {
                // REHASH
                System.out.printf("\nRehashing... with saturation %.2f", saturationLevel(hashMap,occupancy));
                hashMap = rehash(hashMap);
                return;
            }
        }
    } // method insert

    /**
     * Resizes and rehashes an array. Resizing is control by REHASH_FACTOR
     * @param underlyingArray Array to resize and rehash
     * @return Resized array with all its objects rehashed accordingly
     */
    private HashEntry[] rehash(HashEntry[] underlyingArray) {
        int newLength = (int) (underlyingArray.length * REHASH_FACTOR);
        steps++;
        HashEntry[] newArray = new HashEntry[newLength];
        steps++;
        System.out.printf("\n\tNew array has size %d up from %d", newArray.length, underlyingArray.length);
        /*
        Things to contemplate in class:
        1 - copy old array elements to new array, and then go through
        each linked list and re-hash accordingly, or
        2 - go through all linked lists and rehash at the same time?
        3 - code deficiencies: hashFunction- poorly parameterized; improve? how?         */

        for ( int i = 0; i < underlyingArray.length; i++ ) {
            System.out.printf("\n\t Underlying position %d",i);
            if ( underlyingArray[i] != null ) {
                System.out.printf("\n\t\tNot null, scanning: from [%d] with (%d): ",i,underlyingArray[i].data);
                HashEntry current = underlyingArray[i];
                steps++;
                while ( current.next != null ) {
                    int newBucket = hashFunction( current.data, newLength );
                    steps++;
                    System.out.printf(" (%d) to [%d] ",current.data, newBucket);
                    newArray[newBucket] = new HashEntry(current.data,newArray[newBucket]);
                    steps++;
                    current = current.next;
                    steps++;
                }
            }
        }
        return newArray;
    } // method rehash

    /**
     * Overloaded hash Function; original one uses the class's hashMap
     * array as denominator, but this one uses a custom denominator int base
     * @param value
     * @param base
     * @return
     */
    private int hashFunction(int value, int base) {
        return value%base;
    }

    /** Quick display method */
    public void displayHash() {
        System.out.printf("\n\nThe following hash map has %d buckets, %.2f occupancy, and %d values", hashMap.length, ((double) occupancy)/ ((double) hashMap.length), size);
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
        Random r = new Random();
        for (int i = 1; i <=10; i++) {
            demo.insert(r.nextInt(99));
        }
        demo.displayHash();

        for (int i=1;i<=10;i++){
            demo.insert(r.nextInt(99));
        }
        demo.displayHash();
    }
}
