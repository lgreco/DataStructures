import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Leo's attempt at the Crossword final exam problem.
 */
public class Crossword {

    private static final int MAX_WORD_LENGTH_ALLOWED = 35;
    private static final int MIN_WORD_LENGTH_ALLOWED = 2;
    private static final int TOO_LONG = 10000;
    private static final double BLOCKED_FRACTION = 0.2;
    private static final char BLOCK = '#';
    private static final boolean ACROSS = true;
    private static final boolean DOWN = false;

    private int rows; // number of puzzle rows
    private int columns; // number of puzzle columns
    private double blockedFraction; // percentage of blocked cells
    private int blockedCells; // number of blocked cells
    private int remainingCells;
    private Random random = new Random();
    private char[][] crossword; // foundation structure
    private boolean[][] visited;
    private List[] dictionary = new List[MAX_WORD_LENGTH_ALLOWED]; // array of lists!


    public Crossword(int rows, int cols) {
        // size of rows, cols must me > 2*MIN WORD LENGTH
        this.rows = rows > 2*MIN_WORD_LENGTH_ALLOWED ? rows : 2*MIN_WORD_LENGTH_ALLOWED + 1;
        this.columns = cols > 2*MIN_WORD_LENGTH_ALLOWED ? cols : 2*MIN_WORD_LENGTH_ALLOWED + 1;
        crossword = new char[this.rows][this.columns];
        visited = new boolean[this.rows][this.columns];
        blockedFraction = BLOCKED_FRACTION;
        remainingCells = this.rows * this.columns;
        this.blockedCells = (int) (blockedFraction * remainingCells);
    } // constructor for rectangular puzzles

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

    /**
     *
     */
    public void buildCrossword() {
        // Place first word in the middle of the puzzle
        firstWord();
        System.out.printf("\nFirst word placed. Remaining cells %d\n", remainingCells);

        // random blocks
        blockCellsRandomly();
        System.out.println("Cells blocked.");
        showCrossword();

        boolean keepBuilding = true;
        int howLong = 0;

        buildAcross();
    } // method buildCrossword

    private void buildAcross() {
        int currentRow = 0;
        int currentCol = 0;
        while ( currentRow > -1 && currentCol > -1 ) {
            int[] localData = analyzeGroup(currentRow, currentCol);
            int length = localData[0];
            if (length > MIN_WORD_LENGTH_ALLOWED) {
                System.out.printf("\nAt %02dx%02d looking for word with %d letters",currentRow,currentCol,length);
                String currentWord = selectWord(length,length);
                System.out.printf("\n%s has %d letters.", currentWord, currentWord.length());
                System.out.printf("\nAfter placement, the cursor will move to %02dx%02d",localData[1],localData[2]);
                for (int i = 0; i < length; i++) {
                    crossword[currentRow][currentCol+i] = currentWord.charAt(i);
                }
                currentRow = localData[1];
                currentCol = localData[2];
                System.out.printf("\nCurrent row and col have been set to %d and %d", currentRow, currentCol);
            } else {
                // advance by length and try again
                currentCol = currentCol+length+1;
                if (currentCol>=columns) {
                    currentCol = 0;
                    currentRow++;
                    if (currentRow>=rows) {
                        currentCol = -1;
                        currentRow = -1;
                    }
                }
            }
        }
    } // method buildAcross

    private int[] analyzeGroup(int row, int col) {
        int[] results = new int[3];
        int length = 0;
        if ( crossword[row][col] != BLOCK) {
            System.out.printf("\n\tPosition %02dx%02d is not blocked", row, col);
            // How many squares are available for a word?
            // Count from here to the next block or last column
            while ( col + length < columns && crossword[row][col+length] != BLOCK ) {
                length++;
            }
            System.out.printf("\n\tThis position has %d open squares",length);
            col = length + 1;
            if ( col >= columns ) {
                col = 0;
                row++;
            }
            if ( row >= rows ) {
                // end of road
                row = -1;
                col = -1;
            }
        } else { // square is blocked
            if ( col < columns-1) {
                col++;
            }
        }
        results[0] = length;
        results[1] = row;
        results[2] = col;
        return results;
    }

    /**
     * Method to place first word in the puzzle, center-aligned in the middle row.
     */
    private void firstWord() {
        int middleCol = columns /2;
        int middleRow = rows/2;
        // select a word at random with length < cols but > cols/2
        String initialWord = selectWord(columns /2, columns);
        int middleOfInitialWord = initialWord.length()/2;
        remainingCells = remainingCells-initialWord.length();
        for ( int i = 0; i < initialWord.length(); i++ ) {
            crossword[middleRow][middleCol-middleOfInitialWord+i] = initialWord.charAt(i);
            visited[middleRow][middleCol-middleOfInitialWord+1] = true;
            // block cells before and after initial word, as appropriate
            if ( middleCol-middleOfInitialWord > 0) {
                crossword[middleRow][middleCol-middleOfInitialWord-1] = BLOCK;
                blockedCells--;
                remainingCells--;
            }
            if ( middleCol-middleOfInitialWord+initialWord.length() < columns) {
                crossword[middleRow][middleCol-middleOfInitialWord+initialWord.length()] = BLOCK;
                blockedCells--;
                remainingCells--;
            }
        }
    } // method firstWord

    /**
     * Method to randomly block cells according to the following rules
     *   - [0][0] cannot be blocked
     *   - no cell in the middle row (where the initial word is placed) can be blocked in this stage
     *   - total number of blocked cells cannot exceed blockedCells
     */
    private void blockCellsRandomly() {
        int middleRow = rows/2;
        int countBlockedCells = 0;
        while (countBlockedCells < blockedCells ) {
            int blockRow = random.nextInt(rows);
            int blockCol = random.nextInt(columns);
            if (! ((blockRow==0 && blockCol==0) || blockRow==middleRow) ) {
                crossword[blockRow][blockCol] = BLOCK;
                countBlockedCells++;
            }
        }
    } // method blockCellsRandomly

    private int available(int row, int col, boolean direction) {
        int beginning, end;
        char currentCell = crossword[row][col];
        if (direction) { // scan horizontally
            while ( currentCell != BLOCK && col > -1 ) {
                col--;
            }
            beginning = col;
            while ( currentCell != BLOCK && col < columns) {
                col++;
            }
            end = col;
        } else { // scan vertically
            while ( currentCell != BLOCK && row > -1 ) {
                row--;
            }
            beginning = row;
            while ( currentCell != BLOCK && row < rows ) {
                row++;
            }
            end = row;
        }
        return end-beginning-1;
    }

    private boolean eligible(int row, int col) {
        boolean eligibility = false;
        if ( crossword[row][col] != 0 ) {
            // vertical eligibility

        }
        return eligibility;
    }

    private String selectWord(int minLetters, int maxLetters) {
        // let's make sure minLetters and maxLetters are within allowed values
        minLetters = minLetters > MIN_WORD_LENGTH_ALLOWED ? minLetters : MIN_WORD_LENGTH_ALLOWED;
        maxLetters = maxLetters < MAX_WORD_LENGTH_ALLOWED ? maxLetters : MAX_WORD_LENGTH_ALLOWED;
        int bucket;
        if ( maxLetters==minLetters) {
            bucket = maxLetters;
        } else {
            bucket = random.nextInt(maxLetters - minLetters) + minLetters;
        }
        int wordIndex = random.nextInt(dictionary[bucket].size());
        List<String> wordsOfLength = dictionary[bucket];
        String randomWord = wordsOfLength.get(wordIndex);
        return randomWord;
    } // method selectWord




    public void showCrossword() {
        System.out.println();
        for ( int i = 0; i < rows; i++ ) {
            for (int j = 0; j < columns; j++ ) {
                System.out.print(crossword[i][j]);
            }
            System.out.println();
        }
    } // method showCrossword

    /** testing */
    public static void main(String[] args) throws FileNotFoundException {
        Crossword demo = new Crossword(15,15);
        demo.importWords();
        demo.buildCrossword();
        demo.showCrossword();
    }

}
