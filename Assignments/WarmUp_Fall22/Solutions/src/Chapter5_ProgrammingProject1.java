import java.util.Scanner;

public class Chapter5_ProgrammingProject1 {

    /** Class constant for the Latin Pig extension */
    private static final String LATIN_EXTENSION = "ay";
    /** Class constant for the dash needed before the Latin Pig extension */
    private static final String DASH = "-";
    /** Class constant with string of vowels */
    private static final String VOWELS = "aeiou";
    /** Class constant with two-letter consonant sounds */
    private static final String TWO_LETTER_CONSONANTS = "shphthchbl";
    /** Class constant with length of two-letter consonant */
    private static final int TWO_LETTER_LENGTH = 2;
    /** Space string to avoid use of magic variable " " in code */
    private static final String SPACE_STRING = " ";


    /**
     * Tells if a word begins with a vowel.
     *
     * @param word String to evaluate its first letter
     * @return true if first letter is vowel; false otherwise.
     */
    public static boolean isFirstLetterVowel(String word) {
        return VOWELS.indexOf(word.toLowerCase().charAt(0)) > -1;
    }  // method isFirstLetterVowel


    /**
     * Tells if the first two letters of a word are a consonant sound.
     *
     * @param word String word to evaluate.
     * @return True if first two letters are consonant sound, false otherwise.
     */
    public static boolean beginsWithDoubleConsonantSound(String word) {
        String firstTwo = word.toLowerCase().substring(0, TWO_LETTER_LENGTH);
        return TWO_LETTER_CONSONANTS.indexOf(firstTwo) > -1;
    }  // method beginsWithDoubleConsonantSound


    /**
     * How many letters in the consonant sound that a work begins with?
     *
     * @param word String to evaluate
     * @return int number of letters in the initial consonant sound (1 or 2)
     */
    public static int initialConsonantSound(String word) {
        int position = 1;
        if (beginsWithDoubleConsonantSound(word))
            position++;
        return position;
    }  // method initialConsonantSound


    /**
     * Converts a string to pig-latin. If the word starts with a consonant
     * sound, the letter(s) is(are) moved to the end of the word, and the
     * extension "ay" is added. If the word begins with a vowel, we just add
     * the extension ay at the end.
     *
     * @param word String to convert
     * @return pig-latin version of the word.
     */
    public static String toPigLatin(String word) {
        // Return variable
        String pig;
        if (isFirstLetterVowel(word)) {
            // Word begins with a vowel, just append extension
            pig = word + DASH + LATIN_EXTENSION;
        } else {
            // Word begins with consonant; is it a 1 or 2 letter sound?
            int consonantSound = initialConsonantSound(word);
            // Knowing if it's 1 or 2 letters allow us to pull the correct
            // substring from the beginning of the word and add it the back
            pig = word.substring(consonantSound) +
                    DASH +
                    word.substring(0,consonantSound) +
                    LATIN_EXTENSION;
        }
        return pig;
    }  // to toPigLatin


    /**
     * Translates a string to Pig Latin
     * @param string String to translate
     * @return translation to Pig Latin in a string
     */
    public static String translateString(String string) {
        Scanner s = new Scanner(string);
        String output = "";
        // Process the input string, one word at a time
        while (s.hasNext())
            // Translate the current word to pig latin and add it to output
            output = output + toPigLatin(s.next()) + SPACE_STRING;
        return output;
    }  // method translateString


    /** Driver code */
    public static void main(String[] args) {
        String input = "The dog swiftly ran through the forest";
        System.out.println(translateString(input));
    }  // method main

}  // class Chapter5_ProgrammingProject1
