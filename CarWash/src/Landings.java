import java.util.Random;
/**
 * Simple demo of event-driven computing. Everything is given in a main ()
 * method for simplicity, but in a more realistic approach everything
 * should be decomposed to dedicated methods.
 */
public class Landings {
    public static void main(String[] args) {
        Random rng = new Random();
        int duration = 24*60; // 24 hours, minute by minute
        double probability = 0.998;
        // main loop: at every cycle we look for random events.
        for (int minute = 0; minute < duration; minute++) {
            if ( rng.nextDouble() > probability ) {
                System.out.println("There was a landing at minute: " + minute);
            }
        }
    }
}
