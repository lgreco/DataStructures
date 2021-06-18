import java.util.Scanner;

/**
 *
 * A "back in my day" class to plot a simple function by emulating a
 * character-addressable terminal. The function is of the form
 *    y = f(x)
 * and we assume it's bounded above and below, at least in the
 * interval we wish to plot it.
 *
 * The plot interval is between
 *    fromX and toX
 * The traversing step is determined by the horizontal resolution of the
 * plot, given in columns
 *    xStepping = Math.abs(fromX-toX) / ((double) columns)
 *
 * The vertical resolution of the plot is given in rows.
 *
 * The plot is presented as a character-based output across a user-specified
 * number of rows and columns. The class is build around a "virtual screen",
 * i.e., an array with as many rows and columns as the required output
 * for the plot.
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
    public static int rows, columns; // the "resolution" of our plot
    public static String plotCharacter = "*", // character to use for plot
            horizontalAxis = "-", // character for horizontal line
            verticalAxis = "|", // character for vertical line
            intersection = "+", // character for h/v crossings
            spaceCharacter = " "; // obvious but informative
    public static String screen[][]; // virtual screen

    public static double f(double x) {
        return Math.sin(x);
    } // method (function) f


    /**
     * Lazy setUp method so that I don't have to type the same data every time
     * I run the code
     * @param xf from x
     * @param xt to x
     * @param r number of rows
     * @param c number of columns
     */
    public static void setUp(double xf, double xt, int r, int c) {
        fromX = xf;
        toX = xt;
        rows = r;
        columns = c;
    } // method setUp (lazy version)


    /**
     * Obtain from/to values, rowXcol resolution, and
     * derive stepping from console/user input
     */
    public static void setUp() {
        Scanner s = new Scanner(System.in);
        System.out.println("Hello and welcome to the graphic plotter.");
        System.out.printf("\nEnter the interval you wish:\nfrom x = ");
        fromX = s.nextDouble();
        System.out.printf("to x = ");
        toX = s.nextDouble();
        System.out.printf("\nEnter graph resolution:\nhow many rows? ");
        rows = s.nextInt();
        System.out.printf("And how many columns? ");
        columns = s.nextInt();
    } // method Setup


    /**
     * Method that performs computations to calculate the x-step as
     * the function's min/max.
     */
    public static void derive() {
        xStepping = Math.abs(fromX - toX) / ((double) columns); // derive x stepping
    } // method derive


    /**
     * Method that traverses the function to plot within the specified interval
     *    [ fromX, toX ]
     *  and finds its max and min values.
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
     * such cells. A String array is a good place to hold them. For simplicity
     * we are only adding the graph characters (*) and the horizontal line.
     *
     * We use simple proportional scaling to map the x and y intervals to
     * the corresponding number of columns and rows allocated to the graph.
     *
     * Analysis for the y-axis:
     *
     *    maxY --- row 0            We want maxY to be mapped to the first row
     *         |                    and minY to be mapped to the last row. These
     *         |                    are the top and bottom rows of array screen[][]
     *         |                    If the number of rows in array is
     *         .                       int rows
     *         .                    then the top row is at position 0 and the bottom
     *         .                    row is at position rows-1. The problem now is how
     *         |                    to map any value of y to one of there rows.
     *    minY --- row rows
     *                              The answer is the following scaling equation
     *                                 yRow = (rows-1) * (maxY - y) / (maxY-minY)
     *                              Notice that when y = maxY, yRow is 0, and when
     *                              y=minY then yRow = rows-1
     *
     * Analysis for the x-axis:
     *
     * We can perform a similar scaling analysis for the x axis but it is not
     * necessary. In this axis, the values of x are uniformly distributed between
     * xFrom and xTo. All we have to do is find one value of x between these two
     * boundaries, to map to each of the columns in the screen[][] array. There
     * are
     *    int columns
     * in the array, so the spacing between the uniformly distributed values of x
     * will be
     *    xStepping = ( xFrom - xTo ) / columns
     * And the values of x:
     *    xFrom, xFrom+xStepping, xFrom+2*xStepping, ...
     * are the values that correspond to each column and the values at which we
     * wish to evaluate the function f(x).
     *
     */
    public static void plot() {
        /*
        Create the String array. The array has as many rows as the number of
        rows we wish to use for our plot; likewise for its number of columns.
        This array is our "virtual screen".
         */
        screen = new String[rows][columns];

        /*
        Initialize the "virtual screen" to empty spaces
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                screen[i][j] = spaceCharacter;
            }
        }

        /*
        If function crosses y @ zero, draw horizontal line. We can tell that
        y crosses 0 if the function's max is positive and the min negative.
        In this case we identify which row corresponds to y=0, and we traverse it
        adding a horizontal mark on each cell.
         */
        if (minY < 0 && maxY > 0) { // zero cross confirmed
            // zeroRow corresponds to y=0
            int zeroRow = (int) Math.floor((rows-1) * (maxY)/(maxY-minY));
            // go over every character in this row and add a horizontal mark
            for (int j = 0; j <columns; j++) {
                screen[zeroRow][j] = horizontalAxis;
            }
        }


        /*
        We now traverse the screen array and determine what to place in
        each of its cells. The loop runs over columns so that we
        compute y=f(x) once per row.
         */
        double x = fromX; // this is where we plot from
        for (int j = 0; j < columns; j++) { // loop over each column
            double y = f(x); // function value at x

            /*
            Assume that j=0, i.e., the first row in screen[][] is the top row
            of the plot and therefore it corresponds to maxY. Also assume that
            j=rows is the bottom row of screen[][] and it corresponds to minY.
            Which row then corresponds to the present y value?
                 (rows - 1) * (maxY - y) / (maxY - minY)
            Subtract 1 from rows for consistency with 0-base index in array.
             */
            int yRow = (int) Math.floor((rows-1) * (maxY-y)/(maxY-minY));
            screen[yRow][j] = plotCharacter; // plot the function at this row/column
            x += xStepping; //step to the next x
        }
    } // method plot


    /**
     * Display the plot contained in array screen[][]
     */
    public static void displayPlot() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.printf("%s",screen[i][j]);
            }
            System.out.printf("\n");
        }
    } // method displayPlot


    /** Driver method */
    public static void main(String[] args) {
        setUp(0.0, 6.5, 24, 80); // quick data entry, no typing same stuff every time
        derive();
        findMinMax();
        plot();
        displayPlot();
    } // method main

    
} // class Plot