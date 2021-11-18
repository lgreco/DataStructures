/**
 * A simple hash structure based on an array of linked lists
 *
 */
public class Hash271 {

    /** Default size for underlying array */
    private static final int DEFAULT_HASH_SIZE = 5;

    /** Underlying array of Linked Lists */
    private PlainLinkedList hash[] = new PlainLinkedList[DEFAULT_HASH_SIZE];

    /** Size of the hash structure */
    private int size = 0;

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
     * @param data String of data to add
     * @return true if data added; false otherwise (in case data already present in hash structure)
     */
    public boolean add(String data) {
        // Determine which element of the array the data should be added too
        int bucket = this.hashFunction(data);
        // Make sure that there is a linked list there (even an empty one)
        if (this.hash[bucket] == null)
            this.hash[bucket] = new PlainLinkedList();
        // Avoid duplicating data
        boolean proceed = ! this.hash[bucket].contains(data);
        if (proceed) {
            this.hash[bucket].add(data);
            size++;
        }
        return proceed;
    } // method add

    @Override
    /**
     * Local toString
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.size == 0) {
            stringBuilder.append("\nYour hash is empty. Go add some data! Please?\n");
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
