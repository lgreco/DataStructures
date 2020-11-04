import java.util.Random;

public class FindTheBug {
    public static void main(String[] args) {

        Random rng = new Random();

        int counter = 0;

        // an initial event ...
        String currentEvent;
        String previousEvent;

        if (rng.nextDouble() > 0.5) {
            currentEvent = "H";
        } else {
            currentEvent = "T";
        }

        while (counter!=3) {

            System.out.printf("%s ", currentEvent);

            previousEvent = currentEvent;

            if (rng.nextDouble() > 0.5) {
                currentEvent = "H";
            } else {
                currentEvent = "T";
            }

            if (currentEvent.equals("H")) {
                if (currentEvent.equals(previousEvent)) {
                    counter++;
                }else {
                    counter = 0;
                }
            }
        }
    }
}
