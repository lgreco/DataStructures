import java.util.Random;

/**
 * A simulator for a car wash based on the simple FIFO queue class BBQ.
 */
public class CarWash {

    private final static int DEFAULT_CAR_WASH_DURATION = 3;
    private final static int DEFAULT_ARRIVAL_INTERVAL = 5;
    private final static int DEFAULT_QUEUE_CAPACITY = 4;
    private final static int LENGTH_MULTIPLIER = 500;
    private final static int DEFAULT_SIMULATION_LENGTH = 720;

    /* How long to run the simulation; determined upon instantiation, as 500 * carWashDuration */
    private final int simulationLength;

    /* Random arrival interval upper bound; lower is 0 */
    private final int arrivalInterval;

    /* How long is the wash cycle */
    private final int carWashDuration;

    /* Queue capacity, passed to class BBQ */
    private final int queueCapacity;

    /* The following fields are computed during the simulation */
    private double averageWait;
    private double averageMinWait;
    private int maxWaitingTime;
    private int carCountJoining;
    private int carCountRejected;
    private int carCountTotal;


    /* Various accessors; not sure all all needed, but don't they look cute? */
    private double getAverageWait()      { return averageWait; }      // accessor getAverageWait
    private int    getCarCountJoining()  { return carCountJoining; }  // accessor getCarCount
    private int    getCarCountRejected() { return carCountRejected; } // accessor carCountRejected
    private int    getCarCountTotal()    { return carCountTotal; }    // accessor CarCountTotal

    public CarWash() {
        carWashDuration = DEFAULT_CAR_WASH_DURATION;
        arrivalInterval = DEFAULT_ARRIVAL_INTERVAL;
        queueCapacity = DEFAULT_QUEUE_CAPACITY;
        simulationLength = DEFAULT_SIMULATION_LENGTH;
        averageWait = carCountJoining = carCountRejected = carCountTotal= 0;
    } // default constructor CarWash

    public CarWash(int carWashDuration, int arrivalInterval, int queueCapacity) {
        this.carWashDuration = carWashDuration; //
        this.arrivalInterval = arrivalInterval; //
        this.queueCapacity = queueCapacity;
        simulationLength = DEFAULT_SIMULATION_LENGTH; //
        averageWait = carCountJoining = carCountRejected = carCountTotal = 0;
    } // parametric constructor CarWash

    private Random rng = new Random();

    /**
     * The principal method of the class.
     */
    public void simulator() {

        BBQ myQ = new BBQ(queueCapacity);

        /* Initialize method variables */
        int nextCarAt = rng.nextInt(arrivalInterval); // first car arrival in the simulation
        int waitingTimeSum = 0; // sum accumulator for average wait time
        int minWaitingTimeSum = 0; // sum accumulator for average MIN wait time
        int timeForNextWash = 0; // Time when next wash begins -- assume that first wash can begin now.
        int timeWashStarts = 0; // captures the timeIndex when car enters bay;
        int timeUntilWashEnds;  // calculates wash time in progress when car joins queue

        /* Initialize class variables */
        maxWaitingTime = 0; // reports longest waiting time

        /** main loop */
        for ( int timeIndex = 0; timeIndex < simulationLength; timeIndex++ ) {

            // if car arrives during this iteration, add it to the queue
            if ( timeIndex == nextCarAt ) {
                carCountTotal++;
                String carName = "Car" + String.format("%05d", timeIndex);

                // determine the next car arrival
                nextCarAt = timeIndex + rng.nextInt(arrivalInterval) + 1;

                if ( myQ.arrival(carName) ) {

                    /*
                    If there is a car wash in progress, we need to add the remaining
                    time of the wash-in-progress to the waiting time in the car. But
                    we do not check to see if there is a car wash in progress, we just
                    assume that they may be one, in which case the computation below
                    may result in a negative number. Using max(0,...) takes care of that.
                     */
                    timeUntilWashEnds = Math.max(0, timeWashStarts + carWashDuration - timeIndex);

                    // If this is the only car in line, update the min waiting time.
                    if ( myQ.getSize() == 1 ) {

                        // We keep adding these min times because we want to compute an avg at the end.
                        minWaitingTimeSum = minWaitingTimeSum + timeUntilWashEnds;
                    }

                    // Waiting time for the car just joining queue:
                    int waitingTime = (myQ.getSize()-1) * carWashDuration + timeUntilWashEnds;
                    //                =================                     =================
                    //                number of cars in                     remaining
                    //                front of it -- must                 + time
                    //                wait for them to be                   for the
                    //                washed first                          wash in progress

                    waitingTimeSum = waitingTimeSum + waitingTime;
                    carCountJoining++;

                    // Max waiting time update.
                    maxWaitingTime = ( waitingTime > maxWaitingTime ) ? waitingTime : maxWaitingTime;

                } else {
                    carCountRejected++;
                }
            }

            /*
            Determine if a car is departing. A car is departing the queue when wash bay becomes idle.
            The time for that is recorded as timeForNextWash. When the bay becomes idle, the
            timeForNextWash is updated to indicate when the new wash cycle will finish.
             */
            if ( timeIndex == timeForNextWash ) {
                if ( myQ.departure() ) {

                    // A new wash cycle starts now.
                    timeWashStarts = timeIndex;

                    // This wash cycle will end at
                    timeForNextWash = timeWashStarts + carWashDuration;
                } else {
                    /*
                    If there is no car to remove from the queue, we make the car wash bay
                    available for the next simulation cycle.
                     */
                    timeForNextWash++;
                }
            }
        } // end of main simulation loop

        /* Computer avg wait time; straight-forward! */
        averageWait = ( (double) waitingTimeSum) / ( (double) carCountJoining);

        /* Compute avg min wait time */
        averageMinWait = ( (double) minWaitingTimeSum ) / ( (double) carCountJoining);

    } // method simulator

    /**
     * Main method.
     */
    public static void main(String... args) {
        CarWash demo = new CarWash(4,15,4); // duration, arrival interval, capacity
        demo.simulator();
        demo.reportResults();
    }

    /**
     * Method to printout results in a nice 1980s style.
     */
    public void reportResults() {
        System.out.println("\n************************************************************");
        System.out.println("*\tL E O ' S     C A R     W A S H     S I M U L A T O R  *");
        System.out.println("************************************************************");
        System.out.printf("\n\tQueue capacity: ...................... %5d cars\n", queueCapacity);
        System.out.printf("\n\tDuration of wash cycle: .............. %5d minutes", carWashDuration);
        System.out.printf("\n\tArrival interval, up to: ............. %5d minutes",arrivalInterval);
        System.out.printf("\n\tLength of simulation: ................ %5d minutes\n", simulationLength);
        System.out.printf("\n\tNumber of cars admitted: ............. %5d", carCountJoining);
        System.out.printf("\n\tNumber of cars rejected: ............. %5d", carCountRejected);
        System.out.printf("\n\tTotal number of cars: ................ %5d\n", carCountTotal);
        System.out.printf("\n\tAverage waiting time: ................ %8.2f minutes", averageWait);
        System.out.printf("\n\tAverage min. waiting time: ........... %8.2f minutes", averageMinWait);
        System.out.printf("\n\tMax. waiting time: ................... %5d minutes\n\n", maxWaitingTime);
        System.out.println("************************************************************\n");
    }
}