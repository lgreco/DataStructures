import java.util.Random;

public class Simulator {

    private static Random rng = new Random();
    private static WaitingArea w;
    private static int totalWaitTime = 0;
    private static int carCount = 0;
    private static int hours;
    private static int durationOfCarWash;
    private static double arrivalProbability;
    private static double avgWait;

    private static final int MINUTES_PER_HOUR = 60;


    /** Default constructor */
    public Simulator() {
        w = new WaitingArea(10);
        hours = 12;
        durationOfCarWash = 5;
        arrivalProbability = 0.5;
    } // Default constructor Simulator


    /** Full constructor */
    public Simulator(int capacity, int hours, int durationOfCarWash, double arrivalProbability) {
        w = new WaitingArea(capacity);
        this.hours = hours;
        this.durationOfCarWash = durationOfCarWash;
        this.arrivalProbability = arrivalProbability;
    } // Full constructor Simulator


    /**
     * Signals the arrival of a car with a given probability.
     *
     *                            probability range
     *     |------------------------------|------------------------------|
     *     0.0                           0.5                           1.0
     *     low                                                        high
     *     frequency                 fifty-fifty                 frequency
     *     arrivals                   chance of                   arrivals
     *
     *     (no arrivals                                          (non-stop
     *     at 0.0)                                        arrivals at 1.0)
     *
     * @param probability of arrival
     * @return true if random number less than prob (meaning car is arriving)
     */
    private boolean carArriving(double probability) {
        return (probability > rng.nextDouble());
    } // method carArriving


    /**
     * This is the principal method. It runs through the specified time period
     * and collects data about arrivals and departures at the car wash.
     *
     */
    public void simulate() {

        boolean washingBayFree = true; // assume that the bay is free
        int minutesInSimulation = hours * MINUTES_PER_HOUR;

        int carWashTimer = 0;

        for (int timeIndex = 0; timeIndex < minutesInSimulation; timeIndex++) {


            if (carArriving(arrivalProbability)) {
                String arrivingCar = String.format("Car_%06d",timeIndex);
                if (w.addCar(arrivingCar)) {
                    carCount++; // increase car count
                    int waitingTimeForThisCar = w.getSize()*durationOfCarWash + (durationOfCarWash-carWashTimer);
                    totalWaitTime += waitingTimeForThisCar;
                }
            }

            if (washingBayFree) {
                if (w.getSize() > 0){
                    washingBayFree = false; // occupy carwash bay
                    carWashTimer = 0; // reset carwash timer
                    String carBeingWashed = w.moveCartoWashingBay();
                }
            }

            carWashTimer++; // update timer

            if (carWashTimer==durationOfCarWash) {
                carWashTimer = 0;
                washingBayFree = true;
            }

        }

    } // method simulate

}
