public class SingleFamilyHome extends Building implements ResidentialUse {

    private int basementSqFt;
    private int carsInGarage;
    private int bedrooms;
    private int fullBaths;
    private int halfBaths;
    private int houseSurfaceArea;

    /**
     * @return boolean, true if place has a basement
     */
    public boolean hasBasement() {
        return basementSqFt > 0;
    }

    /**
     * @return boolean, true if place has a garage
     */
    public boolean hasGarage() {
        return carsInGarage > 0;
    }

    /**
     * @return int, number of space in garage
     */
    public int numberOfSpacesInGarage() {
        return carsInGarage;
    }

    /**
     * @return int, count of bedrooms in the place
     */
    public int numberOfBedrooms() {
        return bedrooms;
    }

    /**
     * @return double, count of full bathrooms
     */
    public int numberOfFullBathrooms() {
        return fullBaths;
    }

    /**
     * @return int, count of half bathrooms
     */
    public int numberOfHalfBathrooms() {
        return halfBaths;
    }

    /**
     * return int, square footage of the place
     */
    public int squareFootage() {
        return houseSurfaceArea;
    }

    /**
     * Causes the specified room to be redecorated
     *
     * @param room
     */
    public void redecorate(String room) {
        System.out.println("This room is now purple.");
    }

    /**
     * @return boolean, place has a/c
     */
    public boolean hasAirConditioning() {
        return false;
    }
}
