import java.util.ArrayList;

/**
 * A simple class that chains Station objects one-after-the-other to recreate
 * a train route. As in class Station, access modifiers are omitted, so that
 * we can focus on functionality.
 *
 * Consider for example Amtrak's Lincoln Service. The train departs Chicago's
 * Union Station and travels to Saint Louis. Along the way it stops at
 * Summit, Joliet, Dwight, etc. Using three-letter codes for each station
 * and arrows to indicate direction of travel, the route can be shown as:
 *
 * CHI --> SMT --> JOL --> DWI --> PON --> BNL --> LIN --> SPI --> ...
 *
 * Each code above represents a Station object; e.g. BNL is the train station
 * in Bloomington-Normal, Ill. Each of these objects can be instantiated with
 * the basic constructor in class Station.
 *
 * A train route has one special station: the first station in the route. We
 * call that special station "head". If we know the head of a route, we can
 * reconstruct the rest of the train line: by looking at each Station object's
 * next pointer to find what station is next. The line ends when we arrive
 * at a station whose next pointer is null.
 *
 */
public class Route {

    /** The beginning of the Route. */
    Station head;

    /** Reserved for future use. */
    Station last;


    /**
     * Simple method to place a Station object in this Route. The method accepts
     * a Station object as input argument and places it to the end of the route.
     * The added Station becomes the new end of the line. To add a new station at
     * the end of the line, all we have to do is fine the last station and change
     * its next point from null to the new station we are adding. The method
     * assumes that if the route is empty, the first station added to it becomes
     * the head Station.
     *
     * @param newStation Station object to add to the end of the Route
     */
    public void addElement(Station newStation) {
        if (head == null) { // Route is empty
            head = newStation; // make new Station the head of the Route
        } else {
            /*
            Route is NOT empty. So we have to find the last station and add the
            newStation after it. To find the last Station in the Route, we go to
            its beginning, i.e., its head, and we traverse from one next pointer
            to the other until we reach a Station whose next pointer is null.

            In other words, method addStation goes to the beginning of the Route
            and moves along until it finds its last station. This is quite easy
            to implement since the beginning Station has a special name "head".
            Then we follow the chain of station (along the path indicated by the
            Station object's "next" field) until we encounter an object whose "next"
            is null. That's the end of the line and that's where the new station
            will be added.
             */
            Station current = head; // Start the traversal by going to the beginning
            while (current.next != null) {
                /*
                The current object has a next pointer that is not null. We can
                take a step forward to the next station
                 */
                current = current.next;
            }
            /*
            At the end of the while loop, the current object is the last station
            in the route, i.e., the Station whose next pointer is null. That's the
            Station object we'll "attach" the new Station to
             */
            current.next = newStation;
        }
    } // method addStation


    /**
     * Finds a Station object given a search parameter. We assume that the
     * three-letter code is a unique identifier for each Station object.
     *
     *    When we discussed this method in class we conducted the search
     *    in three parts: check the head object, check the chain of objects,
     *    and check the last object. The code below simplifies the search
     *    in two steps: first we search the chain of objects beginning from
     *    the first object (head). If this search yields no results, it means
     *    that the object we are looking for maybe the last object.
     *
     * @param searchForCode The three letter designation of the Station, e.g. DWI
     * @return true if such Station exists in Route; false otherwise
     */
    public boolean contains (String searchForCode) {
        boolean found = false; // Assume station does not exist
        Station current = head; // Start at the top
        /*
        The while-loop below checks every object in the chain except the last
        one. The condition to check an object is if it is followed by another
        object, i.e., the current object's next pointer is not null. Every
        object in the chain meets this condition except the last one. We'll
        check the last one -- if we have to -- after the loop.

        The loop ends when one of these conditions are met:
           - we find an object that meeds the search condition, or
           - we reach a Station whose .next is null
         */
        while (!found && current.next !=null ) {
            found = current.code.equals(searchForCode); // Station .code matches search argument?
            current = current.next;
        }
        /*
        Check the last Station but only if the loop above failed to find a
        Station with the code we are looking for.
         */
        if (!found) { // Still not found what we are looking for... Check one more Station
            found = current.code.equals(searchForCode); // Station .code matches search argument?
        }
        // At this point, boolean found has the answer to our search
        return found;
    } // method contains


    /**
     * Creates a string of with about int:limit characters per line. The method assume that the Route has at least
     * two stations. Based on that assumption, the method makes calls to head.next without trying to prevent a
     * null pointer exception.
     *
     * @param limit number of characters per line
     * @return String with route narrative
     */
    public String toString(int limit) {
        /* Fixed content is assigned to separate variables below. */
        final String OPENING = "The route starts at";
        final String CONTINUES = "and stops at";
        final String ENDS = "and finally at";
        String route, newContent; // Building blocks
        int lineLength = 0;
        if (head==null) { // If route is empty
            route = "Line is empty.\n\n";
        } else {
            /*
            Route is not empty. We begin by constructing the opening part of the String. But first we need to
            determine if the length specified as int:limit is sufficient to allow the opening content on a
            single line. In other cords, is
               limit > OPENING.length() + CONTINUES.length() + head.town.length()
            This is more of a style issue than anything else. I just want the openign content and the first
            station of the route to be in the same line, e.g.,

            Preferred:                                                   Instead of:
            The route starts at Chicago and stops at ...                 The route starts at
                                                                         Chicago and stops at ...

            If we anticipate that the length of the opening part is longer than the limit of character per line,
            then we adjust that limit up to accomodate the next station's town and the surrounding spaces and commas,
            hence the +4 below.
             */
            if (limit < (OPENING + head.town + CONTINUES).length() ) {
                limit = (OPENING + head.town + CONTINUES + head.next.town.length() + 4).length(); // Assume .next!=null
            }
            /*
            Now we can begin to build the string to return. String:route is initialized to the contents of the
            OPENING variable, followed by the town of the head Station, following by the contents of CONTINUES

            The route starts at Chicago and stops at
            -------------------^-------^------------
            OPENING             head.   CONTINUES
                                town
            %s                  %s      %s
             */
            route = String.format("\n\n%s %s %s ", OPENING, head.town, CONTINUES);
            lineLength = route.length(); // how long is this String:route?
            Station current = head.next; // Start traversing from the next station. Again, assume head.next != null
            while (current.next != null) {
                newContent = String.format("%s, ", current.town); // stuff we need to add to the route string
                route += newContent; // concatenate new content to existing string
                lineLength += newContent.length(); // how long will is String:route now?
                if (lineLength>limit) { // if allowed limit exceeded
                    lineLength = 0; // reset counter
                    route += "\n"; // add a new line to String:route
                }
                current = current.next; // move to the last station
            }
            route += String.format("%s %s.", ENDS, current.town); // add it to String; ok if length is exceeded a bit
        }
        return route;
    } // method toString


    /**
     * Method that finds if a Station in a Route is located at a specified town and state
     * @param town Town location of a station
     * @param state State location of a station
     * @return true if station present at town, state; false otherwise
     */
    public boolean contains(String town, String state) {
        boolean found = false; // assume such station not found
        if (head != null) {
            Station current = head;
            while (current != null && !found) {
                if (current.town.equals(town) && current.state.equals(state)) {
                    found = true;
                }
                current = current.next;
            }
        }
        return found;
    } // method contains


    /**
     * Method that counts the number of states a Route goes through. The method uses an Arraylist to hold the
     * states a Route goes through. States are added to this list only if they have not been added before.
     * The size of the Arraylist is the number of states traveled.
     *
     * @return non negative integer with the number of states traveled through
     */
    public int countStates() {
        ArrayList<String> states = new ArrayList<>(); // Arraylist with states traveled
        if (head!=null) { // if Route is not empty
            Station current = head;
            while (current!=null) { // traverse the list with no separate processing of last node
                String state = current.state;
                if (!states.contains(state)) { // have we been to this state before?
                    states.add(state); // no? Added to the stated visited.
                }
                current = current.next; // move to the next station
            }
        }
        return states.size();
    } // method countStates

} // class Route
