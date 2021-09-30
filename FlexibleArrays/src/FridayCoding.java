import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FridayCoding {

    // Because I am too lazy to type " ".
    private static final String SPACE = " ";

    // Mirroring divider.
    private static final String MIRROR = "   *   ";

    // Lenght of longest line read from file.
    private static int maxLineLength = 0;

    // List to keep the lines as they are ready.
    private static ArrayList<String> file = new ArrayList<String>();

    /**
     * Method to read text from file and store it in ArrayList file.
     * @throws FileNotFoundException
     */
    public static void readFromFile()
            throws FileNotFoundException {

        Scanner input = new Scanner(new File("input.txt"));

        while (input.hasNextLine()) {
            String lineRead = input.nextLine();
            // While we are at it, we can find the length of the longest line.
            maxLineLength = ( lineRead.length() > maxLineLength) ? lineRead.length() : maxLineLength;
            file.add(lineRead);
        }
    } // method readFromFile

    /**
     * Method to print text in reverse order, first reversing the order of lines,
     * then reversing the order of words in each line.
     */
    public static void reverse() {
        System.out.println("\n\n");
        for ( int i = (file.size()-1); i >= 0; i--) {
            String[] line = file.get(i).split(" ");
            for ( int j = (line.length-1); j >= 0; j--) {
                System.out.print(line[j] + " ");
            }
            System.out.println("");
        }
        System.out.println("\n\n");
    } // method reverse

    /**
     * Method to print lines, opposite to their reflection, using the
     * MIRROR string as the divider.
     */
    public static void mirrorOutput() {
        for ( int i = 0; i < file.size(); i++) {
            String s = file.get(i);
            int len = s.length();
            int padding = maxLineLength-len;
            System.out.println( s + SPACE.repeat(padding) + MIRROR + SPACE.repeat(padding) + reflect(s));
        }
    } // method mirrorOutput

    /**
     * Method to reverse a string
     * @param s String to reverse
     * @return Reversed string
     */
    public static String reflect(String s) {
        StringBuilder t = new StringBuilder();
        for ( int i = s.length()-1; i >= 0; i--) {
            t.append(s.charAt(i)); // immutability of Strings and all that ...
        }
        return t.toString();
    } // method reflect

    public static void main(String[] args)
            throws FileNotFoundException {
        readFromFile();
        reverse();
        mirrorOutput();
    } // method main
}