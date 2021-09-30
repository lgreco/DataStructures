/**
 * A superclass for CTA locations. CTA locations are either bus stops or train stations. This superclass
 * captures the common characteristics of these two types of locations: all locations have a name, an address,
 * and a hashtag. The different characteristics (for example, stations may have elevators, bus stops don't)
 * are delegated to two classes that extend this class.
 */
public class CTALocation {

    private static final String NOT_AVAILABLE_MESSAGE = "Information not available";

    /** The name of the location, e.g., "95th Street" */
    private String name;

    /** The address of the location, e.g. "15 West 95th Street". Eventually we need an Address object here. */
    private String address;

    /** Hashtag for social media use */
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
     *
     * @param name
     * @param latitude
     * @param longitude
     */
    public CTALocation(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    } // constructor CTALocation


    /* Automagically generated code */


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
