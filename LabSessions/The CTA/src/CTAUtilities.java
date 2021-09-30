import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CTAUtilities {

    /**
     * Creates a scanner object for a given filename.
     *
     * File is assumed to be in the "working directory" for this project.
     *
     * @param filename String with filename to capture
     * @return Scanner object for file; null if file not found
     */
    private static Scanner fileScanner(String filename) {
        Scanner sc;
        File dataFile = new File(filename);
        try {
            sc = new Scanner(dataFile);
        } catch (FileNotFoundException e) {
            sc = null;
        }
        return sc;
    } // method fileScanner


    /**
     * This method is specific to the L Stations CSV file available from the Chicago Data Portal
     * https://data.cityofchicago.org/Transportation/CTA-System-Information-List-of-L-Stops/8pix-ypme
     *
     * The method uses positional information specific to the csv file that can be exported from
     * the page above, to acquire data and instantiate CTAStation objects. Before using this method
     * verify that the CSV file has the following positional structure for every line (the positions
     * below report to the values returned by Matcher).
     *
     *     [6] .... Station name (STATION_NAME)
     *    [12] .... Accessible (ADA)
     *    [14] .... Boolean for RED line
     *    [16] .... Boolean for BLUE line
     *    [18] .... Boolean for G (green) line
     *    [20] .... Boolean for BRN (brown) line
     *    [22] .... Boolean for P (purple) line
     *    [24] .... Boolean for Pexp (purple express) line
     *    [26] .... Boolean for Y (yellow) line
     *    [28] .... Boolean for Pnk (pink) line
     *    [30] .... Boolean for O (orange) line
     *    [32] .... Latitude and longitude (part of LOCATION item)
     *
     * Quotes and parentheses from [16] must be removed
     *      [32] = "(41.857908, -87.669147)"
     * and must be Transformed to two doubles
     *      double latitude = 41.857908
     *      double longitude = -87.669147
     * before Loaded into objects. (Yes, this is poor-man's ETL)
     *
     * @param filename String with file name we scan; the file is expected in the working
     *                 directory of the project.
     * @return true if scan successful
     */
    private static boolean scanFile(String filename) {
        boolean scanSuccessful = false;
        Scanner sc = fileScanner(filename);
        if (sc != null) {
            /*
            Set up a regex pattern to parse csv lines across commas but preserve items
            grouped together within double quotes.
             */
            Pattern pattern = Pattern.compile("\\s*(\"[^\"]*\"|[^,]*)\\s*");
            // Skip the header line; the if statement ensures we are not operating on empty file
            String line;
            if (sc.hasNext())
                line = sc.nextLine();
            while (sc.hasNext()) {
                // Pull a line from the scanner.
                line = sc.nextLine();
                // Parse it according to the pattern established to keep grouped items together
                Matcher matcher = pattern.matcher(line);
                // Pull the elements you need based on positional information
                int position = 0;
                String stationName="", location="";
                double latitude, longitude;
                while (matcher.find()) {
                    System.out.printf("\nPosition: %d, value: %s", position, matcher.group(1));
                    if (position == 6)
                        stationName = matcher.group(1);
                    if (position == 32)
                        location = matcher.group(1);
                    position++;
                }
                // Parse location to two strings; [0] is latitude, [1] is longitude
                String loc[] = location.split(",");
                // Clean up strings and convert to double values
                latitude = Double.valueOf(loc[0].replaceAll("[^.0-9]",""));
                longitude = Double.valueOf(loc[1].replaceAll("[^.0-9]",""));
                System.out.printf("%s | %s converted to %6.2f, %6.2f\n", stationName,location, latitude,longitude);
            }
            scanSuccessful = true;
        }
        return scanSuccessful;
    }


    public static void main(String[] args) {
        boolean success = scanFile("test.csv");
    }
}