public class Database {

    /** Underlying array for student records */
    Student[] students = new Student[10];

    /** Underlying array for course records */
    Course[] courses = new Course[10];

    /** Underlying array for registration transactions */
    Registration[] registrations = new Registration[10];

    /** Inner class for registration objects */
    class Registration{
        private String courseCode;
        private String studentID;
        private Registration next;
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
        return 1;
    }

    public boolean createNewStudentRecord() {
        boolean success = false;
        // Some awesome code from the best section of COMP 271 ever
        return success;
    }

    public void forceNewStudentRecord() {
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
