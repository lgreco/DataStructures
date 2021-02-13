import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RelaxedCrossword {

    private static final int MIN_WORD_LENGTH_ALLOWED = 2;
    private static final int MAX_WORD_LENGTH_ALLOWED = 35;

    List[] dictionary = new List[MAX_WORD_LENGTH_ALLOWED];

    // method to read words from online file
    public void importWords() throws FileNotFoundException {
        // Scan the file
        File file = new File("words.txt");
        Scanner s = new Scanner(file);
        while (s.hasNextLine()) {
            String wordRead = s.nextLine();
            int bucket = wordRead.length(); // bucket by length
            if ( MIN_WORD_LENGTH_ALLOWED < bucket && bucket < MAX_WORD_LENGTH_ALLOWED ) { // allow words of certain length
                if ( dictionary[bucket] == null) {
                    dictionary[bucket] = new ArrayList<String>(1);
                }
                dictionary[bucket].add(wordRead);
            }
        }
        // to do: map words to hashmap based on their length ^^^
    } // method importWords

    public static void main(String[] args) throws FileNotFoundException {
        RelaxedCrossword demo = new RelaxedCrossword();
        demo.importWords();
    }
}
