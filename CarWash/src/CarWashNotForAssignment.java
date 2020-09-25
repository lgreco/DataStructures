import java.util.Random;

public class CarWashNotForAssignment {

    BBQ myQ;
    Random rng = new Random();

    public CarWashNotForAssignment()      { myQ = new BBQ(10); } // default constructor CarWash
    public CarWashNotForAssignment(int c) { myQ = new BBQ(c);  } // constructor CarWash

    public boolean carArrives() {
        return rng.nextDouble() > 0.5; // let's go with 50% for now
    } // method carArrives

    public boolean carDeparts() {
        return rng.nextDouble() > 0.5;
    } // method carDeparts

    public void simulator() {
        CarWashNotForAssignment leoCarWash = new CarWashNotForAssignment(4);

        //main loop
        for (int time = 1; time <= 15; time++) {

            if ( carArrives() ) {
                // Name the car
                String carName = "Car" + String.format("%05d", time);
                if (leoCarWash.myQ.arrival(carName)) {
                    // car joined line ... update counts etc
                    // System.out.println(carName + " joins");
                    leoCarWash.myQ.miniDisplayQ();
                }
            }

            if ( carDeparts() ) {
                if (leoCarWash.myQ.departure()) {
                    // process departure
                    leoCarWash.myQ.miniDisplayQ();
                }
            }

        }

    } // method simulator

    public static void main(String[] args) {
        CarWashNotForAssignment demo = new CarWashNotForAssignment();
        demo.simulator();
    }
}
