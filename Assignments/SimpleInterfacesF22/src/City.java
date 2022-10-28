public class City extends Place implements Local, Statistical, Transportation {

    private String climate;                     //   These are the minimum
    private int population;                     //   necessary class variables
    private String airportName;                 //   that are implied by
    private String harborName;                  //   the interfaces class City
    private String trainStationName;            //   implements. They are needed
    private boolean isBusServiceAvailable;      //   so that methods below can
    private boolean isSubwayServiceAvailable;   //   return meaningful values.


    public String describeClimate() {
        return climate;
    }

    public int population() {
        return population;
    }

    public boolean hasAirport() {
        return airportName != null;
    }

    public String nameOfAirport() {
        return airportName;
    }

    public boolean hasHarbor() {
        return harborName != null;
    }

    public String nameOfHarbor() {
        return harborName;
    }

    public boolean hasTrainStation() {
        return trainStationName != null;
    }

    public String nameOfTrainStation() {
        return trainStationName;
    }

    public boolean hasBusService() {
        return isBusServiceAvailable;
    }

    public boolean hasSubwayNetwork() {
        return isSubwayServiceAvailable;
    }
}  // class City
