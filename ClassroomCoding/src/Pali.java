public class Pali {

   /*

   Finds palindromes.
   Specs:
        Case insensitive
        Letters only -- ignore everything else

   Workflow: given a string s:
   - convert to lc                              )
   - remove everything but letter characters    )
   - while loop from both ends of string, ends when pair not same
   */


    /**
     * Converts a string to lower case and removes all non letter characters.
     *
     * @param s String to convert
     * @return A string with only the letter characters of s in lowercase.
     */
    public static String lettersOnly(String s) {
        String result = "";
        // Suppress to lower case
        String sLowerCase = s.toLowerCase();
        // Loop to remove non letters
        for (int i = 0; i < sLowerCase.length(); i++) {
            if (((int) sLowerCase.charAt(i) > 96) && sLowerCase.charAt(i) < 123)
                result = result + sLowerCase.charAt(i);
        }
        return result;
    }  // method lettersOnly


    /**
     * Tells if a string is a palindrome, after it removes all non letter characters
     * and supresses it to lower case.
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        String cleanedString = lettersOnly(s);
        boolean result = true;
        int index = 0;
        while (result && index < (cleanedString.length())/2) {
            if (cleanedString.charAt(index) != cleanedString.charAt(cleanedString.length()-1-index))
                result = false;
            index++;
        }
        return result;
    }  // method isPalindrome


    public static void main(String[] args) {
        System.out.println(lettersOnly("123Leo!"));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama!"));
    }

}
