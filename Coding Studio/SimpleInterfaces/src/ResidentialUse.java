public interface ResidentialUse{

    /**
     * @return boolean, true if place has a basement
     */
    public boolean hasBasement();


    /**
     * @return boolean, true if place has a garage
     */
    public boolean hasGarage();

    /**
     * @return int, number of space in garage
     */
    public int numberOfSpacesInGarage();


    /**
     * @return int, count of bedrooms in the place
     */
    public int numberOfBedrooms();


    /**
     * @return double, count of full bathrooms
     */
    public int numberOfFullBathrooms();


    /**
     * @return int, count of half bathrooms
     */
    public int numberOfHalfBathrooms();


    /**
     * return int, square footage of the place
     */
    public int squareFootage();


    /**
     * Causes the specified room to be redecorated
     */
    public void redecorate(String room);


    /**
     * @return boolean, place has a/c
     */
    public boolean hasAirConditioning();

}
