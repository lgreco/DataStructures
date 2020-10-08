import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
public class HelloChain_Solution {

    private static final double FAIR_COIN = 0.5;
    private static final double LOADED_COIN_15_PERCENT = 0.15;
    private static final double LOADED_COIN_30_PERCENT = 0.30;
    private static final int MAX_TEMPS_FOR_NO_AUDIO = 3;


    private List<Student> studentsWithCameraOn = new ArrayList<>();
    private List<Student> studentsWithCameraOff = new ArrayList<>();
    private List<Student> ourGroup = new ArrayList<>();

    private Random r = new Random();

    /** Default constructor for HelloChain */
    public HelloChain_Solution() {
    }

    /** Flip a coin */
    private boolean flipCoin(double bias) {
        return r.nextDouble() > bias;
    } // method flipCoin

    /** Initialize students */
    private void initializeGroup() {
        for ( Student student:ourGroup ) {
            student.cameraOn = flipCoin(LOADED_COIN_15_PERCENT);
            student.speaker = flipCoin(FAIR_COIN);
            student.microphone = flipCoin(FAIR_COIN);
            if ( student.cameraOn ) {
                studentsWithCameraOn.add(student);
            } else {
                studentsWithCameraOff.add(student);
            }
        }
    } // method initializeGroup

    /**  */
    private Student pickStudent(boolean cameraOn) {
        Student candidateStudent = null;
        if ( cameraOn ) {
            // select from group with cameras on
            if ( studentsWithCameraOn.size() > 0 ) {
                // Group not empty; we may pick a student, then remove.
                int candidate = r.nextInt(studentsWithCameraOn.size());
                candidateStudent = studentsWithCameraOn.get(candidate);
                studentsWithCameraOn.remove(candidateStudent);
            }
        } else {
            // select from group with cameras off
            if ( studentsWithCameraOff.size() > 0 ) {
                // Group not empty; we may pick a student, then remove.
                int candidate = r.nextInt(studentsWithCameraOff.size());
                candidateStudent = studentsWithCameraOff.get(candidate);
                studentsWithCameraOff.remove(candidateStudent);
            }
        }
        return candidateStudent;
    } // method pickStudent

    /**
     * @param group  */
    private Student pickStudent(List<Student> group) {
        Student candidateStudent = null;
        if ( group.size() > 0 ) {
            // Group not empty; we may pick a student, then remove.
            int candidate = r.nextInt(group.size());
            candidateStudent = group.get(candidate);
            group.remove(candidateStudent);
        }
        return candidateStudent;
    } // method pickStudent

    /**
     *
     * The simulator
     *
     */
    public void helloChain() {

        if ( studentsWithCameraOn.size() > 0 ) { // while there are students in the group with cameras on...
            // start the simulation: instructor always calls student from those with camera on
            Student currentStudent = pickStudent(studentsWithCameraOn);
            // principal loop
            while ( studentsWithCameraOn.size() > 0 ) { // while there are students in the group with cameras on ...
                boolean cameraOn = true;
                if ( studentsWithCameraOff.size() > 0 ) { // allow prob for someone with camera off to be called
                    cameraOn = flipCoin(LOADED_COIN_30_PERCENT);
                }
                Student nextStudent = pickStudent(cameraOn);
                System.out.printf("\n\nStudent %s selects student %s to greet.\n", currentStudent.initials, nextStudent.initials);
                // what to do if nextStudent's camera is off?
                // print a diagnostic and continue with another choice
                if ( !nextStudent.cameraOn ) {
                    System.out.printf("\t%s's camera is off!\n\tLooking for another student.", nextStudent.initials);
                } else {
                    // explore more errors
                    // muted mic
                    boolean currentStudentMuted = flipCoin(FAIR_COIN);
                    String again = "";
                    while ( currentStudentMuted ) {
                        System.out.printf("\t%s's microphone is muted; trying again%s\n", currentStudent.initials, again);
                        currentStudentMuted = flipCoin(FAIR_COIN);
                        again = again + ", and again";
                    }
                    // no sound at receiving end
                    boolean noReceivingSound = true;
                    while ( noReceivingSound ) {
                        int attempts = 0;
                        boolean nextStudentBadAudio = flipCoin(FAIR_COIN);
                        while (nextStudentBadAudio && attempts < MAX_TEMPS_FOR_NO_AUDIO) {
                            System.out.printf("\t%s cannot hear %s's greeting ... %s tries again ... (attempt %d)\n", nextStudent.initials, currentStudent.initials, currentStudent.initials, attempts);
                            attempts++;
                            nextStudentBadAudio = flipCoin(FAIR_COIN);
                        }
                        if ( attempts >= MAX_TEMPS_FOR_NO_AUDIO ) {
                            // Put the student bnack into the respective group, we'll try working them later.
                            if ( nextStudent.cameraOn ) {
                                studentsWithCameraOn.add(nextStudent);
                            } else {
                                studentsWithCameraOff.add(nextStudent);
                            }
                            System.out.printf("\tNo luck; %s cannot hear us.\n", nextStudent.initials);
                            // Pick another student and try again ... keep things easy, make sure this one has camera on.
                            nextStudent = pickStudent(cameraOn);
                            System.out.printf("\t%s will now try greeting %s instead\n", currentStudent.initials, nextStudent.initials);
                        } else {
                            // success
                            noReceivingSound = false;
                        }
                    }
                    System.out.printf("\tAnd finally, %s greets %s!", currentStudent.initials, nextStudent.initials);
                    currentStudent = nextStudent;
                    // Remove the student from the greeting pool
                    if ( nextStudent.cameraOn) {
                        studentsWithCameraOn.remove(currentStudent);
                    } else {
                        studentsWithCameraOff.remove(currentStudent);
                    }
                }
            }
        } else {
            System.out.println("End of simulation");
        }
    } // method helloChain



    /** quick display */
    public void displayGroup(){
        for (Student s:ourGroup) {
            System.out.printf("Student %s:\n\tCamera: %b\n\tMicrophone: %b\n\tSpeaker: %b\n",s.initials, s.cameraOn, s.microphone, s.speaker);
        }
    } // method displayGroup


    public static void main(String[] args) {
        HelloChain_Solution COMP271section003Fall2020 = new HelloChain_Solution();
        COMP271section003Fall2020.readData();
        COMP271section003Fall2020.initializeGroup();
        COMP271section003Fall2020.displayGroup();
        COMP271section003Fall2020.helloChain();
    }

    class Student {
        String initials;
        boolean cameraOn;
        boolean microphone;
        boolean speaker;
        boolean greeted;
        Student(String initials) {
            this.initials = initials;
            this.cameraOn = false;
            this.microphone = false;
            this.speaker = false;
            this.greeted = false;
        }
    } // class Student

    /** Read file with student names, create objects */
    public void readData() {
        String[] individuals = new String[]
                { "AA", "AZ", "BH", "BN", "CS", "CC", "FW", "IA",
                        "JH", "JC", "KC", "KH", "KV", "LG", "LH",
                        "MS", "MP", "NF", "RB", "RJ", "RX", "SP",
                        "SS", "SG", "TS", "VR", "WP", "ZN", "ZA" };
        for ( String initials: individuals) {
            Student newStudent = new Student(initials);
            ourGroup.add(newStudent);
        }
    } // method readData

}
