import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class CTAUtilities {

    /**
     * Creates a scanner object for a given link to source data on the web.
     *
     * @param linkToData String with link to file online
     * @return Scanner object for file; null if file not found
     */
    private static Scanner CTAScanner(String linkToData) {
        /*
        Build a URL object. If the link is wrong, the URL object will be null.
         */
        URL url;
        try {
            url = new URL(linkToData);
        } catch (MalformedURLException e) {
            url = null;
        }
        /*
        Build a datastream (InputStream) object using the URL from above. If there is
        anything wrong with the URL, the Inputstream object will be null.
         */
        InputStream conduit;
        try {
            conduit = url.openStream();
        } catch (IOException e) {
            conduit = null;
        }
        /*
        Build a scanner to use the input stream based on the URL from above.
        If an input stream was not established successfully, i.e., if that object
        is null, the scanner will also be null. That will indicate, to the calling
        code that the scanning cannot proceed.
         */
        Scanner sc;
        try {
            sc = new Scanner(conduit);
        } catch (java.util.InputMismatchException e) {
            sc = null;
        }
        return sc;
    } // method CTAScanner

    /**
     * This method is specific to the L Stations CSV file available from the Chicago Data Portal
     * https://data.cityofchicago.org/Transportation/CTA-System-Information-List-of-L-Stops/8pix-ypme
     *
     * The method uses positional information specific to the csv file that can be exported from
     * the page above, to acquire data and instantiate CTAStation objects. Before using this method
     * verify that the CSV file has the following positional structure for every line (the positions
     * below report to the values returned by Matcher).
     *
     *     [3] .... Station name (STATION_NAME)
     *     [6] .... Accessible (ADA)
     *     [7] .... Boolean for RED line
     *     [8] .... Boolean for BLUE line
     *     [9] .... Boolean for G (green) line
     *    [10] .... Boolean for BRN (brown) line
     *    [11] .... Boolean for P (purple) line
     *    [12] .... Boolean for Pexp (purple express) line
     *    [13] .... Boolean for Y (yellow) line
     *    [14] .... Boolean for Pnk (pink) line
     *    [15] .... Boolean for O (orange) line
     *    [16] .... Latitude and longitude (part of LOCATION item)
     *
     * Quotes and parentheses from [16] must be removed
     *      [32] = "(41.857908, -87.669147)"
     * and must be Transformed to two doubles
     *      double latitude = 41.857908
     *      double longitude = -87.669147
     * before Loaded into objects. (Yes, this is poor-man's ETL)
     *
     *
     * @param linkToData String with URL to data source
     * @return ArrayList with CTA Station objects
     */
    public static DECIDE_DATA_STRUCTURE pullCTAData(String linkToData) {
        INITIALIZE_DATA_STRUCTURE
        Scanner sc = CTAScanner(linkToData);
        if (sc != null) {
            // Skip the header line; the if statement ensures we are not operating on empty file
            String line;
            if (sc.hasNext())
                line = sc.nextLine();
            while (sc.hasNext()) {
                // Pull a line from the scanner.
                line = sc.nextLine();
                String[] token = line.split("(,(?=\\S))");  // Some awesome regex from Alex Sobiak
                String stationName=token[3];
                double latitude, longitude;
                String loc[] = token[16].split(",");
                latitude = Double.valueOf(loc[0].replaceAll("[^.0-9]",""));
                longitude = Double.valueOf(loc[1].replaceAll("[^.0-9]",""));
            }
        }
        return DATA_STRUCTURE;
    }


    public static void main(String[] args) {
        //boolean success = scanFile("test.csv");
        ??? demo = pullCTAData("https://raw.githubusercontent.com/lgreco/DataStructures/master/data/stations.csv");

    }
}