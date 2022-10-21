public interface CommercialUse {

    /**
     *
     * @return true, if space is available for rent.
     */
    public boolean hasSpaceAvailableForRent();


    /**
     *
     * @return int number of indoor parking spots.
     */
    public int indoorParkingSpaces();


    /**
     * @return int number of total parking spots.
     */
    public int parkingSpaces();


    /**
     * @ return true, if building is suitable for restaurant
     */
    public boolean suitableForRestaurant();

}
