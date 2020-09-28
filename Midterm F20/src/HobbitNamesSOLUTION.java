/**
 * Write a class with a public method that accepts a name as input and produces a
 * Hobbit name as an output using the following rules:
 *
 *   The Hobbit first name can be the name of a herb or a spice that begins with the
 *   first letter of the input name, e.g., Leo --> Lemongrass
 *
 *   The Hobbit last name can be either:
 *      the name of a favorite drink + the name of a baked good
 *   or<br>
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
public class HobbitNamesSOLUTION {

    private String files[] = {"spices", "drinks", "baked_goods", "body_parts", "landforms"};

    private void pullData() {

        for (String file: files) {

        }

    }

    public String hobbitName(String name) {
        String hobbitName;

        // get name's first letter

        // pull all spices that begin with same letter in arraylist;

        // randomly select one of those spices

        // capitalize selected spice and add it to hobbitName

        // toss a coin to determine technique for last name

        // pull a drink+baked_good or body_part+landform

        // concatenate

        // capitalize and add to hobbitName

        return hobbitName;
    }
}
