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

    Station head; // the beginning of the Route

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
    void addStation(Station newStation) {
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
}
