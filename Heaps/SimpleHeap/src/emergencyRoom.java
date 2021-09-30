/**
 * <p>A simple heap class with the maximum value as root. This heap can be described as a complete binary tree that
 * meets that <i>max-heap property:</i> the children of every node have smaller values than their parent. For example,
 * if the nodes contain strings, the max-heap property will dictate this arrangement:</p>
 *
 * <pre>
 *                                      "Seattle"
 *                                     /         \
 *                                    /           \
 *                          "New York"             "Chicago"
 * </pre>
 *
 * <p>Notice that the left/right placement of data under a node does not follow the binary <b>search</b> tree property.
 * The heap tree is a binary tree, i.e., every node has up to two children, but it is not a binary search tree, i.e.,
 * the smaller-to-the-left/larger-to-the-right restriction doesn't apply.</p>
 *
 * <p>Instead of an actual tree, we use an array of Patient objects to model the binary tree. We can do this because
 * the tree is expected to be complete, i.e., every node will have two children except for the leaf nodes (the nodes
 * at the bottom). And so we can even estimate the size of the array: if the tree has L levels, the array will
 * have 2^L - 1 elements. And all we need now is a formula that will give us the parent and children of any node
 * in the array.</p>
 *
 * <p>Assuming that the tree root is assigned at the [0] position in the array, we can deduce the following rules:
 * If a node is at position [i], its parent is at position (i - 1)/2
 *                               its left child is at position (2*i) + 1
 *                               and its right child is at position (2*i) + 2
 * </p>
 *
 * <p>This implementation of a max-heap uses the object Patient, to simulate triage at an Emergency Department.
 * For this implementation we use the Patient class to populate the max-heap. Each node of the heap tree is a
 * Patient object. These objects comprise a String with the patient's name, and an int value indicating the
 * severity of their condition. The higher the severity the higher the patient is on the priority queue to the ER.</p>
 */
public class emergencyRoom {

    /** Array of patients */
    private Patient waiting[];

    /** How many patients are waiting? */
    private int numberOfPatients;

    /** How many patients can we fit in this ER? */
    private int capacity;


    /**
     * Basic constructor. It creates an emergency room with the specified capacity. Ideally, we want this capacity to
     * be a number in the form 2^L - 1, e.g. 7, 15, 31, etc, to match the number of nodes of a complete binary tree
     * with L levels. We can modify the constructor later for that.
     *
     * @param capacity int with the number of patients than can fit in the ER waiting room
     */
    public emergencyRoom(int capacity) {
        this.capacity = capacity;
        this.numberOfPatients = 0;
        this.waiting = new Patient[capacity];
    } // basic constructor


    /**
     * Method to admit a patient to the ER if there is room.
     *
     * @param name String with name of the patient
     * @param severity int indicating the severity of the patient's medical severity.
     * @return false if there is no space for one more patient; true otherwise.
     */
    public boolean admitPatient(String name, int severity) {
        boolean admissionPossible = (numberOfPatients < capacity);
        if (admissionPossible) {
            Patient newArrival = new Patient(name, severity, System.nanoTime()); // captures time of admission
            addToHeap(newArrival);
        }
        return admissionPossible;
    } // method admitPatient


    /**
     * Method to add a new patient to the heap and initiate re-ordering of the array. The method is private because
     * it is front-ended by method admitPatient. That method checks to ensure that there is space available in the
     * ER waiting room before calling addToHeap, passing a patient object along.
     *
     * @param patient Patient object to be added to the heap array.
     */
    private void addToHeap(Patient patient) {
        waiting[numberOfPatients] = patient;
        int currentPosition = numberOfPatients; // Remember position of newly admitted patient
        numberOfPatients++; // Updates count of patients in the waiting room.
        /*
        The following loop ensures that the severity of the newly arrived patient does not violate the max-heap
        property. It checks if its severity is greater than the severity of the patient in the parent node; and if
        it is, it swaps them, and repeats until it reaches a satisfying condition or the root of the tree.
         */
        while ((hasParent(currentPosition)) && (waiting[currentPosition].getSeverity() > waiting[parentOf(currentPosition)].getSeverity())) {
            swap(currentPosition, parentOf(currentPosition));
            currentPosition = parentOf(currentPosition);
        }
    } // method addtoHeap


    /**
     * Method to swap positions between two patients in the waiting room.
     * @param fromPosition int position of first patient
     * @param toPosition int position of second patient
     */
    private void swap(int fromPosition, int toPosition) {
        Patient hold = waiting[fromPosition];
        waiting[fromPosition] = waiting[toPosition];
        waiting[toPosition] = hold;
    } // method swap


    /**
     * Method to examine the next patient with the highest severity. The method pulls the [0] element from
     * the waiting room array -- that's always the highest severity. It then moves the most recently admitted
     * patient to the front of the line and reorders the line.
     *
     * @return Patient to be treated next.
     */
    public Patient treatNextPatient() {
        Patient nextPatient = null;
        if (numberOfPatients > 0) {
            nextPatient = waiting[0];
            int sub = numberOfPatients-1;
            waiting[0] = waiting[sub];
            numberOfPatients--;
            reorganize(0);
        }
        return nextPatient;
    } // method treatNextPatient


    private void reorganize(int s) {
        int largest;
        if (hasLeft(s)) {
            if (waiting[leftOf(s)].getSeverity() > waiting[s].getSeverity()) {
                largest = leftOf(s);
            } else {
                largest = s;
            }
            if (hasRight(s)) {
                if (waiting[rightOf(s)].getSeverity() > waiting[largest].getSeverity()) {
                    largest = rightOf(s);
                }
            }
            if (largest != s) {
                swap(s,largest);
                reorganize(largest);
            }
        }
    }

    public int parentOf(int position) {
            return (position - 1) / 2;
    }

    public int leftOf(int position) {
            return (2 * position) + 1;
    }

    public int rightOf(int position) {
            return (2 * position) + 2;
    }

    public boolean isLeaf(int position) {
        return ((position >= capacity/2) && (position < capacity));
    }

    public boolean hasLeft(int position) {
        return leftOf(position) < numberOfPatients;
    }

    public boolean hasRight(int position) {
        return rightOf(position) < numberOfPatients;
    }

    public boolean hasParent(int position) {
        return parentOf(position) >= 0;
    }

    public String firstPatient() {
        String name = "ER IS EMPTY .. NO PATIENTS ARE WAITING.";
        if (numberOfPatients > 0) {
            name = waiting[0].getName();
        }
        return name;
    }

    public int getNumberOfPatients() {
        return numberOfPatients;
    }

    public void printHeap() {
        System.out.printf("\n\nHeap manifest:\n");
        for ( Patient p: waiting) {
            System.out.printf("\n\t %s has severity %d", p.getName(), p.getSeverity());
        }
    }

    public void statusReport() {
        System.out.printf("\n\nER status:\n");
        for (int i = 0; i < waiting.length; i++) {
            System.out.printf("[%03d] ",i);
        }
        System.out.println();
        for (int i = 0; i < numberOfPatients; i++) {
            System.out.printf("  %d   ", waiting[i].getSeverity());
        }
        System.out.println();
    }

}
