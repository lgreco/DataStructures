import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class BookToDictionary {

    /**
     * Produces a Scanner connected to a text file accessible via the web.
     * DO NOT MODIFY THIS METHOD.
     *
     * @param link String with URL to text file.
     * @return a Scanner for the file or null if connection cannot be made.
     */
    public final static Scanner browseTextFile(final String link) {
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


    /** Use main() to call other methods; don't put all your code in main. */
    public static void main(String[] args) {
        // Link to A Tale of Two Cities
        String book = "https://www.gutenberg.org/files/98/98-0.txt";
    }  // method main

}  // class BookToDictionary
