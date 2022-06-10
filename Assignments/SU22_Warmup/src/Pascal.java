/*
 A simple class to create Pascal triangles.
 BJP 5/e Ch. 4, Programming Project 7
 */
public class Pascal {

    /**
     * Method to draw a Pascal Triangle with a specified number of lines.
     *
     * The method accepts as a parameters the number of lines to print in the triangle,
     * and the field with for the formatted printing.
     *
     * Based on these numbers, it can estimate the horizontal space needed. The last line
     * is the longest line. Its length is a multiple of the field width allocated to
     * each Pascal number. Based on that longest line's length, the method can compute the
     * spaces needed to pad each line.
     *
     * Next, the method carries out the computation of the Pascal numbers for each line.
     *
     *                                                  current line - current position
     *  next Pascal number = current Pascal Number x -------------------------------------
     *                                                         current position
     *
     * with the initial condition: 1-st Pascal Number = 1.
     *
     * @param numberOfLines int how many lines will the triangle have.
     */
    public static void printPascal(int numberOfLines, int fieldWidth) {
        // Space constant to keep code readable
        final String SPACE = " ";
        // String with format instructions based on desired field width
        String fieldFormat = String.format("%%%dd", fieldWidth);
        // The last line is the longest one. How long is it?
        int lastLineLength = (2*numberOfLines)* fieldWidth;
        // Loop for lines
        for (int line = 1; line <= numberOfLines; line++) {
            // Space pad each line to begin printing from the center and move out.
            System.out.printf("\n%s", SPACE.repeat((lastLineLength/2-line* fieldWidth)/2));
            // Initialize the Pascal number sequence for this line
            int pascalNumber = 1;
            // Loop for each position in this line
            for (int i = 1; i <= line; i++) {
                // Print current Pascal number
                System.out.printf(fieldFormat, pascalNumber);
                // Update to the next Pascal number
                pascalNumber = pascalNumber*(line-i)/i;
            }
        }
    }  // method printPascal


    /** Driver code */
    public static void main(String[] args) {
        printPascal(10, 4);
    }
}