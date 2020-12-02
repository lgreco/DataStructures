import java.util.Scanner;

public class ArraysAreFun {
    public static void main(String[] args) {
        final int NUMBER_OF_DAYS = 7;
        Scanner s = new Scanner(System.in);
        double[] temperatures = new double[NUMBER_OF_DAYS];
        // read data into the day
        for (int i = 0; i < NUMBER_OF_DAYS; i++) {
            System.out.printf("\nEnter a temperature for day %d: ", i);
            temperatures[i] = s.nextDouble();
        } // temperature values read!

        // I can save the data on a file for later use ...

        // I can sort the data from low to high
        for ( int i=0; i < NUMBER_OF_DAYS-1; i++) { // left position for comparing
            for (int j = i + 1; j < NUMBER_OF_DAYS; j++) { // right position for comparing
                if (temperatures[i] > temperatures[j]) { // swap them
                    double temporary = temperatures[i];
                    temperatures[i] = temperatures[j];
                    temperatures[j] = temporary;
                }
            }
        }
        // are the sorted? Print out to find
        for (int i = 0; i < NUMBER_OF_DAYS; i++) {
            System.out.println(temperatures[i]);
        }



        // I can find the min and max temperature

        double minTemperature, maxTemperature;
        minTemperature = maxTemperature = temperatures[0];
        for ( int i = 1; i < NUMBER_OF_DAYS; i++) {
            if (temperatures[i] > maxTemperature) { maxTemperature = temperatures[i]; }
            if (temperatures[i] < minTemperature) { minTemperature = temperatures[i]; }
        }
        System.out.printf("\n\nThe min temperature recorded is %.2f and the max is %.2f", minTemperature,maxTemperature);

        RobertString rs = new RobertString();
        for (char ccc:rs.value) {
            System.out.println(ccc);
        }
    }
}
