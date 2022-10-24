/**
 * A simple class to represent a place. A place can be any geographical entity:
 * a town, a country, a national forest, etc.
 *
 * @version 20221021.1500
 */
public class Place {

    /** The name of the place */
    private String name;

    /** The geographic longitude of the place */
    private double longitude;

    /** The geographic latitude of the place */
    private double latitude;

    /** The altitude of the place */
    private int elevation;


    // Standard accessors and mutators

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setElevation(int elevation) {
        this.elevation = elevation;
    }

    public String getName() {
        return name;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public int getElevation() {
        return elevation;
    }

    /**
     * Simple String representation of the object
     * @return String with the object field values.
     */
    public String toString() {
        return "Place{" +
                "name='" + name + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", elevation=" + elevation +
                '}';
    }  // method toString

}
