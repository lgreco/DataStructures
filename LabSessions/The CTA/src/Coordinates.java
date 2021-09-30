public class Coordinates {

    private static final double MAX_LATITUDE = 90.0;
    private static final double MAX_LONGITUDE = 180.0;

    private double latitude;
    private double longitude;

    /**
     * Full constructor. The constructor ensures that only legal values of latitude and longitude
     * can be used. If an excessive value is passed, the constructor calls the default constructor
     * and creates an object at the default coordinates.
     *
     * @param latitude double with geographic latitude in degrees
     * @param longitude double with geographic latitude in degrees
     */
    public Coordinates(double latitude, double longitude) {
        double absLat = Math.abs(latitude);
        double absLon = Math.abs(longitude);
        if (absLat > MAX_LATITUDE || absLon > MAX_LONGITUDE) {
            // Latitude or longitude values out of range; create object with default coordinates
            new Coordinates();
        } else {
            // Values are appropriate; create object with given coordinates
            this.latitude = latitude;
            this.longitude = longitude;
        }
    } // constructor Coordinates

    /**
     * Default constructor. It returns the coordinates of Chicago's 0/0 location at the
     * intersection of State and Madison.
     */
    private Coordinates() {
        this.latitude = 41.8819859;
        this.longitude = -87.6279159;
    } // constructor Coordinates


    /* Automatically generated code */

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
