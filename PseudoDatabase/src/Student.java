public class Student implements Comparable<Student>{

    private String studentID;
    private String studentName;

    /**
     * Method to return student information in a string like
     *   studentID studentName
     * @param studentID studentID that we wish to obtain information about
     * @returnn String with student information studentID+" "+studentName
     */
    public String getStudentInformation(String studentID){
    }

    /**
     * Implementation of the Comparable interface to compares students.
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
    }
}
