import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Solution_BookToDictionary {

    // Capacity of array that stores the dictionary
    public static final int DICTIONARY_SIZE = 20_000;
    // Message to print when reporting contents, but array is empty
    public static final String EMPTY_ARRAY = "The array is empty.";
    // How many words to print per lien, when reporting contents.
    public static final int WORDS_PER_LINE = 4;
    // Email character
    public static char EMAIL_AT = '@';
    // String expected in canonical web addresses
    public static final String WWW = "www";


    /**
     * Produces a Scanner connected to a text file accessible via the web.
     *
     * The method expects a link to a text file. When accessing material from
     * Project Gutenberg it is import to use the plain text version of a book.
     *
     * DO NOT MODIFY THIS METHOD.
     *
     * @param link String with URL to text file.
     * @return a Scanner for the file or null if connection cannot be made.
     */
    public static Scanner browseTextFile(final String link) {
        // Declare the return variable
        Scanner fileOnline;
        // Use try/catch to prevent the program from crashing.
        try {
            // Create a URL object from the link provided
            URL url = new URL(link);
            // Turn the URL into a Scanner
            fileOnline = new Scanner(url.openStream());
        } catch (IOException e) {
            // If something goes wrong, prepare to return null Scanner.
            fileOnline = null;
        }
        return fileOnline;
    }  // method browseTextFile


    /**
     * Tells if a string exists in the used portion of an array.
     *
     * @param array  String[] to search
     * @param target String to search for
     * @param upTo   How far into the array to search (must be <= length)
     * @return true if string target is in array; false if not or if search
     * scope (upTo) exceeds length of array.
     */
    public static boolean isInArray(final String[] array,
                                    final String target,
                                    final int upTo) {
        // Initialize return; assume string not found
        boolean found = false;
        // Enforce precondition that search cannot exceed array length
        if (upTo <= array.length) {
            // Start search from first element
            int i = 0;
            while (!found && i < upTo)
                // Keep searching until found or until at end of search portion.
                found = array[i++].equals(target);
        }
        return found;
    }  // method isInArray


    /**
     * Scans a text file and places unique words to an array.
     *
     * @param linkToBook String with URL to input text file.
     * @return String array with the unique words in the input file.
     */
    public static String[] scanBook(String linkToBook) {
        // Attempt scanner connection; this may be null if there is a problem.
        Scanner bookReader = browseTextFile(linkToBook);
        /*
        Declare but not assign yet the array to return. If something goes wrong
        with the scanner connection, the return array will remain a null
        reference. In other words, the method will return a null. This null can
        be detected by other parts of the program, to indicate that something
        went wrong.
         */
        String dictionary[] = {};
        // Verify that bookReader is a valid scanner connection and not null.
        if (bookReader != null) {
            // Connection established, let's initialize the array
            dictionary = new String[DICTIONARY_SIZE];
            // Count how many items were stored.
            int itemsStored = 0;
            // Process the text file.
            while (bookReader.hasNext()) {
                // Read the next token from the file
                String token = bookReader.next();
                // cleanup token to remove non letter characters or to eliminate
                // web or email addresses.
                token = cleanToken(token);
                // Cleaned up token may be empty because it was an email or a
                // web address. If empty, don't bother searching the array.
                if (token.length() > 0
                        && !isInArray(dictionary, token, itemsStored))
                    dictionary[itemsStored++] = token;
            }
        }
        return dictionary;
    }  // method scanBook


    /**
     * Cleans a String token from punctuation and other non-letter characters.
     *
     * If the token is an email address or a web address, the method returns
     * an empty string.
     *
     * @param token to clean
     * @return letters only, or empty if token is email/web address.
     */
    public static String cleanToken(final String token) {
        // convert to lowercase.
        String cleaned = token.toLowerCase();
        if (cleaned.indexOf(EMAIL_AT) > -1 || cleaned.contains(WWW))
            // String is probably web or email address. We dont need it.
            cleaned = "";
        else
            // String is probably a word; remove punctuation, other non letters.
            cleaned = cleaned.replaceAll("[^a-z]", "");
        return cleaned;
    }  // method cleanToken


    /**
     * Displays the content of an array in a nicely formatted output.
     *
     * @param array String[] whose contents are displayed.
     */
    public static void displayArray(final String[] array) {
        if (array.length == 0) {
            // If array is empty, say so and stop
            System.out.printf("\n%s\n", EMPTY_ARRAY);
        } else {
            int i = 0;
            // Loop ends at first null entry or at end of array
            while (i < array.length && array[i] != null) {
                System.out.printf("%20s\t", array[i++]);
                // Every so many words, move to a new line
                if (i % WORDS_PER_LINE == 0)
                    System.out.println();
            }
            // One final report
            System.out.printf("\n\nThere are %,d items above; the array " +
                            "capacity is %,d and we used %.2f%% of it.\n",
                    i - 1, array.length,
                    100.0 * ((double) (i - 1) / (array.length)));
        }
    }  // method displayArray


    /**
     * Use main() to call other methods; don't put all your code in main.
     */
    public static void main(String[] args) {
        // Link to A Tale of Two Cities
        String book = "https://www.gutenberg.org/files/98/98-0.txt";
        // Send the URL to the scanning method, then display the resulting array
        displayArray(scanBook(book));
    }  // method main

}  // class BookToDictionary
