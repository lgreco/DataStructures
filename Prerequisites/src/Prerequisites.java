import java.util.Arrays;

/**
 * A simple class to manage course prerequisites. Prerequisites for a course are
 * organized as a product of sums, e.g.,
 *     (x1+x2+x3)(x4+x5)(x6+x7+x8)(x9)...
 *  when parenthesized terms above are maxterms in a Conjuctive Normal Form (CNF)
 *  expression.The CNF above means that the prerequisites are:
 *     (x1 or x2 or x3) and (x4 or x5) and (x6 or x7 or x8) and (x9) etc
 * The class is based on a correlation matrix (array prerequisiteMatrix)
 * that captures the CNF.
 *
 * @author leo@cs.luc.edu
 *
 * Items to implement in future revisions:
 *
 *  - dynamic resizing of arrays as more courses added;
 *  - removal of prerequisites
 *  - validation of arguments (e.g. is "WZYZ 123" a valid course? are we addinng
 *    a duplicate?)
 *  - descriptive statistics: how many courses without prereqs; foundation
 *    courses (ie courses that are required prior to taking many other
 *    courses), etc.
 *
 */
public class Prerequisites {

    private static final int DEFAULT_SIZE = 25;
    /** For resizing purposes */
    private static final int DEFAULT_INCREMENT = 5;

    /** Array with prerequisite mapping */
    private int[][] prerequisiteMatrix;
    /** Array to match index value to course names */
    private String[] lookUpTable;

    /** Parametric constructor */
    public Prerequisites(int numberOfCourses) {
        prerequisiteMatrix = new int[numberOfCourses][numberOfCourses];
        lookUpTable = new String[numberOfCourses];
    } // constructor Prerequisites

    /**  Default constructor */
    public Prerequisites() {
        prerequisiteMatrix = new int[DEFAULT_SIZE][DEFAULT_SIZE];
        lookUpTable = new String[DEFAULT_SIZE];
    } // constructor Prerequisites

    /**
     * Method to initialize underlying arrays.
     *
     * Array lookupTable is a key-value pairm immitation matching array index
     * values to course names.
     *
     * Array prerequisiteMatrix is also initialized to -1, to avoid any
     * possible conflict between a value of 0 and an array index of 0.
     *
     * @param inputData Initial course list
     */
    void populateMatrix(String[] inputData) {
        int len = inputData.length;
        lookUpTable = inputData;
        // Sort lookUpTable for easier output
        Arrays.sort(lookUpTable);
        // This can be done with Arrays.fill but we are trying everything from scratch.
        // We need to fill the array with -1 instead of 0, because 0 has semantic value
        // in this problem.
        for ( int i = 0; i < len; i++ ) {
            for ( int j = 0; j < len; j++ ) {
                prerequisiteMatrix[i][j] = -1;
            }
        }
    } // method populateMatrix

    /**
     * Method to print out the correlation matrix.
     */
    void displayMatrix() {
        int len = prerequisiteMatrix[0].length;
        System.out.printf("            ");
        for ( int col = 0; col < len; col++ ) { System.out.printf("%10s",lookUpTable[col]); }
        System.out.printf("\n            ");
        for ( int col = 0; col < len; col++ ) { System.out.printf("      [%2d]",col); }
        for ( int row = 0; row < len; row++ ) {
            System.out.printf("\n%5s [%2d]",lookUpTable[row],row);
            for (int col = 0; col < len; col++ ) {
                // If no prerequisite, print "." instead of -1 to make output easier to read
                System.out.printf("%10s", (prerequisiteMatrix[row][col] == -1) ? "." : prerequisiteMatrix[row][col]);
            }
        }
    } // method displayMatrix

    /**
     * Method to convert a course code to its corresponding array index
     * @param course Course code
     * @return the course's array index value
     */
    int courseIndex(String course) {
        int index = 0;
        int len = lookUpTable.length;
        while ( index < len-1 && ! lookUpTable[index].equals(course) ) {
            index++;
        }
        return index;
    } // method courseIndex

    /**
     * Method to add CNF maxterms, in the form
     *      *   COMP 270 prerequisites are 118 or 141.
     *
     * Because maxterms are the basis of this class, we treat insertion as a
     * cyclic path; e.g., if COMP 270 prerequisites are 163 OR 170 OR 215, we map as
     * follows:
     *
     *   array index for ------->  [ 163 ]     [ 170 ]     [ 215 ]
     *   prerequisite course --->    170         215         163
     *
     * The "termination" of the path can be evaluated from
     *   value of last prerequisite course == index value of first prerequisite course
     * @param courses Array of course dependencies with the course of interest in [0]
     *                and its prerequisites as subsequent elements.
     */
    void addPrerequisites(String... courses) {
        int len = courses.length;
        int thisCourse = courseIndex(courses[0]);
        int firstCourse = courseIndex(courses[1]);
        int lastCourse = courseIndex(courses[len-1]);
        for ( int i = 1; i < len-1; i++ ) {
            int hasPrerequisite = courseIndex(courses[i]);
            int associatedWith = courseIndex(courses[i+1]);
            prerequisiteMatrix[thisCourse][hasPrerequisite] = associatedWith;
        }
        prerequisiteMatrix[thisCourse][lastCourse] = firstCourse;
    } // method addPrerequisites

    /**
     * Method to report prerequisites for a given course.
     * @param course Course code to report its prerequisites
     */
    void showPrerequisites(String course) {

        // Flag to tell us if the course has any prerequisites.
        boolean prerequisitesFound = false;

        // Number of courses
        int len = prerequisiteMatrix.length;

        // row number for the given course in the prerequisiteMatrix
        int thisCourse = courseIndex(course);

        // Set up a status array to avoid processing elements that have been processed already.
        boolean[] processed = new boolean[len];

        // Output string
        StringBuilder output = new StringBuilder("\nPrerequisites for " + course + ": ");

        // Scan the row of the given course
        for ( int col = 0; col < len; col++ ) {

            // one prerequisite at a time
            int prerequisite = prerequisiteMatrix[thisCourse][col];

            // Is there a prerequisite at this col position? And if yes, has it been processed?
            if ( prerequisite > -1 && !processed[prerequisite] ) {

                // The course has at least one prerequisite!
                prerequisitesFound = true;

                // It this a conjunctive term?
                if ( prerequisite == col ) {
                    output.append(lookUpTable[col]).append(" AND ");
                    // Mark this column processed; not necessary for conjunctive terms, but
                    // to be safe.
                    processed[prerequisite] = true;
                }

                // Is this a disjunctive term? Processing a disjunctive term requires a bit
                // more work.
                if ( prerequisite != col ) {
                    int initialCourse = prerequisite;
                    int currentCourse = prerequisite;
                    boolean continueLoop = true;
                    output.append(" ( ");
                    while ( continueLoop ) {
                        processed[currentCourse] = true;
                        output.append(lookUpTable[currentCourse]).append(" OR ");
                        currentCourse = prerequisiteMatrix[thisCourse][currentCourse];
                        continueLoop = !( currentCourse == initialCourse );
                    }
                    output.append(") AND ");
                }
            }
        }

        // If course has no prerequisites, indicate so on output.
        if ( !prerequisitesFound ) { output.append("None."); }
        System.out.println(output);
    } // method showPrerequisites

    /**
     * OK, let's put everything together and keep our fingers crossed.
     */
    public static void main(String[] args) {
        String[]   testData = {
                "COMP 141", "COMP 163", "COMP 170", "COMP 264", "COMP 272",
                "COMP 271", "COMP 310", "COMP 317", "COMP 363", "COMP 371",
                "STAT 203", "COMP 313",
                "MATH 118", "COMP 125", "COMP 150",
                "COMP 215",
                "MATH 201", "MATH 131", "MATH 161",
                "COMP 313",
                "MATH 132", "MATH 162"
        };

        int len = testData.length;
        Prerequisites demo = new Prerequisites(len);

        demo.populateMatrix(testData);

        // Data below based on www.cs.luc.edu as of Sept 2020
        demo.addPrerequisites("COMP 170", "MATH 118", "COMP 215", "COMP 150", "COMP 163");
        demo.addPrerequisites("COMP 264", "COMP 170", "COMP 215");
        demo.addPrerequisites("COMP 272", "COMP 163", "MATH 201");
        demo.addPrerequisites("COMP 272", "MATH 131", "MATH 161");
        demo.addPrerequisites("COMP 272", "COMP 170", "COMP 215");
        demo.addPrerequisites("COMP 272", "COMP 271");
        demo.addPrerequisites("COMP 271", "COMP 170", "COMP 215");
        demo.addPrerequisites("COMP 271", "COMP 141");
        demo.addPrerequisites("COMP 310", "COMP 264");
        demo.addPrerequisites("COMP 310", "COMP 271");

        demo.displayMatrix();

        for ( int i = 0; i < demo.lookUpTable.length; i++ ) {
            demo.showPrerequisites(demo.lookUpTable[i]);
        }

    } // method main
}