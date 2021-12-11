

/**
 * A simple hash structure based on an array of linked lists
 *
 */
public class Hash271 {

    /** Default size for underlying array */
    private static final int DEFAULT_HASH_LENGTH = 5;

    /** Rehash factor */
    private static final int REHASH_FACTOR = 2;

    /** Overload factor */
    private static final double OVERLOAD_FACTOR = 0.75;

    /** Underlying array of Linked Lists */
    private PlainLinkedList hash[];

    /** Size of the hash structure */
    private int size;

    /** Default constructor */
    public Hash271() {
        this(DEFAULT_HASH_LENGTH);
    } // default constructor

    public Hash271(int length) {
        this.hash = new PlainLinkedList[length];
        this.size = 0;
    } // basic constructor


    /**
     * We are hashing based on the first character of a given string.
     * @param data String to hash
     * @return The hash value for the string's first character.
     */
    private int hashFunction(String data) {
        return ((int) data.charAt(0)) % this.hash.length;
    } // method hashFunction


    /**
     * Method to add data to hash structure
     * @param data String of data to addToLinkedList
     * @return true if data added; false otherwise (in case data already present in hash structure)
     */
    public void addToHashStructure(String data) {
        // Determine which element of the array the data should be added too
        int bucket = this.hashFunction(data);
        // Make sure that there is a linked list there (even an empty one)
        if (this.hash[bucket] == null)
            this.hash[bucket] = new PlainLinkedList();
        // Before adding the data, make sure the ENTIRE structure is not overloaded.
        if (this.size > ((int)(OVERLOAD_FACTOR*this.hash.length))) {
            this.rehash();
        }
        this.addToHashStructure(data);
        size++;
    } // method addToHashStructure

    private void rehash() {
        Hash271 temp = new Hash271(2*this.hash.length);
        for (PlainLinkedList plainLinkedList: this.hash) {
            if (plainLinkedList != null) {
                PlainNode current = plainLinkedList.getHead();
                while (current != null) {
                    temp.addToHashStructure(current.getData());
                    current = current.getNext();
                }
            }
        }
        this.hash = temp.hash;
    }

    @Override
    /**
     * Local toString
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.size == 0) {
            stringBuilder.append("\nYour hash is empty. Go addToLinkedList some data! Please?\n");
        } else {
            String plural = (this.size == 1) ? "element" : "elements";
            stringBuilder.append(String.format("\nHere's your exquisite hash structure with %d %s.", this.size, plural));
            for (int i = 0; i < this.hash.length; i++) {
                stringBuilder.append(String.format("\nBucket [%2d]: ",i));
                if (this.hash[i] != null) {
                    PlainNode current = this.hash[i].getHead();
                    while (current != null) {
                        stringBuilder.append(String.format("[ %s ]  ", current.getData()));
                        current = current.getNext();
                    }
                }
            }
        }
        return stringBuilder.toString();
    } // method toString
} // class Hash271
