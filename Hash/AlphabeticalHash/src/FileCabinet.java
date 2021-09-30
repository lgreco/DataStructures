/**
 * A class that emulates a file cabinet with a specified number of drawers. Each drawer contains files represented by
 * a simple linked list. And each file is a student record.
 */
public class FileCabinet {

    /** The underlying array for the cabinet */
    private StudentRecord[] drawer;

    /** How many drawers in this file cabinet */
    private int capacity;

    /** How many drawers are used? */
    private int size;


    /** Sole constructor based on capacity */
    public FileCabinet(int capacity) {
        this.capacity = capacity;
        drawer = new StudentRecord[capacity];
        size = 0;
    } // constructor FileCabinet


    /**
     * Principal hash function: it returns the integer division remainder for the passed value.
     * @param value int to hash
     * @return value's module with class' capacity
     */
    private int hashOf(int value) {
        return value % capacity;
    }


    /**
     * Overloaded hash function, using a string as input. The function finds the first letter of the passed
     * string and uses its numeric value (ASCII) to call the principal hash function.
     * @param string String to hash according to the numeric value of its first letter.
     * @return a call to the principal hash function with the numeric value of the input strings first letter.
     */
    private int hashOf(String string) { return hashOf((int) string.charAt(0)); }


    /**
     * Overloaded hash function, using a Student object as input. The function pulls the object's field
     * for last name and passes it to the string-based version of the hash method.
     * @param student Student object to have its last name field hashed
     * @return a call to method hash, with a String (firstName) as argument.
     */
    private int hashOf(Student student) { return hashOf(student.getFirstName()); }


    /**
     * Add a student record to one of the drawers in the cabinet. The method checks the underlying data structure to
     * ensure there is no existing record, and then adds a new record.
     *
     * @param firstName
     * @param lastName
     * @param major
     */
    public void addStudentRecord(String firstName, String lastName, String major) {
        /*
        Make sure no such record exists. For now, we are searching by first and last name. This, of course, is
        done for illustrative purposes. Realistically, we expect multiple students to have the same name (e.g.,
        common names like John Smith). In a realistic application, we'll need a unique identifier for each student
        to accommodate name duplicates. For now it is ok to assume that no two students can have the same name.
         */
        if (!contains(firstName, lastName)) { // search by first and last name.
            int whichDrawer = hashOf(lastName); // Find what drawer this new record will go to
            Student newStudent = new Student(firstName, lastName, major); // Create a new Student object
            /*
            Instead of adding the new student record to the and of the linked list whose head is at drawer[],
            we make the record the new head of the list. This way we avoid traversing the list. And since
            we do not impose a specific order along the list, it doesn't really matter where we place the new
            record (beginning of end of the list).
             */
            drawer[whichDrawer] = new StudentRecord(newStudent, drawer[whichDrawer]); // add new record to the list.
            size++; // adjust size
        }
    } // method addStudentRecord


    /**
     * Tells if a student record already exists, based on first and last name matches.
     *
     * @param firstName
     * @param lastName
     * @return true if student with specified name already exists in corresponding drawer; false otherwise.
     */
    public boolean contains(String firstName, String lastName) {
        // Initialize the return boolean, assuming that the search will fail.
        boolean found = false;
        // If this student exists, which drawer has the record?
        int whichDrawer = hashOf(lastName);
        StudentRecord current = drawer[whichDrawer]; // Start from the head of the list and ...
        while (current != null) { // ... scan the list
            if (current.getStudent().getFirstName().equals(firstName)
                    && current.getStudent().getLastName().equals(lastName)) {
                found = true;
            }
            current = current.getNext();
        }
        return found;
    } // public contains


    /**
     * Removes a file (a student record) from the file cabinet
     * @param firstName
     * @param lastName
     */
    public void remove(String firstName, String lastName) {
        // What drawer do we expect for this record?
        int whichDrawer = hashOf(lastName);
        if (drawer[whichDrawer] != null) { // If the drawer that *may* contain the record is not empty
            /* First check if the record to delete is the first record (head) of the list */
            if (drawer[whichDrawer].getStudent().getFirstName().equals(firstName) && drawer[whichDrawer].getStudent().getLastName().equals(lastName)) {
                drawer[whichDrawer] = drawer[whichDrawer].getNext();
            } else {
                /* Otherwise we need to scan the list */
                StudentRecord current = drawer[whichDrawer]; // Start from the head of the list and ...
                while (current.getNext()!=null
                        && (!current.getStudent().getFirstName().equals(firstName)
                        && ! current.getStudent().getLastName().equals(lastName))) { // ... scan the list
                    current = current.getNext();
                }
                /*
                At the end of this scan we have either found the record to delete, or we didn't find it
                because no such student exists. If no such student exists, we've reached the end of the
                list and the current record's next point is null, so the following if-statement will not
                execute. Otherwise, we found the record, and all we need to do is bypass it.
                 */
                if (current.getNext()!=null) {
                    current.setNext(current.getNext().getNext()); // Bypass found student record
                    size--; // adjust size
                }
            }
        }
    } // method remove


    /**
     * Method to display file cabinet
     */
    public void printContents() {
        System.out.printf("\n\nYour file cabinet has %d drawers and a total of %d records.\n",capacity,size );
        for (int i = 0; i < capacity; i++) {
            StudentRecord current = drawer[i];
            System.out.printf("\n Drawer [%02d]: ",i);
            if (current==null) {
                System.out.printf("is empty.");
            } else {
                while (current.getNext()!=null) {
                    System.out.printf("%s. %s,  ", current.getStudent().getFirstName().substring(0,1), current.getStudent().getLastName());
                    current = current.getNext();
                }
                System.out.printf("%s. %s", current.getStudent().getFirstName().substring(0,1), current.getStudent().getLastName()); // fence post printout
            }
        }
        System.out.printf("\n");
    } // method printContents


    /**
     * Method to display hash values for the contents of each drawer
     */
    public void showHashes() {
        System.out.printf("\n\nHASH VALUES. For each record in a drawer, we show the first letter of the student's last" +
                "\nname, following by that letter's numeric code and the modulo function (%%) with the" +
                "\ncapacity (%d) of the cabinet.\n", capacity);
        for (int i = 0; i < capacity; i++) {
            StudentRecord current = drawer[i];
            System.out.printf("\n Drawer [%02d]: ",i);
            if (current==null) {
                System.out.printf("is empty.");
            } else {
                while (current.getNext()!=null) {
                    System.out.printf("(%s): %d %% %d = %d,  ", current.getStudent().getLastName().charAt(0),
                            ((int) current.getStudent().getLastName().charAt(0)),
                            capacity,
                            hashOf(current.getStudent().getLastName().charAt(0)));
                    current = current.getNext();
                }
                int firstLetter = current.getStudent().getLastName().charAt(0);
                int hashValue = hashOf(firstLetter);
                System.out.printf("(%s): %d %% %d = %d ", current.getStudent().getLastName().charAt(0),
                        ((int) current.getStudent().getLastName().charAt(0)),
                        capacity,
                        hashOf(current.getStudent().getLastName().charAt(0))); // fence post printout
            }
        }
        System.out.printf("\n\n");
    } // method printContents

} // class FileCabinet
