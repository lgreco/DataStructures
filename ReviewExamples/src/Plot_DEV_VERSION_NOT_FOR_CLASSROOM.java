import java.util.Scanner;

/**
 *
 * This is Leo's dev code *** not for classroom sharing
 *
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
public class Plot_DEV_VERSION_NOT_FOR_CLASSROOM {

    /**
     * The principal method of the class. It delivers the plot as a sequence
     * of Strings printed one after the other.
     */
    public static void plot() {
        // find the "ZEROS", i.e., where the X and Y axes are placed.
        // Run a loop for rows
        // Create a string with as many places as columns.
        //   .repeat(columns)?
        //   At the appropriate locations insert symbols for X or Y axes
        //     and for the actual graph.
    } // method plot

} // class Plot