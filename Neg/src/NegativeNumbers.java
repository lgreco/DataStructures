import java.util.Scanner;

public class NegativeNumbers {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        double x;
        boolean keepRunning = true;

        while (keepRunning) {

            System.out.printf("\nWelcome to Leo's Square Root Facility!\n" +
                    "Type non negative number and press enter (type -123 to quit): ");
            x = s.nextDouble();

            if (x == -123) {
                keepRunning = false;
            } else {
                if (x < 0) {
                    throw new IllegalArgumentException("You really needed a non negative number");
                } else {
                    System.out.printf("The square root of %.2f is %.2f",x,Math.sqrt(x));
                }
            }
        }

        System.out.printf("\n Thank you! \n");
    }
}
