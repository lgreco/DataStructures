/**
 * A simple class to represent train stations. Notice that for now, we skip declaring the class fields as private.
 * This allows us to focus on the the functionality of the Station object. We'll worry about access modifiers later.
 */
public class Station {

    String code; // e.g. CHI, SMT, JOL, etc
    String name; // e.g. Chicago Union Station
    String town; // e.g. Chicago
    String state; // e.g. IL ... :-( consistency
    Station next; // the next station


    /**
     * Basic constructor: it creates an instance of a Station with all the
     * fields assigned, except for the next station.
     *
     * @param code
     * @param name
     * @param town
     * @param state
     */
    public Station(String code, String name, String town, String state) {
        this.code = code;
        this.name = name;
        this.town = town;
        this.state = state;
    } // constructor Station


    /**
     * Partial constructor
     *
     * @param name
     * @param town
     * @param state
     */
    public Station(String name, String town, String state) {
        this.code = code;
        this.name = name;
        this.town = town;
        this.state = state;
    } // constructor Station
} // class Station
