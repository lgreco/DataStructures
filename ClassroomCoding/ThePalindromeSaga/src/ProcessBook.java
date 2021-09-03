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
    static int wordsRead = 0;

    /** Number of palindromes found using the for-loop-based method */
    static int palindromesFoundWithForLoop = 0;

    /** Number of palindromes found using the while-loop-based method */
    static int palindromesFoundWithWhileLoop = 0;


    /**
     * Method to create a scanner object for a web-based text from Project Gutenberg
     * @param linkToProjectGutenberg String with URL to a plain text copy of a book
     * @return Scanner object for that web page; null if connection cannot be established
     */
    static Scanner connectToBook(String linkToProjectGutenberg) {
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
    static void findPalindromesIn(String linkedToProjectGutenberg) {
        Scanner book = connectToBook(linkedToProjectGutenberg);
        if (book != null) { // if connection failed scanner object would be null
            while (book.hasNext()) {
                String word = book.next(); // parse the book word by word
                wordsRead++; // update count of words read
                if (StringUtilities.isPalindrome(word))
                    palindromesFoundWithForLoop++; // update palindrome count for method with for-loop
                if (StringUtilities.isPalindrome2(word))
                    palindromesFoundWithWhileLoop++; // update palindrome count for method with while-loop
            }
        }
    } // method findPalindromesIn


    /**
     * Show results nicely formatted
     */
    static void reportResults() {
        System.out.printf("\n\nScanned %,d words and found" +
                "\n\t%,7d palindromes with the For-Loop-based method and" +
                "\n\t%,7d palindromes with the While-Loop-based method",
                wordsRead, palindromesFoundWithForLoop, palindromesFoundWithWhileLoop);
    } // method reportResults


    /** Driver method */
    public static void main(String[] args) {
        findPalindromesIn("https://www.gutenberg.org/files/4300/4300-0.txt");
        reportResults();
    }
}
