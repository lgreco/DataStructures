
import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * Write a class with a public method that accepts a name as input and produces a
 * Hobbit name as an output using the following rules:
 *
 *   The Hobbit first name can be the name of a herb or a spice that begins with the
 *   first letter of the input name, e.g., Leo --> Lemongrass
 *
 *   The Hobbit last name can be either:
 *      the name of a favorite drink + the name of a baked good
 *   or
 *      the name of an organ or body part (keep it decent!) +
 *      the name of a landform,
 *   e.g., ArmPit (arm + pit ).
 *
 * Name this public method:
 *    public String hobbitName(String name) {...}
 *
 * Even though your class must have a public method to produce and return the Hobbit name,
 * it may contain any number of private methods that are necessary to accomplish the task.
 * Users of your class should interact with it only through hobbitName. Everything else,
 * including class fields, should be private.
 *
 * For a list of herbs, spices, body parts, and landforms, you may use (via URL objects)
 * the following files, from
 *    https://github.com/lgreco/DataStructures/tree/master/Midterm%20F20/src:
 *    spices.txt
 *    drinks.txt
 *    baked_goods.txt
 *    body_parts.txt
 *    landforms.txt
 */
public class HobbitNames_Solution {

    private static final double FAIR_COIN_PROBABILITY = 0.5; // EXPLAIN WHAT THIS IS
    private static final String GITHUB_ROOT = "https://raw.githubusercontent.com/lgreco/DataStructures/master/Midterm%20F20/src/";
    private String files[] = {"spices", "drinks", "baked_goods", "body_parts", "landforms"};

    private List<String> spices      = new ArrayList<>();
    private List<String> drinks      = new ArrayList<>();
    private List<String> baked_goods = new ArrayList<>();
    private List<String> body_parts  = new ArrayList<>();
    private List<String> landforms   = new ArrayList<>();

    private void populateLists() throws IOException {
        spices      = pullData("spices");
        drinks      = pullData("drinks");
        baked_goods = pullData("baked_goods");
        body_parts  = pullData("body_parts");
        landforms   = pullData("landforms");
    } // method populateLists

    private List<String> pullData(String fileName) throws IOException {
        List<String> newData = new ArrayList<>();
        String pathToFile = GITHUB_ROOT + fileName + ".txt";
        URL url =  new URL(pathToFile);
        Scanner s = new Scanner(url.openStream());
        while ( s.hasNext() ) {
            newData.add(s.nextLine());
        }
        return newData;
    } // method pullData

    public String hobbitName(String name) {
        String hobbitName = "";
        // get name's first letter
        String nameFirstLetter = String.valueOf(name.charAt(0)).toLowerCase();
        // pull all spices that begin with same letter in arraylist;
        List<String> spicesBeginningWithSameLetter = new ArrayList<>();
        ListIterator<String> spice = spices.listIterator();
        while ( spice.hasNext() ) {
            String currentSpice = spice.next();
            String spiceFirstLetter = String.valueOf(currentSpice.charAt(0)).toLowerCase();
            if ( nameFirstLetter.equalsIgnoreCase(spiceFirstLetter) ) {
                spicesBeginningWithSameLetter.add(currentSpice);
            }
        }
        // randomly select one of those spices
        Random rng = new Random();
        String hobbitFirstName;
        int n = spicesBeginningWithSameLetter.size();
        if (n > 0) {
            n = rng.nextInt(n);
            hobbitFirstName = spicesBeginningWithSameLetter.get(n).replaceAll("\\s+", "");
        } else {
            hobbitFirstName = "";
            for (int i = name.length(); i>0; i--) {
                hobbitFirstName = hobbitFirstName + name.charAt(i-1);
            }
        }
        // capitalize selected spice and add it to hobbitName
        hobbitFirstName = hobbitFirstName.toUpperCase().charAt(0) + hobbitFirstName.toLowerCase().substring(1);

        String lastNameLeft, lastNameRight;
        // toss a coin to determine technique for last name
        if ( rng.nextDouble() > FAIR_COIN_PROBABILITY ) {
            lastNameLeft = drinks.get(rng.nextInt(drinks.size()));
            lastNameRight = baked_goods.get(rng.nextInt(baked_goods.size()));
        } else {
            lastNameLeft = body_parts.get(rng.nextInt(body_parts.size()));
            lastNameRight = landforms.get(rng.nextInt(landforms.size()));
        }
        // concatenate
        String hobbitLastName = lastNameLeft + lastNameRight;
        // capitalize and add to hobbitName
        hobbitLastName = hobbitLastName.toUpperCase().charAt(0) + hobbitLastName.toLowerCase().substring(1);
        hobbitName = hobbitFirstName + " " + hobbitLastName.replaceAll("\\s+", "");
        return hobbitName;
    } // method hobbitName

    public static void main(String[] args) throws IOException {
        HobbitNames_Solution demo = new HobbitNames_Solution();
        demo.populateLists();
        String[] testNames = { "Leo", "John", "Sarah", "Ian", "Mina", "Martin", "Domingo" };
        for ( String testName:testNames) {
            System.out.printf("\n%s's Hobbit name is: %s", testName, demo.hobbitName(testName));
        }
    } // method main
}
