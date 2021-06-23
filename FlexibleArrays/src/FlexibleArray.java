public class FlexibleArray implements Flexibility {

    private int[] a;
    private int end;
    private int occupied = 0;

    public FlexibleArray() {
        a = new int[1];
        end = 0;
        occupied = 0;
    } // default constructor FlexibleArray

    public int size() { return a.length; }
    public int occupancy() { return occupied; }

    public int[] newArray() { return a;}

    public int[] addElement(int e) {
        int s = size();
        if (occupancy() == s) { // no room ... extend
            int[] b = new int[2*s];
            for (int i = 0; i < s; i++) { b[i] = a[i]; }
            a = b;
        }

        a[end] = e;
        end++;
        occupied++;
        return a;
    } // method addElement

    public int[] addElement(int e, int position) {
        int s = size();
        if (position > s) {
            // extend as much and insert element
            // decide where the end of the array is,
            // for the next simple insertion
        } else {
            // requested position is within current bounds
            // insert amd move the rest to the right.
        }
        return a;
    }


}
