/*
A class with methods that process Palindromes.
 */

public class Pali {

    /* Class constants */
    private static final int LOWER_A = (int) 'a';
    private static final int LOWER_Z = (int) 'z';


    /**
     * Converts a string to lower case and removes all non letter characters.
     *
     * @param s String to convert
     * @return A string with only the letter characters of s in lowercase.
     */
    public static String sanitize(final String s) {
        // Initialize the output string
        String result = "";
        // Obtain a lower-case version of the input string
        String lowerCase = s.toLowerCase();
        // Loop to remove non letters from lower case string
        for (int i = 0; i < lowerCase.length(); i++) {
            // Put the character at current position and convert to int
            int currentCharacter = (int) lowerCase.charAt(i);
            if (currentCharacter >= LOWER_A && currentCharacter <= LOWER_Z) {
                // If current character within letter range, add to output
                result = result+lowerCase.charAt(i);
            }
        }
        return result;
    }  // method sanitize


    /**
     * Tells if a string is a palindrome.
     *
     * @param s String to evaluate
     * @return true if string is palindrome, false otherwise.
     */
    public static boolean isPalindrome(final String s) {
        // Initialize the return output
        boolean result = true;
        // Obtain a sanitized version with lower case letters only
        String sanitized = sanitize(s);
        // Initialize cursor to traverse the string from left to right
        int fromLeft = 0;
        /*
        Loop traverses the string from both ends, comparing pairs  of characters
        at  positions that  are symmetric  to the  string's middle  point.  This
        traversal  ends when  one of  two conditions  occurs:  we  have  reached
        the  middle of the string  or we have found a pair of characters that do
        not match and therefore the string is not a palindrome.
         */
        while (result && fromLeft < sanitized.length()/2) {
            // Cursor traversing the string from right to left
            int fromRight = sanitized.length()-1-fromLeft;
            if (sanitized.charAt(fromLeft) != sanitized.charAt(fromRight))
                result = false;
            fromLeft++;
        }
        return result;
    }  // method isPalindrome


    /**
     * A more compact version of isPalindrome, without the if statement inside
     * the while loop.
     *
     * @param s String to evaluate for palindrome
     * @return true if s is a palindrome; false otherwise
     */
    public static boolean isPalindromeCompact(final String s) {
        boolean result = true;
        String t = s.toLowerCase().replaceAll("[^a-z]", "");
        int i = 0;
        while (result && i < t.length()/2)
            result = (t.charAt(i) >= LOWER_A) && (t.charAt(t.length()-1-i++) <= LOWER_Z);
        return result;
    }  // method isPalindromeCompact


    /** Test code */
    public static void main(String[] args) {
        // Expect "comp"
        System.out.println(sanitize("COMP271!"));
        // Expect true
        System.out.println(isPalindrome("A man, a plan, a canal: Panama!"));
        // Expect true
        System.out.println(isPalindromeCompact("A man, a plan, a canal: Panama!"));
        // Expect false
        System.out.println(isPalindrome("Lake Michigan"));
        // Expect false ... and yet ... what's going on here?
        System.out.println(isPalindrome("3.14159"));
    }  // method main

}  // class Pali
