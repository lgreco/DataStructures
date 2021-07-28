/**
 * A linkable container for Student objects.
 *
 */
public class StudentRecord {

    /** The data portion of the linkable object */
    private Student student;

    /** A pointer to the next object in the chain */
    private StudentRecord next;


    /** Full constructor */
    public StudentRecord(Student student, StudentRecord next) {
        this.student = student;
        this.next = next;
    } // full constructor


    /** Partial constructor */
    public StudentRecord(Student student) {
        this.student = student;
        this.next = null;
    } // partial constructor


    /** Setters and getters */

    public Student getStudent() { return student; }

    public void setStudent(Student student) { this.student = student; }

    public StudentRecord getNext() { return next; }

    public void setNext(StudentRecord next) { this.next = next; }

} // class StudentRecord
