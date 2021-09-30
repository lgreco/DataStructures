/**
 * Class to demonstrate performance difference between for- and while-loops. The class illustrates how the while-loop
 * can end on demand, in contrast to a for-loop that must run its full course.
 *
 *
 * The methods of this class take an input, eliminate punctuation and normalize case,and then scans the string from
 * both ends, checking that if the letters match. As soon as a mismatch is detected, the scan ends and the method
 * returns false. The scan starts at both ends of the string and moves towards its center, one character at a time.
 * For example:
 *
 *     "A man, a plan, a canal: Panama" --->--- becomes -----> -----+
 *                                                                  |
 *     +--------<----------------------<-------------------<--------+
 *     |
 *     +------->        a m a n a p l a n a c a n a l p a n a m a
 *                      | |                 |                 | |
 *                      0 |             length/2              | length-1
 *                      | |                                   | |
 *                      | |                ...                | |
 *                      | +---------- second comparison ------+ |
 *                      |              'm' == 'm'               |
 *                      |                  ...                  |
 *                      +------------ first comparison ---------+
 *                                      'a' == 'a'
 *
 * The two methods available here differ only in the way they implement the scanning of the string. One method uses
 * a while-loop, the other uses a for-loop.
 */
public class StringUtilities {

    /**
     * Method that determines if a string is a palindrome. The method uses a naive logic, based on a for-loop.
     * Consequently, its performance is lagging compared to a more sophisticated method that could be based on
     * a "smarter" loop.
     *
     * The string is broken into pairs of letters symmetrically placed from its center. The pairs are compared to
     * determine if the letters are the same. If all pairs contain the same letters, the string is a palindrome.
     * For example "palindrome" is broken into the following pairs:
     *   p == e ... false     p alindrom e
     *   a == m ... false      a lindro m
     *   l == o ... false       l indr o
     *   i == r ... false        i nd r
     *   n == d ... false         n  d
     * And the string "deed" is broken into the following pairs
     *   d == d ... true         d ee d
     *   e == e ... true          e  e
     * And the string "racecar" is broken as follows
     *   r == r ... true       r aceca r
     *   a == a ... true        a cec a
     *   c == c ... true          c c
     * Notice that there is no pair containing the middle letter (here, 'e') for strings with an odd number of letters.
     *
     * @param string String to test if it is palindrome
     * @return true if palindrome; false otherwise
     */
    static boolean isPalindrome(String string) {
        /* Assume that string is a palindrome */
        boolean result = true;
        /* Convert to lowercase, remove everything but letters */
        string = string.toLowerCase().replaceAll("[^a-z]","");
        /* Create a local variable with string length, for readability */
        int len = string.length();
        /* Check every pair of letters, from both sides of the string moving towards its center */
        for (int i = 0; i < len/2; i++) {
            /* Left letter of pair */
            char leftOfCenter = string.charAt(i);
            /* Right letter of pair. Remember that len-1 is the last letter of a string due to 0-based counting. */
            char rightOfCenter = string.charAt(len-1-i);
            /* Are pair letters the same? True if same, false otherwise.*/
            boolean pairSame = leftOfCenter == rightOfCenter;
            /*
            Update result. Remember AND operation's truth table:
                 p      q      p && q
                 false  false  false
                 false  true   false
                 true   false  false
                 true   true   true
             */
            result = result && pairSame;
        } // end for
        return result;
    } // method isPalindrome


    /**
     * A more efficient method to determine if a string is a palindrome, based on the while-loop. The loop ends
     * as soon as we find the first pair of letters that disqualify a string from being a palindrome.
     * ( but with a bit of superfluous code)
     *
     * @param string String to test if it is palindrome
     * @return true if it is a palindrome; false otherwise
     */
    static boolean isPalindrome2(String string) {
        boolean result = true; // Assume string is a pali
        string = string.toLowerCase().replaceAll("[^a-z]",""); // Wash string
        int i = 0; // position index in the string
        while (result && i < string.length()/2) { // Stop when different letters found or when reaching middle of string
            result = result && (string.charAt(i) == string.charAt(string.length()-1-i)); // preserve or spoil the result
            i++; // advance position towards middle of string
        }
        return result;
    } // method isPalindrome2
} // class StringUtilities
