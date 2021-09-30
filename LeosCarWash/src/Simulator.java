import java.util.Random;

/**
 * A simulation engine for the car wash problem. The engine is based on a static instance of class WaitingArea
 * to create a FIFO queue for the cars waiting to be washed. Several other static fields track the status of
 * the simulation and contribute to the reporting of its results. This engine exposes only method report to
 * the user. The rest of its methods are private, as are its fields.
 */
public class Simulator {

    /** Array-based FIFO object for car wash's waiting area */
    private static WaitingArea w;

    /** Computation fields */
    private static Random rng = new Random(); // RNG for arrival process
    private static int totalWaitTime = 0; // accumulator for time cars spend waiting
    private static int carsAccepted = 0; // counter for cars that joined the line
    private static int carsRejected = 0; // counter for cars that left because there was no room in the line
    private static int lengthOfSimulation; // length of simulation (in hours)
    private static int durationOfCarWash; // length of car wash (in minutes)
    private static double arrivalProbability; // likelihood that car arrives at each simulated minute
    private static double avgWait; // average waiting time
    private static double probabilityTurnedAway; // probability of being turned away because line is full

    private static final int MINUTES_PER_HOUR = 60; // for hour-to-minute conversions


    /** Default constructor */
    public Simulator() {
        w = new WaitingArea(10);
        lengthOfSimulation = 12;
        durationOfCarWash = 5;
        arrivalProbability = 0.5;
    } // Default constructor Simulator


    /** Full constructor */
    public Simulator(int capacity, int hours, int durationOfCarWash, double arrivalProbability) {
        w = new WaitingArea(capacity);
        this.lengthOfSimulation = hours;
        this.durationOfCarWash = durationOfCarWash;
        this.arrivalProbability = arrivalProbability;
    } // Full constructor Simulator


    /**
     * Method to signal the arrival of a car with a given probability.
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
     * This is the principal method. It runs through the specified time period and collects data about arrivals and
     * departures at the car wash. The method employs a for-loop to time the simulated period, in minutes. For every
     * minute in the simulation, we look at the following events.
     *
     *    * Is a car arriving? If yes, is there room in the line for one more car?
     *
     *    * Is the car wash bay available? If yes, are there cars in line? If yes, move the first car in line
     *      to the car wash bay.
     *
     * At every step, the simulation engine updates a timer for how long the car wash bay has been active. When
     * that timer reaches the duration of the car wash cycle, the car wash bay is marked available and its timer
     * resets to 0.
     *
     */
    private void simulate() {

        int minutesInSimulation = lengthOfSimulation * MINUTES_PER_HOUR;

        boolean washingBayFree = true; // assume that the bay is free
        int carWashTimer = 0; // and set its timer to 0

        /*
        The simulation loop.
         */
        for (int timeIndex = 0; timeIndex < minutesInSimulation; timeIndex++) {

            /*
            In the event of a car arrival, we check to see if there is room in the line. If so, we add the car to
            the waiting area and calculate its waiting time. Then we add that waiting time to the simulation's
            accumulator for waiting time.
             */
            if (carArriving(arrivalProbability)) {
                String arrivingCar = String.format("Car_%06d",timeIndex);
                if (w.addCar(arrivingCar)) { // addCar returns true if there is room in waiting area
                    carsAccepted++; // increase car count
                    int waitingTimeForThisCar = w.getOccupancy()*durationOfCarWash + (durationOfCarWash-carWashTimer);
                    totalWaitTime += waitingTimeForThisCar; // update accumulator with waiting time for this car
                } else {
                    carsRejected++; // No room in the waiting area; update rejected counter.
                }
            }

            /*
            In the event the car wash bay is available, we check the occupancy of the waiting area. If occupancy > 0
            there are cars waiting, and we pull the first car from the line into the washing bay, by markin the
            bay busy (ie not free). We also reset the car wash timer to 0. Moving a car from the front of the line
            is done with moveCarToWashingBay() method that also moves the remaining cars one step closer to the
            front of the line.
             */
            if (washingBayFree) {
                if (w.getOccupancy() > 0){
                    washingBayFree = false; // occupy carwash bay
                    carWashTimer = 0; // reset carwash timer
                    String carBeingWashed = w.moveCartoWashingBay();
                }
            } else {
                carWashTimer++; // update timer when car wash bay in use
            }

            /*
            A car wash cycle ends when the car wash timer reaches the duration of a car wash. In this event,
            we reset the timer to 0, and we mark the washing bay as available (free).
             */
            if (carWashTimer==durationOfCarWash) {
                carWashTimer = 0;
                washingBayFree = true;
            }

        } // simulation loop

        avgWait = ((double) totalWaitTime) / ((double) carsAccepted);
        probabilityTurnedAway = ((double) carsRejected) / ((double) carsAccepted + (double) carsRejected);

    } // method simulate


    /**
     * This method runs the simulation and prints the result. It's the only public method of the class (ok,
     * constructors are also public but technically not methods).
     */
    public void report() {
        simulate(); // Invoke simulation engine first, then report the results
        System.out.printf("\n\n==================== Simulation of a car wash ====================\n");
        System.out.printf("\n%50s %6d", "Length of simulation (in minutes):", lengthOfSimulation *MINUTES_PER_HOUR);
        System.out.printf("\n%50s %6d", "Length of car wash cycle (in minutes):", durationOfCarWash);
        System.out.printf("\n%50s %9.2f\n", "Arrival probability:", arrivalProbability);
        System.out.printf("\n%50s %6d", "Capacity of waiting area (in cars):", w.getCapacity());
        System.out.printf("\n%50s %6d", "Number of cars accepted in line:", carsAccepted);
        System.out.printf("\n%50s %6d", "Cars turned away because line was full:", carsRejected);
        System.out.printf("\n%50s %6d\n", "Total number of cars:", carsRejected+carsAccepted);
        System.out.printf("\n%50s %9.2f", "Average waiting time to wash (in minutes):", avgWait);
        System.out.printf("\n%50s %9.2f", "Probability of finding the line full:", probabilityTurnedAway);
        System.out.printf("\n\n=================== End of car wash simulation ===================\n");
    } // method report
} // class Simulator
