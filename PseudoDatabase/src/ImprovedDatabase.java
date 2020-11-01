public class ImprovedDatabase {

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
    }

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
    }


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
            String newStudentID = generateStudentID();
            // hash this newStudent into array students[]
            int bucket = hashFunction(newStudentName, students.length);
            students[bucket] = new Student(newStudentID, newStudentName, students[bucket]);
        }
        return success;
    }

    /**
     * Increments current value of studentID state variable by specified step;
     * the uses new value to create the ID string
     *
     * @return String with new student iD
     */
    private String generateStudentID() {
        studentIDState += studentIDstep;
        return String.format("LUC%05d", studentIDState);
    }

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
    }

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
    }


    /**
     * Create a new student record without checking if name exists
     */
    public void forceNewStudentRecord(String newStudentName) {
        String newStudentID = generateStudentID();
        // hash this newStudent into array students[]
        int bucket = hashFunction(newStudentName, students.length);
        students[bucket] = new Student(newStudentID, newStudentName, students[bucket]);
    }

    /**
     * Create new course record
     * @param courseCode
     * @param courseTitle
     */
    public void createNewCourseRecord(String courseCode, String courseTitle) {
        int bucket = hashFunction(courseTitle, courses.length);
        courses[bucket] = new Course(courseCode, courseTitle, courses[bucket]);
    }

    /**
     * Registers a student (by name) for a course (by title)
     * @param studentName
     * @param courseTitle
     */
    public void courseRegistration(String studentName, String courseTitle) {
        if (studentExists(studentName) && courseExists(courseTitle)) {
            String studentID = lookUpStudent(studentName);
            String courseCode = lookUpCourse(courseTitle);
            if (!registrationExists(studentID,courseCode)) {
                int bucket = hashFunction(studentID+courseCode, registrations.length);
                registrations[bucket] = new Registration(courseCode, studentID, registrations[bucket]);
            }
        }
    }

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
    }

    /**
     * Obtains a course's code (search by title)
     * @param courseTitle
     * @return
     */
    private String lookUpCourse(String courseTitle) {
        String courseCode = "NOT FOUND";
        boolean found = false;
        int bucket = hashFunction(courseTitle,courses.length);
        Course c = courses[bucket];
        while (!found & c != null) {
            if (c.getCourseTitle().equals(courseTitle)) {
                courseCode = c.getCourseCode();
                found = true;
            } else {
                c = c.next();
            }
        }
        return courseCode;
    }

    /**
     * Checks if a registration for a given (student, course) exists
     * @param studentID
     * @param courseCode
     * @return true if found; false otherwise
     */
    private boolean registrationExists(String studentID, String courseCode) {
        boolean found = false();
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
    }

    public void perStudentReport() {
        // HINT:
        // Students should be listed in alphabetical order by last name; before we get there
        // let's just list them in the way we can get them to get some functionality
        // going. Then add the alphabetical ordering sophistication.
        for (int bucket = 0; bucket<registrations.length; bucket++) {
            Registration r = registrations[bucket];
            while (r != null) {
                System.out.printf("\n%s: %s", r.getCourseCode(), r.getStudentID());
                r = r.next();
            }
        }
    }
}