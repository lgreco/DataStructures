public class CommercialBuilding extends Building implements CommercialUse{

    private int numberOfStories;
    private int totalParkingSpaces;
    private int indoorParkingSpaces;
    private boolean restaurantPermitPossible;
    private int spaceAvailableForRent;


    public boolean hasSpaceAvailableForRent() {
        return spaceAvailableForRent>0;
    }

    public int indoorParkingSpaces() {
        return indoorParkingSpaces;
    }


    public int parkingSpaces() {
        return totalParkingSpaces;
    }

    public boolean suitableForRestaurant() {
        return restaurantPermitPossible;
    }
}
