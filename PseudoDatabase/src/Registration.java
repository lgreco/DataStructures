/**
 * Class for registration objects
 */
public class Registration {
    private String courseCode;
    private String studentID;
    private Registration next;

    /**
     * Full Constructor ...
     */
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

    public String getCourseCode() {
        return courseCode;
    }
    public String getStudentID() {
        return studentID;
    }
    public Registration next() {
        return next;
    }
}
