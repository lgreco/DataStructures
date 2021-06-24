public class Student implements Comparable<Student>{

    private String studentID;
    private String studentName;
    private Student next;

    /** Full constructor */
    public Student(String studentID, String studentName, Student next) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.next = next;
    }

    /**
     * Method to return student information in a string like
     *   studentID studentName
     * @param studentID studentID that we wish to obtain information about
     * @returnn String with student information studentID+" "+studentName
     */
    public String getStudentInformation(String studentID){
        return studentID + " " + studentName;
    }

    /**
     * Accessor for student's name
     * @return String with studentName
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * Accessor for student ID
     * @return String with studentID
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * Accessor for field next.
     *  It is necessary because all class fields are private and access to .next
     *  is essential when traversing a linked list of objects from this class.
     * @return next object
     */
    public Student next() {
        return next;
    }

    /**
     * Implementation of the Comparable interface to compare students.
     *   student1.comparesTo(student2) is
     *     -1 if student1 less than student2
     *      0 if student1 same as student2
     *      1 if student1 more than student2
     * The notions more "less", "same", and "more" are determined by the programmer.
     * @param student Student to compare to
     * @return -1, 0, or 1
     */
    @Override
    public int compareTo(Student student) {
        return studentName.compareTo(student.studentName);
    }
}
