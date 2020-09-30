/**
 * Basic tree interface. Can be used to implement any kind of tree.
 */
public interface Sapling {

    /**
     * Inserts a string value into the tree.
     * @param s Value to insert
     * @return true if insertion successful; false otherwise
     */
    boolean insert(String s);

    /**
     * Checks if a given value exists in the tree.
     * @param s Value to search for
     * @return true if value exists in the tree; false otherwise.
     */
    boolean contains(String s);

    /*
    Methods to consider adding:
      - remove an element from the tree
      - compute tree depth
      - measure balance
      - balance tree
     */
}
