import java.util.Random;

/**
 * Simple demo of event-driven computing
 */
public class Landings {

    static Random rng = new Random();

    /**
     * Create an event at random with a prob 1%
     * @return true if event is generated
     */
    static boolean landing() {
        return rng.nextDouble() > 0.99;
    }

    public static void main(String[] args) {
        // main loop: at every cycle we look for random events.
        for ( int minute = 0; minute < 24*60; minute++) {
            if ( landing() ) {
                System.out.println("There was a landing at minute: " + minute);
            }
        }
    }
}
