/**
 * Testing utility for a class implementing the Q interface. A typical output for the
 * calls to BBQ.displayQ() below looks like:
 *
 *
 *      Queue status
 *      Capacity 6, size 6, back at [6]:
 *      [ brisket ]  [ rib eye ]  [ ribs ]  [ pulled pork ]  [ corn ]  [ sausage ]
 *
 *      Queue status
 *      Capacity 6, size 6, back at [6]:
 *      [ brisket ]  [ rib eye ]  [ ribs ]  [ pulled pork ]  [ corn ]  [ sausage ]
 *
 *      Queue status
 *      Capacity 6, size 4, back at [4]:
 *      [ ribs ]  [ pulled pork ]  [ corn ]  [ sausage ]  [ ]  [ ]
 *
 *
 *
 * Your design of the Grill.displayQ() method may vary, but it should contain
 * the essential information show above.
 */
public class Grill {
    public static void main(String[] args) {
        // We want to be able to specify capacity of the Q
        BBQ grill = new BBQ(6);

        grill.arrival("brisket");
        grill.arrival("rib eye");
        grill.arrival("ribs");
        grill.arrival("pulled pork");
        grill.arrival("corn");
        grill.arrival("sausage");

        grill.displayQ();

        // There is no room for salmon ...
        grill.arrival("salmon");
        // So the queue should look the same ...
        grill.displayQ();

        // These two removals should clear brisket and rib eye from the front of
        // the queue, movings ribs to the front, and leaving two open spots at the back
        grill.departure();
        grill.departure();

        grill.displayQ();
    }
}
