public class NaivePQ {

    /** First and last name of author of this program */
    private static final String AUTHOR = "Leo";

    /** Default capacity for each queue */
    private static final int DEFAULT_CAPACITY = 10;

    /** Default number of queues */
    private static final int DEFAULT_LEVELS = 3;

    /** Underlying array for the queues. Each row represents a queue in decreasing priority */
    private final String[][] queues;

    /** Array to keep track of each queue usage */
    private final int[] usage;


    /**
     * Basic constructor.
     *
     * Instantiates an object that can accommodate a *naive* priority queue with a
     * given number of priority levels and the capacity that is the same for every level.
     * For example, a queue for passengers flying first, business, and economy class
     * has three priority levels.
     *
     * @param priorityLevels int with number of priority levels to consider.
     * @param capacity int with number of items per queue.
     */
    public NaivePQ(final int priorityLevels, final int capacity) {
        this.queues = new String[priorityLevels][capacity];
        this.usage = new int[priorityLevels];
    } // basic constructor


    /**
     * Default constructor.
     *
     * Passes default values assigned in class as arguments to basic constructor.
     */
    public NaivePQ() {
        this(DEFAULT_LEVELS, DEFAULT_CAPACITY);
    } // default constructor


    /**
     * Adds an element to a queue, with a specified priority.
     *
     * @param element String with data to add to one of the queues.
     * @param withPriorityLevel int with the priority level for this data item.
     * @return false if requested queue is full.
     */
    public boolean add(final String element, final int withPriorityLevel) {
        // Boolean with outcome of operation; assumes queue is full
        boolean addedSuccessfully = false;
        // First, make sure given priority is legit value
        if (withPriorityLevel > -1 && withPriorityLevel < this.queues.length) {
            // Next, determine if requested queue has room
            if (this.usage[withPriorityLevel] < this.queues[withPriorityLevel].length) {
                this.queues[withPriorityLevel][this.usage[withPriorityLevel]] = element;
                this.usage[withPriorityLevel]++;
                addedSuccessfully = true;
            }
        }
        return addedSuccessfully;
    }  //method add

    public String pull() {
        String output = "Queues are empty";
        boolean removed = false;
        int priority = this.queues.length-1;
        while ((!removed) && priority >= 0) {
            if (this.usage[priority] == 0) {
                priority--;
            }
            else {
                output = this.queues[priority][0];
                this.usage[priority]--;
                removed = true;
            }
        }
        return output;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (AUTHOR.equals("")) {
            sb.append("Your assignment cannot be evaluated. You need to provide an author name.");
        } else {
            sb.append(String.format("\n\nStatus of %d priority lists created by %s:\n", this.queues.length, AUTHOR));
            for (int i = 0; i < this.queues.length; i++) {
                sb.append(String.format("\n Priority level %d [%d/%d]:", i, this.usage[i], this.queues[i].length));
                for (int j = 0; j < this.usage[i]; j++) {
                    sb.append(String.format(" %s |", this.queues[i][j]));
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        NaivePQ er = new NaivePQ();
        er.add("Leo",0);
        er.add("Mina", 1);
        er.add("Martin",1);
        er.add("Sarah",11);
        System.out.println(er.toString());
        System.out.println(er.pull());
        System.out.println(er.toString());
        System.out.println(er.pull());
        System.out.println(er.toString());
        System.out.println(er.pull());
        System.out.println(er.toString());
        System.out.println(er.pull());
        System.out.println(er.toString());
        System.out.println(er.pull());
        System.out.println(er.toString());
    }
}
