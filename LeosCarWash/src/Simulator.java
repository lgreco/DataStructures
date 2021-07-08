import java.util.Random;

public class Simulator {

    private static Random rng = new Random();
    private static WaitingArea w;
    private static int totalWaitTime = 0;
    private static int carsAccepted = 0;
    private static int carsRejected = 0;
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
    private void simulate() {

        boolean washingBayFree = true; // assume that the bay is free
        int minutesInSimulation = hours * MINUTES_PER_HOUR;

        int carWashTimer = 0;

        for (int timeIndex = 0; timeIndex < minutesInSimulation; timeIndex++) {


            if (carArriving(arrivalProbability)) {
                String arrivingCar = String.format("Car_%06d",timeIndex);
                if (w.addCar(arrivingCar)) {
                    carsAccepted++; // increase car count
                    int waitingTimeForThisCar = w.getOccupancy()*durationOfCarWash + (durationOfCarWash-carWashTimer);
                    totalWaitTime += waitingTimeForThisCar;
                } else {
                    carsRejected++;
                }
            }

            if (washingBayFree) {
                if (w.getOccupancy() > 0){
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

        avgWait = ((double) totalWaitTime) / ((double) carsAccepted);

    } // method simulate

    public void report() {
        simulate();
        System.out.printf("\n\n==================== Simulation of a car wash ====================\n");
        System.out.printf("\n%50s %6d", "Length of simulation (in minutes):", hours*MINUTES_PER_HOUR);
        System.out.printf("\n%50s %6d", "Length of car wash cycle (in minutes):", durationOfCarWash);
        System.out.printf("\n%50s %9.2f\n", "Arrival probability:", arrivalProbability);
        System.out.printf("\n%50s %6d", "Capacity of waiting area (in cars):", w.getCapacity());
        System.out.printf("\n%50s %6d", "Number of cars accepted in line:", carsAccepted);
        System.out.printf("\n%50s %6d", "Cars turned away because line was full:", carsRejected);
        System.out.printf("\n%50s %6d\n", "Total number of cars:", carsRejected+carsAccepted);
        System.out.printf("\n%50s %9.2f", "Average waiting time to wash (in minutes):", avgWait);
        System.out.printf("\n\n=================== End of car wash simulation ===================\n");
    }

}
