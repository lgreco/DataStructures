import java.util.ArrayList;
import java.util.Collections;

/**
 * A simple class to capture really large integer numbers. Each instance of
 * this class is a big integer. Doesn't work with negative numbers for now.
 */
public class Gazillion {

    /** The digits of a very big number */
    private ArrayList<Integer> digits;

    /**
     * Constructor with String parameter
     * @param s String representation of big number, e.g., s = "1234...."
     */
    public Gazillion(String s) {
        final char LOWEST_DIGIT = '0';
        digits = new ArrayList<Integer>(s.length()); // Initialize class field to size of given String
        char c;
        int digit;
        boolean numericDigitDetected = false; // flag in case passed argument s contains no numerical digits
        // Copy string contents to ArrayList
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i); // scan passed argument s, one character at a time.
            if (Character.isDigit(c)) { // is this character a number digit?
                digit = c - LOWEST_DIGIT; // compute its value; should be 0, 1, ..., 9
                digits.add(digit); // add it to the digits ArrayList
                numericDigitDetected = true; // flag that we have at least one numeric digit!
            }
        }
        // If no numeric digit found in String s, we have a problem!
        if (!numericDigitDetected) {
            throw new IllegalArgumentException();
        }
    } // constructor with string parameter

    /**
     * Prepare a string for printing purposes.
     * @return the String representation of the digits array
     */
    public String toString() {
        return digits.toString();
    } // method toString

    /**
     * Method to add two big integers. Usage:
     *   Gazillion a = new Gazillion("123...");
     *   Gazillion b = new Gazillion("987...");
     *   a.add(b); // a+b now assigned to a
     * From basic arithmetic, remember that for single digit numbers x and y:
     *   sum(x,y) = (x+y) % BASE
     *   carry(x,y) = (x+y) // BASE, where // is an integer division
     * @param gazillion second operate to add (first operand is accessed with operator)
     */
    public void add(Gazillion gazillion) {
        final int BASE = 10; // numerical base; obvious but necessary for carry and sum operations
        int largestSize; // size of the largest of two numbers
        int partialSum; // digit-by-digit sum
        int carry = 0; // initial value of carry

        // find the size of the largest number
        if (digits.size() > gazillion.digits.size()) {
            largestSize = digits.size();
        } else {
            largestSize = gazillion.digits.size();
        }

        // set up a temp ArrayList for the summation. It has space for as many digits as the largest
        // of the two numbers, PLUS one, in case of overflow.
        ArrayList<Integer> sumDigits = new ArrayList<Integer>(largestSize + 1);

        // Add numbers digit-by-digit
        for (int i = 0; i < largestSize; i++) {
            partialSum = least(i) + gazillion.least(i) + carry; // bring carry from previous digit-by-digit operation
            carry = partialSum / BASE; // integer division
            sumDigits.add(partialSum % BASE); // append the sum digit to the temporary ArrayList
        } // rof

        if (carry == 1) {
            sumDigits.add(carry); // overflow carry, if present
        }

        Collections.reverse(sumDigits); // reverse for proper representation
        digits = sumDigits; // copy sum to digits
    } // method add

    /**
     * Method to obtain the i-th digit
     * @param i position of digit
     * @return digit
     */
    private int least(int i) {
        if ( i>= digits.size()) {
            return 0;
        } else {
            return digits.get(digits.size() - i - 1);
        }
    } // method least

    /**
     * BRUTE FORCE MULTIPLICATION BASED ON GRADE SCHOOL TECHNIQUE
     *
     * Multiply this number with passed gazillion. Usage:
     *   Gazillion a = new Gazillion(" ... ");
     *   Gazillion b = new Gazillion(" ... ");
     *   a.multiply(b); // a is now a x b
     *
     * Multiplication, though trivial on paper, requires some work as a program.
     * You may want to check out the Karatsuba algorithm for multiplication, to
     * appreciate the complexity involved. However, for this problem you can use
     * the grade school multiplication algorithm. Consider two numbers written
     * as:  a2 a1 a0 (e.g., 214, a2 = 2, a1 = 1, a0 = 4) and
     *         b1 b0 (e.g., 33, b1 = 5, b0 = 3)
     * Multiplying them step by step:
     *         214
     *        x 53
     *    --------
     *         642   .... ( this is 3x214, i.e, b0 x (a2 a1 a0) )
     *       1070    .... ( this is 5x214, i.e., b1 x (a2 a1 a0) )
     *    ========
     *       11342   .... ( this is column-by-column addition )
     *
     * @param gazillion number to multiply .this with
     *
     */
    public void multiply(Gazillion gazillion) {
        int smallestSize;
        if (digits.size() < gazillion.digits.size()) {
            smallestSize = digits.size();
        } else {
            smallestSize = gazillion.digits.size();
        }
    } // method multiply

    /**
     * STANDARD RECURSIVE MULTIPLICATION
     *
     * A recursive implementation of the multiplication operation for two Gazillion objects
     * x and y, representing numbers written as:
     *
     *      x = 10^N * a + b
     *      y = 10^N * c + d
     *
     * where N is an int primitive and correspond to the number of digits in x and y;
     * (we assume that x and y have the same number of digits),  and a, b, c, and d
     * are Gazillion objects. As discussed in class, the pseudocode is:
     *
     *    RecursiveMultiplication:
     *     Input: x, y with N digits (N is a power of 2)
     *    Output: the product of x and y as a Gazillion object
     *      Note: ^ is not the correct way for exponentiation in Java!!!
     *
     *    if ( N==1 ):
     *       return new Gazillion(Integer.toString(x[0]*y[0])
     *    else:
     *      a, b <--- first and second halves of x (both are Gazillion objects)
     *      c, d <--- first and second halves of y (both are Gazillion objects)
     *      ac <--- RecursiveMultiplication(a,c);   //---------------------------//
     *      ad <--- RecursiveMultiplication(a,d);   //  REMEMBER: ALL THESE ARE  //
     *      bc <--- RecursiveMultiplication(b,c);   //  GAZILLION OBJECTS        //
     *      bd <--- RecursiveMultiplication(b,d);   //---------------------------//
     *      return (as Gazillion object) 10^N * ac + 10^(N/2) * (ad+bc) + bd
     *
     *  Notice that for very large values of N (e.g., N=100), the quantities 10^N (ten to the
     *  power N) and 10^(N/2) may be beyond Java's range for long primitives and you may have
     *  to express them as Gazillion objects. You may do so, or you may simply pad the underlying
     *  ArrayLists with the necessary number of 0s.
     *
     *  Notice also that the expression in the recursive return involves Gazillion objects
     *
     *    10^N * ac + 10^(N/2) * (ad+bc) + bd
     *
     *  Each operand above is a Gazillion object:
     *    10^N * ac
     *    10^(N/2) * (ad+bc)
     *    bd
     *  and so are the operands in (ad+bc).
     *
     *  In other words, every "+" in the return expression corresponds to a call to
     *  method add.
     *
     * @param x Gazillion operand
     * @param y Gazillion operand
     * @return product x*y as a Gazillion object
     */
    public Gazillion recursiveMultiplication(Gazillion x, Gazillion y) {
        Gazillion product = null;
        // work you code magic here!
        return product;
    } // method RecursiveMultiplication

    /** Driver */
    public static void main(String[] args) {
        Gazillion a = new Gazillion("9798298283984209823944820970792685297384298249828402");
        Gazillion b = new Gazillion("2424245242988922424339283493752037827348728782472787");
        a.add(b);
        System.out.println(a.toString());
    }
} // class Gazillion
