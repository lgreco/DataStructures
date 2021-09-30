import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Class that applies the palindrome methods to an online book. This class contains methods that
 * scan a book, counting its words, and how many of them are palindromes.
 */
public class ProcessBook {

    /** Number of words found in a book */
    private static int wordsRead = 0;

    /** Number of palindromes found using the while-loop-based method */
    private static int palindromesFound = 0;

    /** Enchanted array to save palis */
    private static EnchantedArray uniquePalindromes = new EnchantedArray();

    /*** Binary search tree to save palindromes */
    private static Tree palindromesTree = new Tree();


    /**
     * Method to create a scanner object for a web-based text from Project Gutenberg
     * @param linkToProjectGutenberg String with URL to a plain text copy of a book
     * @return Scanner object for that web page; null if connection cannot be established
     */
    private static Scanner connectToBook(String linkToProjectGutenberg) {
        /** Object to return */
        Scanner scanner = null;
        /* Establish a URL object, anticipating the possibility it may not work */
        URL url = null;
        try {
            url = new URL(linkToProjectGutenberg);
        } catch (MalformedURLException e) {
            scanner = null; // Redundant but reaffirms null if connection cannot be established
        }
        /* Establish an input stream from URL object, anticipating possible failure */
        InputStream inputStream = null;
        try {
            inputStream = url.openStream(); // Create stream for scanner
            scanner = new Scanner(inputStream); // Assign stream to scanner
        } catch (IOException e) {
            scanner = null; // Redundant but reaffirms null if connection cannot be established
        }
        return scanner;
    } // method connectToBook


    /**
     * Method to process a Project Gutenberg plain text page
     *
     * @param linkedToProjectGutenberg String with URL to a plain text copy of a book
     */
    public static void findPalindromesIn(String linkedToProjectGutenberg) {
        Scanner book = connectToBook(linkedToProjectGutenberg);
        if (book != null) { // if connection failed scanner object would be null
            while (book.hasNext()) {
                String word = book.next(); // parse the book word by word
                wordsRead++; // update count of words read
                if (StringUtilities.isPalindrome2(word)) {
                    palindromesFound++; // update palindrome count for method with while-loop
                    uniquePalindromes.addUnique(word);
                    palindromesTree.add(word);
                }
            }
        }
    } // method findPalindromesIn


    /**
     * Show results nicely formatted
     */
    public static void reportResults() {
        // ... tbd
    } // method reportResults

}
