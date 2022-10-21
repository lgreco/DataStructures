public interface ResidentialUse{

    /**
     * @return int with number of bedrooms in the object
     */
    public int numberOfBedrooms();


    /**
     * @return int with number of full bathrooms in the object
     */
    public int numberOfFullBathrooms();


    /**
     * @return int with number of half bathrooms in the object
     */
     public int numberOfHalfBathrooms();


    /**
     * @return int with number of outlets in the object
     */
    public int numberOfOutlets();


    /**
     * @return boolean true if fancy appliances
     */
    public boolean areAppliancesStainlessSteel();


    /**
     * @return int with number of cars fitting in garage
     */
    public int garageSpaces();
}
