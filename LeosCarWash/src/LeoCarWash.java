/**
 * Implementation class for a car wash simulator.
 */
public class LeoCarWash {
    public static void main(String[] args) {
        /*
        Instantiate a Simulator object with the following specifications.

                                          arrival
                                      probability
                                                |
                         duration of car wash   |
                                            |   |
                  hours in the simulation   |   |
                                        |   |   |
             capacity of waiting area   |   |   |
                                    |   |   |   |
                                    |   |   |   |                                                */
        Simulator s = new Simulator(10, 10, 5, 1.0);
        s.report(); // invoke Simulator.report() which runs the simulation and reports its findings
    }
} // class LeoCarWash
