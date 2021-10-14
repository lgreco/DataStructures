import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class CTAUtilities {

    private static final double MADISON_STATE_LAT = 41.882067;
    private static final double MADISON_STATE_LON = -87.6283605;

    /**
     * Creates a scanner object for a given link to source data on the web.
     *
     * @param linkToData String with link to file online
     * @return Scanner object for file; null if file not found
     */
    public static Scanner CTAScanner(String linkToData) {
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
     * @return ArrayList with all the stations listed only once
     */
    public static ArrayList<CTAStation> pullCTAData(String linkToData) {
        ArrayList<CTAStation> stations = new ArrayList<CTAStation>();
        Scanner sc = CTAScanner(linkToData);
        if (sc != null) {
            // Skip the header line; the if statement ensures we are not operating on empty file
            String line;
            if (sc.hasNext())
                line = sc.nextLine();
            while (sc.hasNext()) {
                // Pull a line from the scanner.
                line = sc.nextLine();
                String[] token = line.split("(,(?=\\S))");  // Nice regex from Alex Sobiak
                String stationName=token[3];
                // Location is in the 17th column (index 16) and needs to be split into two parts.
                String loc[] = token[16].split(",");
                /*
                 Remove parentheses and quotes from strings with location information. Also make sure that any
                 minus signs (-) are preserved as they signify southern latitudes or western longitudes.
                 */
                double latitude = Double.valueOf(loc[0].replaceAll("[^.0-9-]",""));
                double longitude = Double.valueOf(loc[1].replaceAll("[^.0-9-]",""));
                CTAStation newStation = new CTAStation(stationName, latitude, longitude);
                /*
                Next, we need to find if the station is already in the list.
                 */
                boolean isStationListed = false;
                for (CTAStation s:stations) {
                    if (s.getName().equals(newStation.getName()))
                        isStationListed = true;
                }
                if (!isStationListed)
                    stations.add(newStation);
            } // while loop
        } // scanner not null
        return stations;
    } // method pullCTAData


    /**
     * Compute Great Circle distance between two points on Earth.
     *
     * Usage:
     *
     *         double dist = distance(lat1, lon1, lat2, lon2)
     *                                ----------  ----------
     *                                     |           |
     *                                     |           Geographic coordinates
     *                                     |           of second point, in degrees
     *                                     |           of latitude and longitude.
     *                                     |
     *                                     Geographic coordinates
     *                                     of first point, in degrees
     *                                     of latitude and longitude.
     *
     * Based on the haversine formula (https://en.wikipedia.org/wiki/Haversine_formula):
     *
     * d = 2 * r * arcsin(sqrt(
     *                         hav(lat2-lat1) +
     *                         cos(lat1)*cos(lat2)*hav(lon2-lon1)
     *                         ))
     *
     * where hav is the haversine function, hav(x) = sin^2(x/2).
     *
     * The computed distance is subject to slight numerical errors because (a) the formula
     * assumes that Earth is a sphere, when it is not, and; (b) Math's toRadians is prone
     * to rounding errors.
     *
     * @param lat1 double Latitude of first point
     * @param lon1 double Longitude of first point
     * @param lat2 double Latitude of second point
     * @param lon2 double Longitude of second point
     * @return double distance between two points
     */
    public static double distance(double lat1, double lon1, double lat2, double lon2) {

        // Radius of earth, in miles. Use 6371 to compute in kilometers.
        final double EARTH_RADIUS = 3958.8;

        /*
        Convert latitudes to radians (the unit used by Math's trig functions). No such conversion
        is needed for the longitude values because they are not used individually in a trigonometric
        function. Instead, convert their different to radians to use in the second hav() function.
         */
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // Latitude difference for hav function (they are already in radians)
        double deltaLatitude = lat2-lat1;
        // Longitude difference for hav function (converted to radians)
        double deltaLongitude = Math.toRadians(lon2 - lon1);

        /*
        Build haversine formula step-by-step, for clarity. First compute the haversine functions
        for latitude and longitude using the substitution hav(x) = sin^2(x/2). Next, assemble the
        trig expression that goes the square root. And finally build the formula.
         */

        double latHav = Math.pow(Math.sin(deltaLatitude/2.0), 2.0);
        double lonHav = Math.pow(Math.sin(deltaLongitude/2.0), 2.0);
        double cosines = Math.cos(lat1)*Math.cos(lat2);
        double underRoot = latHav + cosines*lonHav;

        // Return value, assigned negative in case we fail to compute formula
        double d = -1.0;
        if (underRoot >= 0.0)
            d = 2 * EARTH_RADIUS * Math.asin(Math.sqrt(underRoot));
        return d;
    } // method distance

    /**
     * When distance is called with only a single set of coordinates, it uses the coordinates for Madison and
     * State.
     *
     * @param lat double latitude of location
     * @param lon double longitude of location
     * @return double Distance between the location passed and Madison & State
     */
    public static double distance(double lat, double lon) {
        return distance(lat, lon, MADISON_STATE_LAT, MADISON_STATE_LON);
    }

} // class CTAUtilities