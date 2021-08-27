public class Palindrome {

    /**
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        boolean palindrome = false; // Assume it is not a palindrome
        if (isValid(s)) { // String contains only valid characters
            s = s.toLowerCase().replaceAll("[^a-z ]", ""); // Convert to lower case, remove spaces and punctuation
            if (s.length() > 0) { // Anticipate that transformation above may return empty string
                int pos = 0; // Initialize a position index to traverse the string
                palindrome = true; // Assume it is a palindrome
                while (palindrome && (pos < s.length()/2)) { // Step towards the center of the string
                    palindrome = (s.charAt(pos) == s.charAt(s.length()-pos-1)); // Reassess for this pair of chars
                    pos++; // move to the next pair
                }
            }
        }
        return palindrome;
    } // method isPalindromeWhile


    /**
     *
     * @param s
     * @return
     */
    private static boolean isValid(String s) {
        boolean hasValidCharacters = false;
        boolean atLeastOneLetterPresent = false;
        if (s != null) {
            String allowed = ",.:;!? ";
            hasValidCharacters = true;
            int pos = 0;
            s = s.toLowerCase();
            while (hasValidCharacters && (pos < s.length())) {
                char c = s.charAt(pos);
                atLeastOneLetterPresent = atLeastOneLetterPresent || ('a' <= c && c <= 'z');
                hasValidCharacters = ('a' <= c && c <= 'z') || (s.indexOf(c) > -1);
                pos++;
            }
        }
        return hasValidCharacters && atLeastOneLetterPresent;
    } // method isValid

}
