/**
 * A FIFO implementation with O(1) insertions and removals.
 *
 * @author leo@cs.luc.edu
 *
 */
public class FastQueue {

    /** Constant for default capacity */
    private static final int DEFAULT_CAPACITY = 4;

    /** Constant for empty queue */
    private static final String EMPTY_QUEUE = "Queue is empty.";

    /** Underlying array for the queue */
    private String[] queue;

    /** Number of items currently in queue */
    private int usage;

    /** Integer points to the front and back element of the queue */
    private int front, back;


    /**
     * Basic constructor. Initializes a queue[] and sets usage to 0. It also sets the front and
     * the back pointers to 0. Since the queue is empty, its front and its back is in the same position.
     *
     * @param capacity int how many items the queue can accommodate, at most.
     */
    public FastQueue(int capacity) {
        this.queue = new String[capacity];
        this.usage = 0;
        this.front = this.back = 0;
    } // basic constructor


    /** Default constructor. Uses the constant DEFAULT_CAPACITY to call the basic constructor */
    public FastQueue() {
        this(DEFAULT_CAPACITY);
    } // default constructor


    /**
     * Adds a new item to the queue, if there is room. The new arrival is added, always, to the back
     * of the queue (ensuring a FIFO staging). The back of the queue is identified by this.back. It is
     * an integer variable pointing to the array element where the back of the queue is. The back
     * moves one position to the right of the array, each time we add a new arrival. When the back
     * reaches the end of the array (this.back == this.queue.length), then it moves to the beginning
     * of the array, using a modulo operation.
     *
     * @param s String to add to the queue
     * @return true if addition successful; false if queue is full and cannot accept
     */
    public boolean add(String s) {
        // Determine if there is room for one more item in the queue
        boolean queueHasRoom = this.usage < queue.length;
        if (queueHasRoom) {
            // New item is added at the back of the queue
            this.queue[this.back] = s;
            // Usage is increased by 1
            this.usage++;
            /*
            Back moves to the right, returns to beginning of array if out-of-bounds. There are several ways
            to ensure that the value of back is a legit position index for the underlying array. The implementation
            here uses modulo to send this.back to the beginning of the array. Other techniques may use a simple if:
              if (this.back == this.queue.length) this.back = 0;
            or the ternary operator:
              this.back = (this.back == this.queue.length) ? 0 : this.back++;
             */
            this.back = (this.back+1) % this.queue.length;
        }
        return queueHasRoom;
    } // method add


    /**
     * Removes and returns the string at the front of the queue.
     *
     * @return String at the front of the queue, or null if queue is empty
     */
    public String pull() {
        // Initialize the return string
        String s = null;
        // If queue is not empty ...
        if (this.usage > 0) {
            // Take string from the front of the queue
            s = this.queue[this.front];
            // And make that position blank
            this.queue[this.front] = null;
            /*
             Move front to the right. When the front pointer reaches the end of the array, it moves to the beginning
             of the array. In this implementation, we use % to accomplish that. We can also achieve the same result
             by using an if statement:
               if (this.front == this.queue.length) this.front = 0;
             or the ternary operator:
               this.front = (this.front == this.queue.length) ? 0 : this.front++;
             */
            this.front = (this.front+1) % this.queue.length;
            // Decrease usage of array
            this.usage--;
        }
        return s;
    } // method pull


    /**
     * Returns the value of the string at the front of the queue without removing it and without
     * disturbing the queue.
     *
     * @return String at the front of the queue, or null if queue is empty
     */
    public String peek() {
        // This is a case where the ternary operator comes handy!
        return (this.usage > 0) ? this.queue[this.front] : EMPTY_QUEUE;
    } // method peek


    @Override
    /**
     * Local toString implementation: returns an array view and a queue view of the data.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nArray Contents: ");
        for (int i = 0; i < this.queue.length ; i++) {
            sb.append(String.format("[%s] ", this.queue[i]));
        }
        sb.append("\nQueue view: ");
        for (int i = 0; i < this.usage; i++) {
            sb.append(String.format("[%s] ", this.queue[(i+this.front) % this.queue.length]));
        }
        sb.append("\n");
        return sb.toString();
    } // method toString


    /**
     * Driver code and simple (naive) testing.
     */
    public static void main(String[] args)  {
        final String SUCCESS = "Successful";
        final String FAIL = "FAILED";
        FastQueue q = new FastQueue();
        boolean a = q.add("A");  // New arrival to empty queue, usage is 1
        boolean b = q.add("B");  // New arrival, usage is 2
        boolean c = q.add("C");  // New arrival, usage is 3
        boolean d = q.add("D");  // New arrival, usage is 4 and queue is full
        boolean e = q.add("E");  // New arrival cannot be added to full queue (method returns false)
        String addOperations = (a && b && c && d && !e) ? SUCCESS : FAIL;
        boolean pA = q.pull().equals("A");  // Removing first in line ("A") .. usage is 3 .. queue can accept new arrivals
        boolean pB = q.pull().equals("B");  // Removing first in line ("B") .. usage is 2 .. queue can accept new arrivals
        String pullOperations1 = (pA && pB) ? SUCCESS : FAIL;
        q.add("F");  // New arrival to queue with room to accommodate it .. usage is 3
        q.add("G");  // New arrival to queue with room to accommodate it .. usage is 4
        boolean pC = q.pull().equals("C");  // Removing first in line ("C") .. usage is 3 .. queue can accept new arrivals
        boolean pD = q.pull().equals("D");  // Removing first in line ("D") .. usage is 2 .. queue can accept new arrivals
        boolean pF = q.pull().equals("F");  // Removing first in line ("F") .. usage is 1 .. queue can accept new arrivals
        String pullOperations2 = (pC && pD && pF) ? SUCCESS : FAIL;
        System.out.printf("\nTEST REPORTING:\n\n\t   First round of add operations: %s", addOperations);
        System.out.printf("\n\t  First round of pull operations: %s", pullOperations1);
        System.out.printf("\n\t Second round of pull operations: %s\n", pullOperations2);
    } // method main
} // class FastQueue
