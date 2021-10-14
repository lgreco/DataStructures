public class CTATrainRoute {

    /** The first station of a train line */
    private CTAStation head;


    /**
     * Method to add train stations to the line.
     *
     * New stations are ALWAYS added to the end of the list.
     *
     * @param ctaStation The CTAStation object to add to the end of this train route
     */
    public void add(CTAStation ctaStation) {
        if (head == null) {
            // Route is empty. Make new station the beginning of the line.
            head = ctaStation;
        } else {
            /*
            Route is not empty!

            Find where this route ends. To do so, board a train at the head of the line and
            let the train travel along the route. You can send the train to the next station,
            if there is one, and repeat these one-station-at-a-time trips. Until there is
            nowhere else to go. That's the last station.
             */
            CTAStation current = head;
            while (current.hasNext()) {
                current = current.getNext();
            }
            /*
            The while-loop above lands you at the last station of the line. What do you need to do?
             */
            current.setNext(ctaStation);

        }
    } // method add


    /**
     * Method that tells if a route contains a station, based on the name of it.
     *
     * @param name String with name of station we are looking for
     * @return true if station exists in route
     */
    public boolean contains(String name) {
        boolean success = false;
        return success;
    } // method contains


    /**
     *
     * @return
     */
    public String toString() {

    } // method toString

} // class CTATRainRoute
