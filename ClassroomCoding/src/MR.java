import java.util.Random;

public class MR {

    /**
     * Determines if a single-word is a palindrome.
     *
     * Precondition: the word must not be empty and it must comprise only letters.
     * Postcondition: the determination is the word is a string.
     * Invariant: string position cursor always < string length.
     *
     * @param word String to test for palindrome
     * @return true if String word is a palindrome; false otherwise
     */
    public static boolean isPalindrome(String word) {
        // Declare the return variable
        boolean result;
        // Evaluate the precondition
        boolean preconditionMet = word.length() > 0 && hasLettersOnly(word);
        // If precondition has been met
        if (preconditionMet) {
            // Initialize return variable
            result = true;
            // Initialize string cursor
            int i = 0;
            // Loop to check pairs of characters from both ends
            do {
                // Update return variable with current comparison -- one bad pair suffices to switch to false
                result = result && (word.charAt(i) == word.charAt(word.length()-1-i));
                // Increment string cursor
                i++;
                // Continue while maching pairs are found and we have not reached middle of word
            } while (result && i < word.length()/2);
        }
        return result;
    }  // method isPalindrome


    /**
     * Checks is a string comprises letters only
     * @param s String to check
     * @return true is string comprises letters only
     */
    public static boolean hasLettersOnly(String s) {
        // Return variable; assume that string comprises letters only
        boolean lettersOnly = true;
        // Initialize a string cursor
        int i = 0;
        // Check every character in the string
        while (lettersOnly && i < s.length()) {
            // Current character at position i is converted to lower case to keep things simple
            char c = s.toLowerCase().charAt(i);
            // Character is expected to be within a and z inclusive; a single non letter turns this to false
            lettersOnly = lettersOnly && (c >= 'a' && c <= 'z');
            // Advance string cursor
            i++;
        }
        return lettersOnly;
    }  // method hasLettersOnly


    public static void main(String[] args) {
        System.out.println(isPalindrome("did"));
        System.out.println(isPalindrome("Leo"));
        System.out.println(isPalindrome("racecar"));
    }
}
