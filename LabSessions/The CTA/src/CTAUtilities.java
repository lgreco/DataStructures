import java.util.ArrayList;
import java.util.Scanner;

public class CTAUtilities {

    public static Scanner fileScanner(String filename) {
        Scanner s = null;
        return s;
    } // method fileScanner


    public static ArrayList<CTAStation> loadStations(String filename) {
        ArrayList<CTAStation> station = new ArrayList<>();
        Scanner s = fileScanner(filename);
        if (s != null) {
            // read line from csv file
            CTAStation newStation = new CTAStation(...);
            if (!station.contains(newStation))
                station.add(...);
        }
        return station;
    } // method loadStations




}
