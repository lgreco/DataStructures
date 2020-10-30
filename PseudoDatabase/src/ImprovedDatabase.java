public class Database {

    /** Improves earlier code by removing a "magic number" */
    private static final int DEFAULT_CAPACITY = 10;

    /** Underlying array for student records */
    Student[] students = new Student[DEFAULT_CAPACITY];

    /** Underlying array for course records */
    Course[] courses = new Course[DEFAULT_CAPACITY];

    /** Underlying array for registration transactions */
    Registration[] registrations = new Registration[DEFAULT_CAPACITY];

    /** Inner class for registration objects */
    class Registration{
        private String courseCode;
        private String studentID;
        private Registration next;
        /** Full Constructor ... */
        public Registration(String courseCode, String studentID, Registration next) {
            /*
            Big question to contemplate here: where do we care of referential
            integrity: here or prior to the calling of the constructor? What
            is referential integrity? The affirmation that courseCode and studentID
            are valid data, i.e., exist in their corresponding structures.
             */
            this.courseCode = courseCode;
            this.studentID = studentID;
            this.next = next;
        }
    }

    /** Hash function ... since all hashable data in this problem are strings,
     * you may use a single hash function. Not the brightest idea but an
     * expeditious one given the limited time we have in the lab session.
     *
     * (NB: this was assigned as a lab project on 10/28/2020)
     *
     * (HINT: the String class has a hashcode method built-in. You may start
     * with that or you may ignore it completely).
     */
    private int hashFunction(String key) {
        /* Calling an overloaded method that provides more flexibility if
        we ever need to rehash on a base other than the lenght of the
        underlying array.
         */
        return hashFunction(key, DEFAULT_CAPACITY);
    }

    /**
     * Overloaded hashFunction that uses a specific base for modulo. It is
     * my choice to use .hashCode() as the integer representation of the string
     * and then hash it to % base.
     * @param key String to hash
     * @param base modulo base
     * @return abs(.hashCode()) % base
     */
    private int hashFunction(String key, int base) {
        return Math.abs(key.hashCode()) % base;
    }

    /**
     * Creates a new record for a student whose name is not alreay in the
     * database; if a student with same name exists, method does not create
     * a record and returns false.
     * @param studentName
     * @return true if recorded created; false if student name already in database
     */
    public boolean createNewStudentRecord(String studentName) {
        boolean success = false;
        if (contains(studentName)) {

        }
        return success;
    }

    private boolean contains(String studentName) {
        boolean c = false;
        for ()
    }

    public void forceNewStudentRecord(...) {
        // more amazing code ... By the way, do we need two separate methods to
        // create and force a new student record, really?
    }

    public void createNewCourseRecord() {}

    public void perStudentReport() {
        // HINT:
        // Students should be listed in alphabetical order by last name; before we get there
        // let's just list them in the way we can get them to get some functionality
        // going. Then add the alphabetical ordering sophistication.
    }
}
