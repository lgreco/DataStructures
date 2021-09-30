import java.util.Arrays; // Enables .sort() calls -- too much to write our own!

public class ImprovedDatabase {

    /** Local tools */
    private static final String SPACE = " ";

    /**
     * Improves earlier code by removing a "magic number"
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Underlying array for student records
     */
    Student[] students = new Student[DEFAULT_CAPACITY];

    /**
     * Underlying array for course records
     */
    Course[] courses = new Course[DEFAULT_CAPACITY];

    /**
     * Underlying array for registration transactions
     */
    Registration[] registrations = new Registration[DEFAULT_CAPACITY];

    /**
     * Counts for objects stored in underlying arrays
     */
    private int studentCount = 0;
    private int courseCount = 0;
    private int registrationCount = 0;

    /**
     * Current state for student ID generator
     */
    private int studentIDState = 10; // start at 10;
    private int studentIDstep = 10; // increment by 10;

    /**
     * Hash function ... since all hashable data in this problem are strings,
     * you may use a single hash function. Not the brightest idea but an
     * expeditious one given the limited time we have in the lab session.
     * <p>
     * (NB: this was assigned as a lab project on 10/28/2020)
     * <p>
     * (HINT: the String class has a hashcode method built-in. You may start
     * with that or you may ignore it completely).
     */
    private int hashFunction(String key) {
        /* Calling an overloaded method that provides more flexibility if
        we ever need to rehash on a base other than the lenght of the
        underlying array.
         */
        return hashFunction(key, DEFAULT_CAPACITY);
    } // method hashFunction

    /**
     * Overloaded hashFunction that uses a specific base for modulo. It is
     * my choice to use .hashCode() as the integer representation of the string
     * and then hash it to % base.
     *
     * @param key  String to hash
     * @param base modulo base
     * @return abs(.hashCode ()) % base
     */
    private int hashFunction(String key, int base) {
        return Math.abs(key.hashCode()) % base;
    } // method hashFunction

    /**
     * Creates a new record for a student whose name is not alreay in the
     * database; if a student with same name exists, method does not create
     * a record and returns false.
     *
     * @param newStudentName
     * @return true if recorded created; false if student name already in database
     */
    public boolean createNewStudentRecord(String newStudentName) {
        boolean success = false;
        if (!studentExists(newStudentName)) {
            success = true;
            studentCount++;
            String newStudentID = generateStudentID();
            // hash this newStudent into array students[]
            int bucket = hashFunction(newStudentName, students.length);
            // add newStudent to the front of the linked list (constant time insertion)
            students[bucket] = new Student(newStudentID, newStudentName, students[bucket]);
        }
        return success;
    } // method createNewStudentRecord

    /**
     * Increments current value of studentID state variable by specified step;
     * the uses new value to create the ID string
     *
     * @return String with new student iD
     */
    private String generateStudentID() {
        studentIDState += studentIDstep;
        return String.format("LUC%05d", studentIDState);
    } // method generateStudentID

    /**
     * This is a hash-agnostic method, i.e., it does not take it for granted that student
     * records are hashed by studentName, so it scans the entire structure.
     *
     * @param studentName
     * @return
     */
    private boolean studentExists(String studentName) {
        boolean found = false;
        int bucket = 0;
        while (!found && bucket < students.length) {
            Student s = students[bucket];
            while (!found && s != null) {
                if (s.getStudentName().equals(studentName)) {
                    found = true;
                } else {
                    s = s.next();
                }
            }
            bucket++;
        }
        return found;
    } // method studentExists

    /**
     * Create a new student record without checking if name exists
     */
    public void forceNewStudentRecord(String newStudentName) {
        String newStudentID = generateStudentID();
        studentCount++;
        // hash this newStudent into array students[]
        int bucket = hashFunction(newStudentName, students.length);
        // add newStudent to the front of the linked list (constant time insertion)
        students[bucket] = new Student(newStudentID, newStudentName, students[bucket]);
    } // method forceNewStudentRecord

    /**
     * Hash-agnostic method to tell if a course exists.
     * @param courseTitle Search by course title
     * @return true if course exists, false otherwise.
     */
    private boolean courseExists(String courseTitle) {
        boolean found = false;
        int bucket = 0;
        while (!found && bucket < courses.length) {
            Course c = courses[bucket];
            while (!found && c != null) {
                if (c.getCourseTitle().equals(courseTitle)) {
                    found = true;
                } else {
                    c = c.next();
                }
            }
            bucket++;
        }
        return found;
    } // method courseExists

    /**
     * Create new course record
     * @param courseCode
     * @param courseTitle
     */
    public void createNewCourseRecord(String courseCode, String courseTitle) {
        courseCount++;
        int bucket = hashFunction(courseTitle, courses.length);
        // add new course to the front of the linked list (constant time insertion)
        courses[bucket] = new Course(courseCode, courseTitle, courses[bucket]);
    } // method createNewCourseRecord

    /**
     * Registers a student (by name) for a course (by title). Registration transaction comprises
     * the studentID and the courseCode. The transaction is hashed into hashmap registrations
     * using the hashcode of the concatenation of studentID and courseCode.
     * @param studentName
     * @param courseTitle
     */
    public void courseRegistration(String studentName, String courseTitle) {
        if (studentExists(studentName) && courseExists(courseTitle)) {
            String studentID = lookUpStudent(studentName);
            String courseCode = obtainCourseCode(courseTitle);
            if (!registrationExists(studentID,courseCode)) {
                registrationCount++;
                int bucket = hashFunction(studentID+courseCode, registrations.length);
                // add registration to the front of the linked list (constant time insertion)
                registrations[bucket] = new Registration(courseCode, studentID, registrations[bucket]);
            }
        }
    } // method courseRegistration

    /**
     * Obtains the student's ID (search by name)
     * @param studentName
     * @return
     */
    private String lookUpStudent(String studentName) {
        String studentID = "NOT FOUND";
        boolean found = false;
        int bucket = hashFunction(studentName,students.length);
        Student s = students[bucket];
        while (!found && s != null) {
            if (s.getStudentName().equals(studentName)) {
                studentID = s.getStudentID();
                found = true;
            } else {
                s = s.next();
            }
        }
        return studentID;
    } // method lookUpStudent

    /**
     * Obtains a course's code (search by title)
     * @param courseTitle
     * @return
     */
    private String obtainCourseCode(String courseTitle) {
        String courseCode = "NOT FOUND";
        boolean found = false;
        int bucket = hashFunction(courseTitle,courses.length);
        Course c = courses[bucket];
        while (!found && c != null) {
            if (c.getCourseTitle().equals(courseTitle)) {
                courseCode = c.getCourseCode();
                found = true;
            } else {
                c = c.next();
            }
        }
        return courseCode;
    } // method obtainCourseCode

    /**
     * Obtains a course's title (search by code)
     * @param courseCode
     * @return
     */
    private String obtainCourseTitle(String courseCode) {
        String courseTitle = "NOT FOUND";
        boolean found = false;
        int bucket = 0;
        while (!found && bucket < courses.length) {
            Course c = courses[bucket];
            while (!found && c != null) {
                if (c.getCourseCode().equals(courseCode)) {
                    courseTitle = c.getCourseTitle();
                    found = true;
                } else {
                    c = c.next();
                }
            }
            bucket++;
        }
        return courseTitle;
    } // method obtainCourseTitle

    /**
     * Checks if a registration for a given (student, course) exists
     * @param studentID
     * @param courseCode
     * @return true if found; false otherwise
     */
    private boolean registrationExists(String studentID, String courseCode) {
        boolean found = false;
        int bucket = 0;
        while (!found && bucket < registrations.length) {
            Registration r = registrations[bucket];
            while (!found && r != null) {
                if (r.getCourseCode().equals(courseCode) && r.getStudentID().equals(studentID)) {
                    found = true;
                } else {
                    r = r.next();
                }
            }
            bucket++;
        }
        return found;
    } // method registrationExists

    /**
     * Rudimentary report (imitates SQL's GROUP BY clause). The method executes in three parts.
     *
     * First, it creates an alphabetically sorted list of all students. To accomplish that, it
     * unravels the hashmap from students[] into an array sortedStudents[]. The hashmap students[]
     * is an array of linked lists. Array sortedStudents has no linked lists in it; or if you prefer,
     * each element of sortedStudents[] is a linked list with one node only. So we can apply
     * Array.sort() on sortedStudents[] and get an alphabetical re-ordering of its elements. Method
     * Array.sort() works on this array because its building block, class Student, implements the
     * Comparable interface. Arrays.sort() presupposes the implementation of the Comparable interface.
     *
     * Second, the method goes student-by-student through the sorted array, and for each student
     * pulls the corresponding courses codes from the registrations[] hashmap. It places these codes
     * in a String array (remember, courseCodes are Strings), and sorts them alphabetically.
     *
     * And third, for each course code, we pull the course title, compose and output string, and
     * when we are done with each student, print that string, and repeat with the next student.
     */
    public void perStudentReport() {

        /*
        First part:
        Unravel the students[] hashmap into a linear array, by moving every node
        from every linked list into an individual position in the new array. While at it,
        we are looking for the longest student name and the longest ID number; we'll
        need these to format our output and accommodate names.

        One more thought about this first part: it can be its own method, and reused
        for other hashmaps.
         */
        Student[] sortedStudents = new Student[studentCount]; // linear array
        int sortedIndex = 0; // index for linear array
        int longestNameLength = 0; // student name max length
        int longestIDLength = 0; // student ID max length
        // copy every node from students[] to studentsSorted[] in a linear fashion
        for (int bucket = 0; bucket < students.length; bucket++) {
            Student s = students[bucket];
            while (s != null) {
                longestNameLength = (s.getStudentName().length() > longestNameLength) ? s.getStudentName().length() : longestNameLength;
                longestIDLength = (s.getStudentID().length() > longestIDLength) ? s.getStudentID().length() : longestIDLength;
                sortedStudents[sortedIndex] = s;
                sortedIndex++;
                s = s.next(); // .next() ??? Well yes. See class Student for details.
            }
        }
        // Sort the array:
        Arrays.sort(sortedStudents);

        /*
        Second part:
        Go through array sortedStudents[] one student at a time, pull the student's
        registration record, sort those courses alphabetically, and produce an output
        string to print, before repeating the process for the next student. This part
        includes the method's third part as well.
         */

        // Use information about longest name and ID to create a formatting directing
        //    "%Ns %Ms: "
        // where N and M are the lengths of the longest name and ID respectively.
        String formatting = "%" + longestIDLength + "s %" + longestNameLength + "s: ";

        for (int index = 0; index < sortedStudents.length; index++) {
            Student s = sortedStudents[index];

            // Begin building the output string for this student; use the formatting string from above
            // to ensure the proper spacing.
            String outputForThisStudent = String.format(formatting, s.getStudentID(), s.getStudentName());

            /*
            Scan the entire registration table and find all the courses for this student. The code block
            below essentially repeats the "linearization" functionality of the first part. The array here
            is just a String because we are pulling courseCodes only from the registrations[] hashmap.
            The array is initialized to [courseCount] because it is unlikely that a student would be signed
            up for more courses than those available. It is expected that we will not fill this array, so
            we'll have to trim it later, before sorting it -- otherwise there will be many NULL courses.
             */
            int thisStudentCoursesIndex = 0;
            String[] coursesForThisStudent = new String[courseCount];
            for ( int bucket = 0; bucket < registrations.length; bucket++) {
                Registration r = registrations[bucket];
                while (r != null) {
                    if (r.getStudentID().equals(s.getStudentID())) {
                        coursesForThisStudent[thisStudentCoursesIndex] = r.getCourseCode();
                        thisStudentCoursesIndex++;
                    }
                    r = r.next(); // .next() ??? Yes, see class Registration for details.
                }

            }
            // Resize the array of courses for this student to the number of courses found (which is
            // the last value of thisStudentCoursesIndex
            String sortedCourses[] = new String[thisStudentCoursesIndex];
            for (int i=0; i < thisStudentCoursesIndex; i++) {
                sortedCourses[i] = coursesForThisStudent[i];
            }

            // Now we can sor course codes alphabetically
            Arrays.sort(sortedCourses);

            /*
            Third part:
            Go through the course codes for this student, pull the matching course title from hashmap courses[],
            complete the output string, and print it.
             */
            if (sortedCourses.length > 0) { // If length == 0, no courses
                // Formatting for first course is always different because it's printed next to student name.
                String registeredCourseName = obtainCourseTitle(sortedCourses[0]);
                outputForThisStudent += String.format("%s %s\n", sortedCourses[0], registeredCourseName);
                if (sortedCourses.length > 1) {
                    // Subsequent courses require appropriate spacing provided by longestIDLength+longestNameLength
                    for (int courseIndex = 1; courseIndex < sortedCourses.length; courseIndex++) {
                        registeredCourseName = obtainCourseTitle(sortedCourses[courseIndex]);
                        outputForThisStudent += String.format("%s %s %s", SPACE.repeat(longestIDLength + longestNameLength + 2), sortedCourses[courseIndex], registeredCourseName);
                    }
                }
            } else { // No courses ...
                outputForThisStudent += String.format("%s", "No courses found");
            }

            // Print it!
            outputForThisStudent += String.format("\n");
            System.out.println(outputForThisStudent);
        }
    } // method perStudentReport
} // class ImprovedDatabase
