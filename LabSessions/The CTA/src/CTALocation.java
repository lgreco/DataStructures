/**
 * A superclass for CTA locations. CTA locations are either bus stops or train stations. This superclass
 * captures the common characteristics of these two types of locations: all locations have a name, an address,
 * and a hashtag. The different characteristics (for example, stations may have elevators, bus stops don't)
 * are delegated to two classes that extend this class.
 */
public class CTALocation implements Comparable<CTALocation> {

    private static final String NOT_AVAILABLE_MESSAGE = "Information not available";


    /** The name of the location, e.g., "95th Street" */
    private String name;

    /** The address of the location, e.g. "15 West 95th Street". Eventually we need an Address object here. */
    private String address;

    /** Hashtag for social media use because we are ... cool! */
    private String hashTag;

    /** Geographic coordinates */
    private double latitude, longitude;


    /**
     * Basic constructor. It assigns a name to a location and sets up a hashtag for it as well.
     *
     * @param name String with name of a location.
     */
    public CTALocation(String name) {
        this.name = name;
        this.address = NOT_AVAILABLE_MESSAGE;
        this.hashTag = "#" + name.toLowerCase();
    } // constructor CTALocation


    /**
     * Constructor for name and geographic coordinates
     * @param name String with station name
     * @param latitude double Geographic latitude
     * @param longitude double Geographic longitude
     */
    public CTALocation(String name, double latitude, double longitude) {
        this(name);
        this.latitude = latitude;
        this.longitude = longitude;
    } // constructor CTALocation


    /***
     * Method to compare distance of two locations from downtown Chicago, in fulfillment of the Comparable interface.
     *
     * @param other CTALocation passed into the method
     * @return int Positive if invoking object further from downtown than passed object,
     *             Zero if both objects at same distance from downtown,
     *             negative if invoking object closer to downtown.
     */
    public int compareTo(CTALocation other) {
        // Distance of location object invoking this method, from downtown Chicago.
        double thisDistanceFromMadisonState = CTAUtilities.distance(
                this.getLatitude(), this.getLongitude());
        // Distance of location object passed into this method, from downtown Chicago.
        double otherDistanceFromMadisonSate = CTAUtilities.distance(
                other.getLatitude(), other.getLongitude());
        // The difference between these distances, cast as int, indicates their relative order.
        return (int) (thisDistanceFromMadisonState-otherDistanceFromMadisonSate);
    } // method compareTo


    /**
     * Method that returns a customized string with meaningful description of a CTALocation object.
     *
     * @return String with information about this CTALocation
     */
    public String toString() {
        String s = String.format("CTA has a location called \"%s\"", name);
        if (latitude!=0 && longitude != 0) {
            s = s + String.format(" and can be found on <a href=\"https://maps.google.com/?q=%f,%f\">Google Maps:</a>\n",
                    latitude, longitude);
        }
        return s;
    } // method toString


    /* Automatically generated methods */

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getHashTag() {
        return hashTag;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
} // class CTALocation