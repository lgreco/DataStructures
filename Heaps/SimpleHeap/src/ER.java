import java.util.Random;

/**
 * Implementation class for the EmergencyRoom simulator
 */
public class ER {

    /** How many times to repeat the experiment (for average smoothing) */
    static int R;

    /** Number of observations */
    static int N;

    /** Number of triage levels in increasing severity */
    static int T;

    /** Capacity of ER waiting room */
    static int C;

    /** RNG for determining arrival of patients and availability of ER space */
    static Random rng = new Random();

    static long times[]; // Array to accumulate waiting times for each triage tier.
    static int tierCount[]; // Array to count arrivals for each triage tier.

    /** Full constructor */
    public ER(int repetitions, int observations, int triageLevels, int capacity) {
        R = repetitions;
        N = observations;
        T = triageLevels;
        C = capacity;
        times = new long[T];
        tierCount= new int[T];
    }

    /** Default constructor */
    public ER() {
        R = 10;
        N = 250;
        T = 3;
        C = 10;
        times = new long[T];
        tierCount= new int[T];
    }


    /** simulator */
    private static void simulateER() {

        emergencyRoom er = new emergencyRoom(C); // Instance of EmergencyRoom class with given capacity.

        for (int repetition = 0; repetition < R; repetition++) {

        /*
        The following loop is the principal iteration of our simulation. It performs a given number of observations.
        During each observation, the loop performs two tasks. First, it determines if a new patient arrives to the
        ER and if there is room for that patient in the waiting room. Second, it determines when a patient can be
        examined, and takes the first patient from the front of the line out of the waiting room. That patient is
        always the patient with the highest severity, thanks to the data structure provided in EmergencyRoom class.
         */
            for (int observation = 0; observation < N; observation++) {
                // Toss a coin to determine is a patient arrives.
                if (rng.nextDouble() > 0.3) {
                    int severity = rng.nextInt(T) + 1; // Select a severity for this patient at random.
                    String name = String.format("Patient%03d", observation); // Mockup name for the patient.
                    er.admitPatient(name, severity); // Admit the patient to the waiting room.
                }
                /* Toss a coin to take a patient in an exam room, removing them from the waiting area */
                if (rng.nextDouble() > 0.6) {
                    Patient nextPatient = er.treatNextPatient(); // Pull the first patient from waiting.
                    if (nextPatient != null) { // Just in case waiting area is empty, let's make sure this is actual patient.
                        long waitingTime = System.nanoTime() - nextPatient.getArrivalTime(); // Estimate waiting time.
                        times[nextPatient.getSeverity() - 1] += waitingTime; // Update waiting time accumulator.
                        tierCount[nextPatient.getSeverity() - 1]++; // Update patient count for this triage tier.
                    }
                }
                //er.statusReport();
                //Scanner s = new Scanner(System.in);
                //String st = s.next();
            } // observations loop
        } // repetitions loop
    } // method simulateER

    private static void report() {
        System.out.printf("\n\n====================================\n              ER Simulator\n====================================");
        System.out.printf("\n%20s: %5d", "Repetitions", R);
        System.out.printf("\n%20s: %5d", "Observations", N);
        System.out.printf("\n%20s: %5d", "Triage levels", T);
        System.out.printf("\n%20s: %5d", "Capacity", C);
        System.out.printf("\n\nTier\tPatients\tAverage wait");
        System.out.printf("\nLevel\twaiting\t\ttime");
        for (int tier = 0; tier < T; tier++) {
            long totalTierTime = (times[tier])/((long)R);
            int totalTierCount = 1+(tierCount[tier])/(R); // +1 in case count is 0
            long averageTierTime = totalTierTime/((long)totalTierCount);
            System.out.printf("\n%4d\t%,7d\t\t%,10d", (tier+1), totalTierCount, averageTierTime);

        }
        System.out.printf("\n\n====================================\n\n");
    } // method report

    public static void main(String[] args) {
        ER s = new ER(10,100000,3,15);
        simulateER();
        report();
    }

}
