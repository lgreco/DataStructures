public interface Q {

    /** Accessor for size */
    int getSize();

    /** Accessor for capacity */
    int getCapacity();

    /** Accessor for back position */
    int getB();

    /**
     * Adds a new arrival to the queue, if there is space.
     * If the addition is successful the method returns true. If the
     * queue is full, the method returns false.
     * @param s value to add to the queue
     * @return true is joining the queue succesful; false if q full.
     */
    boolean arrival(String s);

    /**
     * Method to remove element from q.
     * @return True if removal successful; false if q is empty already.
     */
    boolean departure();

    /** Displays a brief description of the queue and its contents */
    void displayQ() ;
}
