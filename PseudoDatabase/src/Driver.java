public class Driver {
    public static void main(String[] args) {

        ImprovedDatabase demo = new ImprovedDatabase();

        demo.createNewStudentRecord("Hercule Poirot");
        demo.createNewStudentRecord("Arthur Hastings");
        demo.createNewStudentRecord("Felicity Lemon");
        demo.createNewStudentRecord("Ariadne Oliver");
        demo.createNewStudentRecord("Leo Irakliotis");

        demo.createNewCourseRecord("COMP271","Data Structures");
        demo.createNewCourseRecord("COMP163","Discrete Structures");
        demo.createNewCourseRecord("COMP363","Algorithms");
        demo.createNewCourseRecord("COMP170","Intro to OOP");

        demo.courseRegistration("Hercule Poirot", "Data Structures");
        demo.courseRegistration("Hercule Poirot", "Algorithms");
        demo.courseRegistration("Arthur Hastings", "Intro to OOP");
        demo.courseRegistration("Arthur Hastings", "Discrete Structures");
        demo.courseRegistration("Felicity Lemon", "Intro to OOP");
        demo.courseRegistration("Felicity Lemon", "Algorithms");
        demo.courseRegistration("Ariadne Oliver", "Algorithms");
        demo.courseRegistration("Ariadne Oliver", "Intro to OOP");

        demo.perStudentReport();

    }
}
