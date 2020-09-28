import java.util.ArrayList;
import java.util.List;

/**
 * At the beginning of each online meeting, the instructor randomly greets a student
 * whose camera is on. That student greets, also at random, another student whose
 * camera is on. This chain continues until there is only one student with the
 * camera on. That student says hello to the instructor, concluding the hello chain.
 *
 * A lot of things can go wrong during the hello chain. For example a student's
 * audio may be muffled, muted, or noisy. We can't tell who the student greeted,
 * i.e., we don't know who's the next link in this hello chain. Likewise, the
 * student who has been greeted may not have heard their name. Or a student greets,
 * by mistake, a student whose camera is turned off, etc.
 *
 * Class HelloChain below, simulates the hello chain you have been practicing
 * at the beginning of our Zoom class session.
 */
public class HelloChain {

    List<Student> ourGroup = new ArrayList<>();


    /** Default constructor for HelloChain */
    public HelloChain() {
    }

    /** Read file with student names, create objects */
    public int readData() {

    }


    public static void main(String[] args) {
        HelloChain COMP271section003Fall2020 = null;
        COMP271section003Fall2020.readData();
    }

    private class Student {
        String firstName;
        String lastName;
        boolean cameraOn;
        Student() { cameraOn = true; }
        Student(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
            cameraOn = true;
        }
    }

}
