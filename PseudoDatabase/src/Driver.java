public class Driver {
    public static void main(String[] args) {
        Database demo = new Database();
        demo.createNewStudentRecord("Hercule Poirot");
        demo.createNewStudentRecord();
        demo.createNewStudentRecord();
        demo.createNewStudentRecord();

        demo.createNewCourseRecord();
        demo.createNewCourseRecord();
        demo.createNewCourseRecord();
        demo.createNewCourseRecord();

        demo.courseRegistration();
        demo.courseRegistration();
        demo.courseRegistration();
        demo.courseRegistration();
        demo.courseRegistration();
        demo.courseRegistration();
        demo.courseRegistration();
        demo.courseRegistration();

        demo.perStudentReport();

    }
}
