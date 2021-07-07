import java.util.Random;

public class Simulator {

    private static final int MINUTES_PER_HOUR = 60;
    private static Random rng = new Random();
    private static WaitingArea w = new WaitingArea(10);


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
     *
     * @param hours
     * @param durationOfCarWash
     */
    public void simulate(int hours, int durationOfCarWash) {

        boolean washingBayFree = true; // assume that the bay is free
        int minutesInSimulation = hours * MINUTES_PER_HOUR;

        int carWashTimer = 0;
        int carCount = 0;


        for (int timeIndex = 0; timeIndex < minutesInSimulation; timeIndex++) {

            System.out.printf("\n\nAt time index %06d:",timeIndex);

            if (carArriving(0.5)) {
                System.out.printf("\n\tA car is arriving. There are %d/%d cars in line.", w.getSize(), w.getCapacity());
                String arrivingCar = String.format("Car_%06d",timeIndex);
                if (w.addCar(arrivingCar)) {
                    System.out.printf("\n\t\tCat labeled %s has been added to the queue.", arrivingCar);
                    System.out.printf("\n\t\tThere are now %d/%d cars in line.", w.getSize(), w.getCapacity());
                    carCount++; // increase car count
                    int waitingTimeForThisCar = w.getSize()*durationOfCarWash + (durationOfCarWash-carWashTimer);
                } else {
                    System.out.printf("\n\t\tQueue is full with %d/%d cars. Arriving car leaves.", w.getSize(), w.getCapacity());
                }
            }

            if (washingBayFree) {
                System.out.printf("\n\tCarwash bay is available.");
                if (w.getSize() > 0){
                    System.out.printf("\n\t\tAnd the line is not empty.");
                    washingBayFree = false; // occupy carwash bay
                    carWashTimer = 0; // reset carwash timer
                    String carBeingWshed = w.moveCartoWashingBay();
                    System.out.printf("\n\t\t%s is moved to the carwash bay, and wash timer is restarted.", carBeingWshed);
                } else {
                    System.out.printf("\n\t\tBut there is no one in line. Oh well!");
                }
            } else {
                System.out.printf("\n\t\tCar wash in progress, time lapsed %d/%d", carWashTimer, durationOfCarWash);
            }

            carWashTimer++; // update timer

            if (carWashTimer==durationOfCarWash) {
                System.out.printf("\n\tCarwash cycle completed. Bay is again available.");
                carWashTimer = 0;
                washingBayFree = true;
            }

        }
    } // method simulate

}
