public class SmallHouse {

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

    /** Default constructor */
    public SmallHouse() {
        this.buildingDescription = "small house";
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
}
