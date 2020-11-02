public class Course implements Comparable<Course>{

    private String courseCode;
    private String courseTitle;
    private Course next;

    /** Full constructor */
    public Course(String courseCode, String courseTitle, Course next) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.next = next;
    }

    /**
     * Method to return student information in a string like
     *   courseCode courseTitle
     * @returnn String with course information courseCode+" "+courseTitle
     */
    public String getCourseInformation(){
        return courseCode + " " + courseTitle;
    }

    /** Accessor for courseTitle */
    public String getCourseTitle(){
        return courseTitle;
    }

    /** Accessor for courseCode */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Accessor for field next. It is necessary because all class fields are
     * private and access to .next is essential when traversing a linked list
     * of objects from this class.
     * @return next Courae
     */
    public Course next() {
        return next;
    }

    /**
     * Implementation of the Comparable interface to compare courses.
     *   course1.comparesTo(course2) is
     *     -1 if course1 less than course2
     *      0 if course1 same as course2
     *      1 if course1 more than course2
     * The notions more "less", "same", and "more" are determined by the programmer.
     * @param course Course to compare to
     * @return -1, 0, or 1
     */
    @Override
    public int compareTo(Course course) {
        return courseCode.compareTo(course.courseCode);
    }
}
