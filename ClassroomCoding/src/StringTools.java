public class StringTools {

    /**
     * Tells if a string is a palindrome.
     *
     * Preconditions: empty string is not a palindrome; case insensitive;
     *                string must comprise letter characters only;
     *
     * Postcondition: determination if string is a palindrome.
     *
     * Invariant: string cursor never goes past half point of the string.
     *
     * @param s String to test
     * @return true if palindrome; false otherwise
     */
    public static boolean isPalindrome(String s) {
        // Initialize return variable
        boolean result = false;
        // Assess preconditions
        if (s.length() > 0) {
            // Preconditions met, assume string is a palindrome.
            result = true;
            // Initialize string cursor.
            int i = 0;
            // Get a lowercase copy of the input string
            String lc = s.toLowerCase();
            // Cursor never goes past half-length of string. Loop continues as long
            // as it finds matching characters from left and right ends of the string.
            while (i <= s.length()/2 && result) {
                // Explicit string positions from left and right (makes code more illustrative)
                int fromLeft = i;
                int fromRight = lc.length()-1-i;
                // Check is the corresponding characters from left and right match
                result = lc.charAt(fromLeft) == lc.charAt(fromRight);
                // Advance cursor
                i++;
            }
        }
        return result;
    }  // method isPalindrome


    /**
     * Tells if a string comprises only letter characters.
     *
     * @param s String to test
     * @return true if string has letter characters only; false otherwise
     */
    public static boolean hasLettersOnly(String s) {
        // WRITE YOUR CODE HERE
    }  // method hasLettersOnly


    /** Drive/test code, aka main method */
    public static void main(String[] args) {
        boolean t1 = hasLettersOnly("60605 is a Chicago zip code");
        boolean t2 = hasLettersOnly("door");
        boolean t3 = hasLettersOnly("dOOr");
        boolean t4 = hasLettersOnly("DOOR");
        boolean t5 = hasLettersOnly("DOOR3");
        boolean t6 = hasLettersOnly("Lake Michigan");
        if (!t1 && t2 && t3 && t4 && !t5 && !t6)
            System.out.println("\n\nPassed simple testing");
        else
            System.out.println("\n\nFailed simple testing");
    }
}
