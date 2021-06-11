import java.util.Scanner;

/**
 * A "back in my day" class to plot a simple function by emulating a
 * character-addressable terminal. The function is of the form
 *    y = f(x)
 * and we assume it's bounded above and beyond, at least in the
 * interval we wish to plot it.
 *
 * The plot interval is between
 *    fromX and toX
 * The traversing step is determined by the character resolution of the
 * plot, given in rows and columns
 *    stepping = Math.abs(fromX-toX) / ((double) columns)
 *
 * The plot is presented as a character-based output across a user-specified
 * number of rows and columns.
 *
 */
public class Plots {

    /*
    Instead of worrying too much about variables passing to/from methods,
    we are setting up the following variables for use by any method of
    our class.
     */

    public static double minY = Double.MAX_VALUE; // Initialize min value
    public static double maxY = Double.MIN_VALUE; // Initialize max value
    public static double fromX, toX, xStepping; // Declaring domain for x variable
    public static double yStepping; // y-stepping --- do we really need it?
    public static int rows, columns; // the "resolution" of our plot
    public static String plotCharacter = "*", // character to use for plot
            horizontalAxis = "-", // character for horizontal line
            verticalAxis = "|", // character for vertical line
            intersection = "+", // character for h/v crossings
            spaceCharacter = " "; // obvious but informative

    public static double f(double x) {
        return Math.sin(x);
    } // method (function) f

    /**
     * Obtain from/to values, rowXcol resolution, and
     * derive stepping
     */
    public static void setUp() {
        Scanner s = new Scanner(System.in);
        System.out.println("Hello and welcome to the graphic plotter.");
        System.out.printf("\nEnter the interval you wish:\nfrom x = ");
        fromX = s.nextDouble();
        System.out.printf("to x = ");
        toX = s.nextDouble();
        System.out.printf("\n\nEnter graph resolution:\nhow many rows? ");
        rows = s.nextInt();
        System.out.printf("And how many columns? ");
        columns = s.nextInt();
        // Derive x-stepping and y-stepping
        xStepping = Math.abs(fromX - toX) / ((double) columns); // derive stepping
        findMinMax();
        yStepping = Math.abs(maxY - minY) / ((double) rows);
        // report summary of computations
        System.out.printf("\n\nAwesome! We'll plot the function from %.3f to %.3f on a %d X %d grid\n",
                fromX, toX, rows, columns);
        System.out.printf("\nThe dx is %.4f. The dy is %.4f with min = %.3f and max = %.3f",
                xStepping, yStepping, minY, maxY);
    } // method Setup

    /**
     * Method that traverses the function to plot within the specified interval
     *    [ fromX, toX ]
     *  and finds in max and min values.
     *
     *  Using a for-loop with a double variable is not prohibited, but we may
     *  to think about it: is there a way to traverse the function using a
     *  for-loop with an integer variable? How?
     */
    public static void findMinMax() {
        for (double x = fromX; x < toX; x += xStepping) {
            double y = f(x); // obtain function value at x
            minY = (y<minY) ? y : minY; // assess min
            maxY = (y>maxY) ? y : maxY; // assess max
        }
    } // method findMinMax

    /**
     * The principal method of this class and the subject of this week's
     * major assignment. In class we discussed how to conceptualize the
     * plot space as a two-dimensional block of cells. Each cell can hold
     * only one character: a space, a vertical bar (|), a horizontal
     * dash (-), a cross (+), or an asterisk (*). There are
     *    rows X columns
     * such cells. A String array is a good place to hold them.
     */
    public static void plot() {
        /*
        Create the String array. The array has as many rows as the number of
        rows we wish to use for our plot; likewise for its number of columns.
         */
        String screen[][] = new String[rows][columns];

        /*
        We now traverse the screen array and determine what to place in
        each of its cells
         */

        for (int j = 0; j < columns; j++) { // loop over each column (why columns first?) :-)
            for (int i = 0; i < rows; i++) { // loop over each row
                /*
                WRITE SOME NICE CODE HERE!

                screen[i][j] is the cell on our plot that corresponds to the
                i-th row and the j-th column. This cell must be assigned one
                of the following values:

                plotCharacter (*) --- if the function reaches this position,
                horizontalAxis (-) --- if the x-axis goes through this cell
                verticalAxis (-) --- if the y-axis goes through this cell
                intersection (+) --- if the x and y axes intersect here
                spaceCharacter ( ) --- if none of the above

                What is the condition to check if the function cross the cell
                at [i][j]? What is the condition to tell if one or both the
                axes cross here? If both an axis and the function need to
                occupy this cell what do you do? etc etc etc
                 */
            }
        }
    } // method plot

    /** Driver method */
    public static void main(String[] args) {
        setUp();
    }

} // class Plots