import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


/**
 * Program to select students, at random, for an oral follow-up to an exam
 */
public class Orals {
    public static void main(String[] args) {
        /**
         * String with student UVIDs. The demo code shows only name initials for privacy.
         * This array is autogenerated from the LOCUS CSV file.
         */
        String[] uvid = {
                "A R", "B J", "B J", "B R", "C M", "C E", "C A", "C R", "C A",
                "D Y", "D D", "D A", "D J", "D J", "G M", "G L", "G S", "H N", "H J",
                "H E", "I G", "J R", "K N", "M J", "M D", "M M", "M M", "O S", "P M",
                "P S", "P Y", "P A", "P A", "R G", "S P", "S K", "S M", "S B", "S A",
                "S P", "T A", "T H", "V V", "W E", "W J"};
        // Initialize random number generator.
        Random rng = new Random();
        // How many students?
        int N = uvid.length;
        // Invite a quarter of students for oral follow-ups.
        int R = N / 4;
        // Students to select from; once selected, remove from availability.
        ArrayList<String> available = new ArrayList<>(Arrays.asList(uvid));
        // Students selected for an oral follow-up.
        ArrayList<String> selected = new ArrayList<>();
        // Randomly select R students.
        while (selected.size() < R) {
            // Select a student, at random, from those still available.
            int r = rng.nextInt(available.size());
            // Move student to the selected group and remove from available pool.
            selected.add(available.remove(r));
        }
        // Report results.
        System.out.printf("Inviting %d/%d students for an oral follow-up.\n", R,N);
        System.out.println(selected);
    }
}
