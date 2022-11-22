public class ResidentialCarGarage {

    /** Description of the building */
    private String buildingDescription;

    /** Number of floors or levels */
    private int floors;

    /** Type of roof material */
    private String roofMaterial;

    /** Roof design */
    private String roofDesign;

    /** Entrance shape */
    private String entranceShape;

    /** Entrance material */
    private String entranceMaterial;

    /** Number of cars accommodated */
    private int cars;

    /** Default constructor */
    public ResidentialCarGarage() {
        this.buildingDescription = "garage";
    }

    /**
     * Description of roof
     */
    public void roof() {
        System.out.printf("\nThis %s has a %s roof made of %s.",
                this.buildingDescription, this.roofDesign, this.roofMaterial);
    }

    /**
     * Description of entrance
     */
    public void entrance() {
        System.out.printf("\nThis %s has a %s style entrance made of %s",
                this.buildingDescription, this.entranceShape, this.entranceMaterial);
    }

    /**
     * Describe car space
     */
    public void parking() {
        String noun = (this.cars > 1) ? "cars" : "car";
        System.out.printf("\nThis %s can accomodate %d %s.",
                this.buildingDescription, this.cars, noun);
    }
}